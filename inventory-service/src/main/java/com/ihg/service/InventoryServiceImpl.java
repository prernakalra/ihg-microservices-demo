package com.ihg.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihg.hibernate.model.HotelRoomType;
import com.ihg.model.InventoryType;
import com.ihg.model.RoomType;
import com.ihg.repository.InventoryRepository;;

@Service
public class InventoryServiceImpl implements InventoryService{
	
	private static Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
	
	@Autowired
	private InventoryRepository inventoryRepo;
	
	public List<InventoryType> getInventory(long id, String startDate, String endDate) throws Exception {
		log.info("Inside InventoryServiceImpl -- getInventory");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate1 = formatter.parse(startDate);
		Date endDate1 = formatter.parse(endDate);
		
		List<HotelRoomType> roomTypes = inventoryRepo.findHotelInventoryByDateAndId(startDate1, endDate1, id);
		Map<String, List<HotelRoomType>> inventoryMap = new HashMap<>(); 
		List<HotelRoomType> rmTypes = null;
		String dateStr = null;
		
		if(roomTypes != null && !roomTypes.isEmpty()) {
			for(HotelRoomType rmType : roomTypes) {
				dateStr = rmType.getHotelInventory().getInventoryDate().toString();
				if(inventoryMap.containsKey(dateStr)) {
					rmTypes = inventoryMap.get(dateStr);
					rmTypes.add(rmType);
					inventoryMap.put(dateStr, rmTypes);
				} else {
					rmTypes = new ArrayList<>();
					rmTypes.add(rmType);
					inventoryMap.put(dateStr, rmTypes);
				}
			}
		}
		
		return constructInventory(inventoryMap);
		
	}
	
	private List<InventoryType> constructInventory(Map<String, List<HotelRoomType>> inventoryMap) {
		log.info("Inside InventoryServiceImpl -- constructInventory");
		InventoryType inventory =  null;
		List<InventoryType> invenTypes = new ArrayList<>();
		List<RoomType> roomTypes = null;
		List<HotelRoomType> htRmTypes = null;
		RoomType roomType = null;
		
		for (Map.Entry<String, List<HotelRoomType>> entry : inventoryMap.entrySet()) {;
			inventory =  new InventoryType();
			roomTypes = new ArrayList<>();
			
			htRmTypes = entry.getValue();
			for(HotelRoomType rmType : htRmTypes ) {
				roomType = new RoomType();
				roomType.setNumberOfBeds(rmType.getBedNum());
				roomType.setRoomStatus(rmType.getStatus());
				roomType.setRoomtype(rmType.getHotelRoomTypeDesc());
				roomTypes.add(roomType);
			}
			
			inventory.setStatusDate(entry.getKey());
			inventory.setHotelRoomTypes(roomTypes);
			invenTypes.add(inventory);
			
		}
		
		return invenTypes;
	}

}
