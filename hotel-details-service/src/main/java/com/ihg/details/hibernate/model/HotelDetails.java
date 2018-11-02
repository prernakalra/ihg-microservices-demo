/**
 * 
 */
package com.ihg.details.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author rcgth
 *
 */
@Entity
@Table(name="HOTEL_DETAILS")
public class HotelDetails implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_ID")
	private long id;
	
	@Column(name="HOTEL_DESC")
	private String hotelDesc;
	
	@Column(name="IMAGE_URL")
	private String imageURL;
	
	@Column(name="PHONE_NUM")
	private String phoneNo;
	
	@Column(name="RATING")
	private String rating;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "hotelDetails", cascade = CascadeType.ALL)
	private HotelAddress hotelAddress;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hotelDetails")
	private List<HotelAmenity> hotelAmenities;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHotelDesc() {
		return hotelDesc;
	}

	public void setHotelDesc(String hotelDesc) {
		this.hotelDesc = hotelDesc;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public HotelAddress getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(HotelAddress hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public List<HotelAmenity> getHotelAmenities() {
		return hotelAmenities;
	}

	public void setHotelAmenities(List<HotelAmenity> hotelAmenities) {
		this.hotelAmenities = hotelAmenities;
	}

	/*@Override
	public String toString() {
		return "HotelDetails [id=" + id + ", hotelDesc=" + hotelDesc + ", imageURL=" + imageURL + ", phoneNo=" + phoneNo
				+ ", rating=" + rating + ", hotelAddress=" + hotelAddress + ", hotelAmenities=" + hotelAmenities + "]";
	}*/
	
}
