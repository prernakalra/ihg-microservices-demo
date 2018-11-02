/**
 * 
 */
package com.ihg.model;

/**
 * @author rcgth
 *
 */
public class HotelRoomPriceModel {
	
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
		return "HotelRoomPriceModel [roomType=" + roomType + ", price=" + price + ", currencyCd=" + currencyCd + "]";
	}	

}
