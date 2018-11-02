/**
 * 
 */
package com.ihg.price.model;

/**
 * @author rcgth
 *
 */
public class HotelRoomPrice {
	
	private String roomType;
	private String price;
	private String currencyCd;
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getCurrencyCd() {
		return currencyCd;
	}
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}
	
	@Override
	public String toString() {
		return "HotelRoomPrice [roomType=" + roomType + ", price=" + price + ", currencyCd=" + currencyCd + "]";
	}	

}
