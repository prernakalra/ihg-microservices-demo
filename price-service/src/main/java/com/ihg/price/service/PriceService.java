/**
 * 
 */
package com.ihg.price.service;

import java.util.List;

import com.ihg.price.model.HotelRoomPrice;
import com.ihg.price.model.HotelRoomPrice2;

/**
 * @author rcgth
 *
 */
public interface PriceService {
	public List<HotelRoomPrice> getHotelPriceById(long id) throws Exception;
 
	public List<HotelRoomPrice2> getHotelPriceByIds(List<Long> ids) throws Exception;

}
