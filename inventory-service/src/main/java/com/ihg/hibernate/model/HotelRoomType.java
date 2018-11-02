package com.ihg.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL_ROOM_TYPE")
public class HotelRoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_ROOM_TYPE_ID")
	private long id;
	
	@Column(name="HOTEL_ROOM_TYPE_DESC")
	private String hotelRoomTypeDesc;
	
	@Column(name="BED_NUM")
	private String bedNum;
	
	@Column(name="STATUS")
	private String status;
	
	/*@Column(name="HOTEL_ROOM_INVENTORY_ID")
	private long hotelRoomInventoryId;*/
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOTEL_ROOM_INVENTORY_ID", nullable = false)
	private HotelInventory hotelInventory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelRoomTypeDesc() {
		return hotelRoomTypeDesc;
	}

	public void setHotelRoomTypeDesc(String hotelRoomTypeDesc) {
		this.hotelRoomTypeDesc = hotelRoomTypeDesc;
	}

	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HotelInventory getHotelInventory() {
		return hotelInventory;
	}

	public void setHotelInventory(HotelInventory hotelInventory) {
		this.hotelInventory = hotelInventory;
	}

	@Override
	public String toString() {
		return "HotelRoomType [id=" + id + ", hotelRoomTypeDesc=" + hotelRoomTypeDesc + ", bedNum=" + bedNum
				+ ", status=" + status + ", hotelInventory=" + hotelInventory + "]";
	}	

}
