package com.ihg.details.service;

import java.util.List;

import com.ihg.details.model.HotelDetailsModel;

public interface HotelDetailsService {

	public List<HotelDetailsModel> getAllHotelDetails() throws Exception;

	public HotelDetailsModel getHotelDetailsById(long id) throws Exception;
	
	public List<HotelDetailsModel> getHotelDetailsByLocation(String location) throws Exception;

}
