/**
 * 
 */
package com.ihg.price.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ihg.price.hibernate.model.HotelPricingInfo;

/**
 * @author rcgth
 *
 */
@Repository
public interface PriceRepository extends JpaRepository<HotelPricingInfo, Long>{
	List<HotelPricingInfo> findByHotelDetailsId(long id);
	
	@Query("SELECT price from HotelPricingInfo price where price.hotelDetailsId IN ?1")
	List<HotelPricingInfo> findByHotelDetailsIds(List<Long> ids);
}
