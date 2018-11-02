package com.ihg.model;

import java.util.List;

public class InventoryTypeModel {

	private String statusDate;
	
	private List<RoomTypeModel> hotelRoomTypes;

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public List<RoomTypeModel> getHotelRoomTypes() {
		return hotelRoomTypes;
	}

	public void setHotelRoomTypes(List<RoomTypeModel> hotelRoomTypes) {
		this.hotelRoomTypes = hotelRoomTypes;
	}

	@Override
	public String toString() {
		return "InventoryType [statusDate=" + statusDate + ", hotelRoomTypes=" + hotelRoomTypes + "]";
	}

}
