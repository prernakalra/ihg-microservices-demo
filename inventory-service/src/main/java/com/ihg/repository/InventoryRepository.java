package com.ihg.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ihg.hibernate.model.HotelInventory;
import com.ihg.hibernate.model.HotelRoomType;

@Repository
public interface InventoryRepository extends JpaRepository<HotelInventory, Long>{
	List<HotelInventory> findById(long id);
	
	// @Query("SELECT h FROM HotelInventory h WHERE h.inventoryDate BETWEEN :date1 AND :date2")
	// public List<HotelInventory> findByInventoryDate(@Param("startDate") Date date1, @Param("endDate") Date date2);
	 
	 @Query("SELECT rt FROM HotelRoomType rt WHERE rt.hotelInventory.inventoryDate BETWEEN ?1 AND ?2 AND rt.hotelInventory.hotelDetailsId = ?3")
	 public List<HotelRoomType> findHotelInventoryByDateAndId(Date date1, Date date2, long hotelId);
}