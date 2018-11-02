package com.ihg.details.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ihg.details.hibernate.model.HotelAddress;
import com.ihg.details.hibernate.model.HotelAmenity;
import com.ihg.details.hibernate.model.HotelDetails;
import com.ihg.details.model.Address;
import com.ihg.details.model.HotelDetailsModel;
import com.ihg.details.repository.HotelDetailsRepository;

@Service
public class HotelDetailsServiceImpl implements HotelDetailsService{
	
	private static Logger log = LoggerFactory.getLogger(HotelDetailsServiceImpl.class);

	@Autowired
	private HotelDetailsRepository detailRepo;
	
	@Override
	public List<HotelDetailsModel> getAllHotelDetails() throws Exception {
		log.info("Inside HotelDetailsServiceImpl -- getAllHotelDetails");
		List<HotelDetails> details = detailRepo.findAll();
		if(details != null && !details.isEmpty()) {
			return constructHotelDetails(details);
		} else {
			return new ArrayList<>();
		}
	}
	
	@Override
	public HotelDetailsModel getHotelDetailsById(long id) throws Exception {
		log.info("Inside HotelDetailsServiceImpl -- getHotelDetailsById");
		Optional<HotelDetails> details = detailRepo.findById(id);
		if(details.isPresent()) {
			return constructHotelDetails(details.get());
		} else {
			return null;
		}
	}

	@Override
	public List<HotelDetailsModel> getHotelDetailsByLocation(String location) throws Exception {
		log.info("Inside HotelDetailsServiceImpl -- getHotelDetailsByLocation");
		List<HotelDetails> details = detailRepo.findHotelDetailsByLocation(location);
		if(details != null && !details.isEmpty()) {
			return constructHotelDetails(details);
		} else {
			return new ArrayList<>();
		}
	}
	
	private List<HotelDetailsModel> constructHotelDetails(List<HotelDetails> details) throws Exception {
		log.info("Inside HotelDetailsServiceImpl -- constructHotelDetails");
		List<HotelDetailsModel> detailsModel = new ArrayList<>();
		List<HotelAmenity> amenities = null;
		List<String> ameModelList = null;
		List<String> phoneModelList = null;
		
		HotelDetailsModel model = null;
		HotelAddress hotelAddr = null;
		Address addr = null;
		
		for(HotelDetails detail : details ) {
			model = new HotelDetailsModel();
			addr = new Address();
			ameModelList = new ArrayList<>();
			phoneModelList = new ArrayList<>();
			
			model.setHotelId(Long.toString(detail.getId()));
			model.setHotelName(detail.getHotelDesc());
			model.setImageURL(detail.getImageURL());
			model.setRating(detail.getRating());
			
			hotelAddr = detail.getHotelAddress();
			if(hotelAddr != null ) {
				addr.setCity(hotelAddr.getCity()!=null?hotelAddr.getCity():"");
				addr.setCountry(hotelAddr.getCountry()!=null?hotelAddr.getCountry():"");
				addr.setStreetName(hotelAddr.getStreetName()!=null?hotelAddr.getStreetName():"");
				addr.setStreetNumber(hotelAddr.getStreetNum()!=null?hotelAddr.getStreetNum():"");
				addr.setZipCode(Long.toString(hotelAddr.getZip()));
			}
			
			
			model.setAddress(addr);
			
			amenities = detail.getHotelAmenities();
			if(amenities != null && !amenities.isEmpty()) {
				for(HotelAmenity hAme : amenities) {
					ameModelList.add(hAme.getAmenityDesc());
				}
			}			
			
			model.setAmenities(ameModelList);
			
			phoneModelList.add(detail.getPhoneNo());
			model.setPhoneList(phoneModelList);
			
			detailsModel.add(model);
		}
		
		return detailsModel;
		
	}
	
	private HotelDetailsModel constructHotelDetails(HotelDetails detail) throws Exception {
		log.info("Inside HotelDetailsServiceImpl -- constructHotelDetails");
		HotelDetailsModel model = new HotelDetailsModel();
		List<HotelAmenity> amenities = null;
		List<String> ameModelList = new ArrayList<>();
		HotelAddress hotelAddr = null;
		Address addr = new Address();
		
		model.setHotelId(Long.toString(detail.getId()));
		model.setHotelName(detail.getHotelDesc());
		model.setImageURL(detail.getImageURL());
		model.setRating(detail.getRating());
		
		hotelAddr = detail.getHotelAddress();
		if(hotelAddr != null ) {
			addr.setCity(hotelAddr.getCity());
			addr.setCountry(hotelAddr.getCountry());
			addr.setStreetName(hotelAddr.getStreetName());
			addr.setStreetNumber(hotelAddr.getStreetNum());
			addr.setZipCode(Long.toString(hotelAddr.getZip()));
		}
		
		model.setAddress(addr);
		
		amenities = detail.getHotelAmenities();
		if(amenities != null && !amenities.isEmpty()) {
			for(HotelAmenity hAme : amenities) {
				ameModelList.add(hAme.getAmenityDesc());
			}
		}			
		
		model.setAmenities(ameModelList);
		
		model.setPhoneList(getPhoneList(detail.getPhoneNo()));
		
		return model;
	}
	private List<String> getPhoneList(String phonenum) {
		if (phonenum == null) {
			return new ArrayList<>();
		}
		List<String> phoneList = new ArrayList<>();
		if (phonenum.contains(";")) {
			for (String eachPhone : phonenum.split(";")) {
				phoneList.add(eachPhone);
			}
		} else {
			phoneList.add(phonenum);
		}
		return phoneList;
	}


}
