package com.ihg.service;

import java.util.List;

import com.ihg.model.HotelDetails;

public interface PropertySearchService {

	public List<HotelDetails> getHotelDetails(String location, String startDate, String endDate, String noOfRooms,
			String noOfAdults) throws Exception;

}
