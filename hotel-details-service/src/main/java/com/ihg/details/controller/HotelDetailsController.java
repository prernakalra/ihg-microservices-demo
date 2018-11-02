package com.ihg.details.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.details.model.HotelDetailsModel;
import com.ihg.details.service.HotelDetailsService;

@RestController
@RequestMapping("/api")
public class HotelDetailsController {
	
	private static Logger log = LoggerFactory.getLogger(HotelDetailsController.class);
	
	@Autowired
	private HotelDetailsService detailsService;
	
	@GetMapping("/hotels-all")
	public List<HotelDetailsModel> getHotels() {
		
		List<HotelDetailsModel> hotels = null;
		try {
			log.info("Inside Hotel Details Service Controller -- getHotels");
			hotels = detailsService.getAllHotelDetails();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return hotels;
	}
	
	@GetMapping("/hotels/{id}")
	public HotelDetailsModel getHotelsById(@PathVariable("id") long id) {
		
		HotelDetailsModel hotel = null;
		try {
			log.info("Inside Hotel Details Service Controller -- getHotelsById");
			hotel = detailsService.getHotelDetailsById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return hotel;
	}
	
	@GetMapping("/hotels")
	public List<HotelDetailsModel> getHotelsByLocation(@RequestParam("location") String location) {
		
		List<HotelDetailsModel> hotels = null;
		try {
			log.info("Inside Hotel Details Service Controller -- getHotelsByLocation");
			hotels = detailsService.getHotelDetailsByLocation(location);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return hotels;
	}

}
