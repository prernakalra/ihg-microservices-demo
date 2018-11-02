package com.ihg.model;

import java.util.List;

public class HotelDetails {
	
	private String hotelName;
	private String hotelId;
	private Address address;
	private List<String> amenities;
	private String imageURL;
	private List<String> phones;
	private String rating;
	private List<HotelRoomPriceModel> roompricinginformations;
	
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
	public List<String> getPhones() {
		return phones;
	}
	public void setPhones(List<String> phones) {
		this.phones = phones;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public List<HotelRoomPriceModel> getRoompricinginformations() {
		return roompricinginformations;
	}
	public void setRoompricinginformations(List<HotelRoomPriceModel> roompricinginformations) {
		this.roompricinginformations = roompricinginformations;
	}
	@Override
	public String toString() {
		return "HotelDetails [hotelName=" + hotelName + ", hotelId=" + hotelId + ", address=" + address + ", amenities="
				+ amenities + ", imageURL=" + imageURL + ", phones=" + phones + ", rating=" + rating
				+ ", roompricinginformations=" + roompricinginformations + "]";
	}	

}
