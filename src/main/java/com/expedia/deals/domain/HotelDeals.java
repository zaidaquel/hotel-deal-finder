package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "offerInfo", "userInfo", "offers" })
public class HotelDeals {

	@JsonProperty("offerInfo")
	private OfferInfo offerInfo;
	@JsonProperty("userInfo")
	private UserInfo userInfo;
	@JsonProperty("offers")
	private Offers offers;

	@JsonProperty("offerInfo")
	public OfferInfo getOfferInfo() {
		return offerInfo;
	}

	@JsonProperty("offerInfo")
	public void setOfferInfo(OfferInfo offerInfo) {
		this.offerInfo = offerInfo;
	}

	@JsonProperty("userInfo")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	@JsonProperty("userInfo")
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@JsonProperty("offers")
	public Offers getOffers() {
		return offers;
	}

	@JsonProperty("offers")
	public void setOffers(Offers offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "HotelDeals [offerInfo=" + offerInfo + ", userInfo=" + userInfo + ", offers=" + offers + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(offerInfo).append(userInfo).append(offers).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HotelDeals) == false) {
			return false;
		}
		HotelDeals rhs = ((HotelDeals) other);
		return new EqualsBuilder().append(offerInfo, rhs.offerInfo).append(userInfo, rhs.userInfo)
				.append(offers, rhs.offers).isEquals();
	}

}