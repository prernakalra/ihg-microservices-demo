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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rcgth
 *
 */
@Entity
@Table(name="HOTEL_ADDRESS")
public class HotelAddress implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_ADDRESS_ID")
	private long id;
	
	@Column(name="STREET_NAME")
	private String streetName;
	
	@Column(name="STREET_NUM")
	private String streetNum;
	
	@Column(name="ZIP")
	private long zip;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="HOTEL_DETAILS_ID")
	private HotelDetails hotelDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public HotelDetails getHotelDetails() {
		return hotelDetails;
	}

	public void setHotelDetails(HotelDetails hotelDetails) {
		this.hotelDetails = hotelDetails;
	}

	@Override
	public String toString() {
		return "HotelAddress [id=" + id + ", streetName=" + streetName + ", streetNum=" + streetNum + ", zip=" + zip
				+ ", city=" + city + ", country=" + country + ", hotelDetails=" + hotelDetails + "]";
	}		

}
