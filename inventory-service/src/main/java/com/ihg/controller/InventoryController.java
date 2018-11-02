package com.ihg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.model.InventoryType;
import com.ihg.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryController {
	
	private static Logger log = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/hotelinventory/{id}")
	public List<InventoryType> getInventoryByHotelIdandDates(@RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate, @PathVariable("id") String id) {
		log.info("Inside Inventory Controller -- getInventoryByHotelIdandDates");
		List<InventoryType> inventoryTypes = null;
		try {
			inventoryTypes = inventoryService.getInventory(Long.parseLong(id), startDate, endDate);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return inventoryTypes;
	}

}
