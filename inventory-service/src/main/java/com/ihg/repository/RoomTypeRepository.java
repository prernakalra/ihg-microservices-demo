package com.ihg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ihg.hibernate.model.HotelRoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<HotelRoomType, Long>{
	
}
