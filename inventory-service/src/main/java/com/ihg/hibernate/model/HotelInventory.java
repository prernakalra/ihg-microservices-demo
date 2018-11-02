package com.ihg.hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HOTEL_ROOM_INVENTORY")
public class HotelInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_ROOM_INVENTORY_ID")
	private long id;
	
	@Column(name="INVENTORY_DATE")
	@Temporal(TemporalType.DATE)
	private Date inventoryDate;
	
	@Column(name="HOTEL_DETAILS_ID")
	private long hotelDetailsId;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotelInventory")
	private List<HotelRoomType> roomTypes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(Date inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public long getHotelDetailsId() {
		return hotelDetailsId;
	}

	public void setHotelDetailsId(long hotelDetailsId) {
		this.hotelDetailsId = hotelDetailsId;
	}
	
	public List<HotelRoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<HotelRoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	@Override
	public String toString() {
		return "HotelInventory [id=" + id + ", inventoryDate=" + inventoryDate + ", hotelDetailsId=" + hotelDetailsId
				+ "]";
	}
}
