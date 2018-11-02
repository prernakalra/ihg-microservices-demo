/**
 * 
 */
package com.ihg.price.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rcgth
 *
 */
@Entity
@Table(name="HOTEL_PRICING_INFO")
public class HotelPricingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOTEL_PRICING_INFO_ID")
	private long id;
	
	@Column(name="PRICE_AMT")
	private BigDecimal priceAmt;
	
	@Column(name="CURRENCY_CD")
	private String currencyCd;
	
	@Column(name="HOTEL_ROOM_TYPE_DESC")
	private String hotelRoomTypeDesc;
	
	@Column(name="HOTEL_DETAILS_ID")
	private long hotelDetailsId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPriceAmt() {
		return priceAmt;
	}

	public void setPriceAmt(BigDecimal priceAmt) {
		this.priceAmt = priceAmt;
	}
	
	public String getCurrencyCd() {
		return currencyCd;
	}

	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd;
	}

	public String getHotelRoomTypeDesc() {
		return hotelRoomTypeDesc;
	}

	public void setHotelRoomTypeDesc(String hotelRoomTypeDesc) {
		this.hotelRoomTypeDesc = hotelRoomTypeDesc;
	}

	public long getHotelDetailsId() {
		return hotelDetailsId;
	}

	public void setHotelDetailsId(long hotelDetailsId) {
		this.hotelDetailsId = hotelDetailsId;
	}

	@Override
	public String toString() {
		return "HotelPricingInfo [id=" + id + ", priceAmt=" + priceAmt + ", currencyCd=" + currencyCd
				+ ", hotelRoomTypeDesc=" + hotelRoomTypeDesc + ", hotelDetailsId=" + hotelDetailsId + "]";
	}	

}
