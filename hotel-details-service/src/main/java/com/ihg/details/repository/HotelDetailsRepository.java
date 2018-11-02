package com.ihg.details.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ihg.details.hibernate.model.HotelDetails;

@Repository
public interface HotelDetailsRepository extends JpaRepository<HotelDetails, Long>{
	
	@Query("SELECT hd FROM HotelDetails hd WHERE hd.hotelAddress.city = ?1")
	List<HotelDetails> findHotelDetailsByLocation(String location);

}
