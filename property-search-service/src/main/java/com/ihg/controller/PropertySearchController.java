package com.ihg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.model.HotelDetails;
import com.ihg.service.PropertySearchService;

@RestController
@RequestMapping("/api")
public class PropertySearchController {
	
	private static Logger log = LoggerFactory.getLogger(PropertySearchController.class);
	
	@Autowired
	private PropertySearchService searchService;
	
	@GetMapping("/hotel")
	public List<HotelDetails> getHotelDetails(
			@RequestParam("location") String location, 
			@RequestParam("startdate") String startDate, 
			@RequestParam("enddate") String endDate, 
			@RequestParam("numberofrooms") String noOfRooms, 
			@RequestParam("numberofadults") String noOfAdults ) {
		
		log.info("Inside PropertySearchController -- getHotelDetails");
		
		List<HotelDetails> hotels = null;
		try {
			hotels = searchService.getHotelDetails(location, startDate, endDate, noOfRooms, noOfAdults);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return hotels;
	}

}
