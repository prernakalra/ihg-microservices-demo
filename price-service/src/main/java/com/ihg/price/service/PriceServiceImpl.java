/**
 * 
 */
package com.ihg.price.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihg.price.hibernate.model.HotelPricingInfo;
import com.ihg.price.model.HotelRoomPrice;
import com.ihg.price.model.HotelRoomPrice2;
import com.ihg.price.repository.PriceRepository;

/**
 * @author rcgth
 *
 */
@Service
public class PriceServiceImpl implements PriceService{
	
	private static Logger log = LoggerFactory.getLogger(PriceServiceImpl.class);

	@Autowired
	private PriceRepository priceRepo;
	
	@Override
	public List<HotelRoomPrice> getHotelPriceById(long id) throws Exception {
		log.info("Inside PriceServiceImpl -- getHotelPriceById");
		List<HotelPricingInfo> pricingInfo = priceRepo.findByHotelDetailsId(id);
		HotelRoomPrice roomPrice = null;
		List<HotelRoomPrice> roomPrices = new ArrayList<>();
		
		if(pricingInfo != null && !pricingInfo.isEmpty()) {
			for(HotelPricingInfo priceInfo : pricingInfo) {
				roomPrice = new HotelRoomPrice();
				roomPrice.setPrice(priceInfo.getPriceAmt().toString());
				roomPrice.setRoomType(priceInfo.getHotelRoomTypeDesc());
				roomPrice.setCurrencyCd(priceInfo.getCurrencyCd());
				roomPrices.add(roomPrice);
			}
		}
		return roomPrices;
	}
	
	@Override
	public List<HotelRoomPrice2> getHotelPriceByIds(List<Long> ids) throws Exception{
		log.info("Inside PriceServiceImpl -- getHotelPriceById");
		List<HotelPricingInfo> pricingInfo = priceRepo.findByHotelDetailsIds(ids);
		HotelRoomPrice2 roomPrice = null;
		List<HotelRoomPrice2> roomPrices = new ArrayList<>();
		
		if(pricingInfo != null && !pricingInfo.isEmpty()) {
			for(HotelPricingInfo priceInfo : pricingInfo) {
				roomPrice = new HotelRoomPrice2();
				roomPrice.setId(priceInfo.getHotelDetailsId());
				roomPrice.setPrice(priceInfo.getPriceAmt().toString());
				roomPrice.setRoomType(priceInfo.getHotelRoomTypeDesc());
				roomPrice.setCurrencyCd(priceInfo.getCurrencyCd());
				roomPrices.add(roomPrice);
			}
		}
		return roomPrices;
	}

}
