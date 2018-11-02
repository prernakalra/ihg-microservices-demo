/**
 * 
 */
package com.ihg.price.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ihg.price.model.HotelRoomPrice;
import com.ihg.price.model.HotelRoomPrice2;
import com.ihg.price.service.PriceService;

/**
 * @author rcgth
 *
 */
@RestController
@RequestMapping("/api")
public class PriceController {
	
	private static Logger log = LoggerFactory.getLogger(PriceController.class);
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/hotelprice/{id}")
	public List<HotelRoomPrice> getHotelPriceById(@PathVariable("id") long id) {
		List<HotelRoomPrice> priceList = null;
		try {
			log.info("Inside PriceController -- getHotelPriceById");
			priceList = priceService.getHotelPriceById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return priceList;
	}	
	
	@GetMapping("/hotelpriceids/{ids}")
	public List<HotelRoomPrice2> getHotelPriceByIdList(@PathVariable("ids") List<Long> ids) {
		List<HotelRoomPrice2> priceList = null;
		try {
			log.info("Inside PriceController -- getHotelPriceByIdList");
			priceList = priceService.getHotelPriceByIds(ids);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return priceList;
	}

}
