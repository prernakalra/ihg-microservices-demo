/**
 * 
 */
package com.ihg.details.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rcgth
 *
 */
@Entity
@Table(name="HOTEL_AMENITY")
public class HotelAmenity implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_AMENITY_ID")
	private long id;
	
	@Column(name="HOTEL_AMENITY_DESC")
	private String amenityDesc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HOTEL_DETAIL_ID", nullable = false)
	private HotelDetails hotelDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAmenityDesc() {
		return amenityDesc;
	}

	public void setAmenityDesc(String amenityDesc) {
		this.amenityDesc = amenityDesc;
	}

	public HotelDetails getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(HotelDetails hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	@Override
	public String toString() {
		return "HotelAmenity [id=" + id + ", amenityDesc=" + amenityDesc + ", hotelDetails=" + hotelDetails + "]";
	}

}
