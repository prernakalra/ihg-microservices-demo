package com.ihg.model;

import java.util.List;

public class InventoryType {

	private String statusDate;
	
	private List<RoomType> hotelRoomTypes;

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public List<RoomType> getHotelRoomTypes() {
		return hotelRoomTypes;
	}

	public void setHotelRoomTypes(List<RoomType> hotelRoomTypes) {
		this.hotelRoomTypes = hotelRoomTypes;
	}

	@Override
	public String toString() {
		return "InventoryType [statusDate=" + statusDate + ", hotelRoomTypes=" + hotelRoomTypes + "]";
	}

}
