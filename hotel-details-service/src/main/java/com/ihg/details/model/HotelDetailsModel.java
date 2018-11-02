package com.ihg.details.model;

import java.util.List;

public class HotelDetailsModel {
	
	private String hotelName;
	private String hotelId;
	private Address address;
	private List<String> amenities;
	private String imageURL;
	private List<String> phoneList;
	private String rating;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public List<String> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "HotelDetails [hotelName=" + hotelName + ", hotelId=" + hotelId + ", address=" + address + ", amenities="
				+ amenities + ", imageURL=" + imageURL + ", phoneList=" + phoneList + ", rating=" + rating + "]";
	}	

}
