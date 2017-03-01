package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hotelInfositeUrl", "hotelSearchResultUrl" })
public class HotelUrls {

	@JsonProperty("hotelInfositeUrl")
	private String hotelInfositeUrl;
	@JsonProperty("hotelSearchResultUrl")
	private String hotelSearchResultUrl;

	@JsonProperty("hotelInfositeUrl")
	public String getHotelInfositeUrl() {
		return hotelInfositeUrl;
	}

	@JsonProperty("hotelInfositeUrl")
	public void setHotelInfositeUrl(String hotelInfositeUrl) {
		this.hotelInfositeUrl = hotelInfositeUrl;
	}

	@JsonProperty("hotelSearchResultUrl")
	public String getHotelSearchResultUrl() {
		return hotelSearchResultUrl;
	}

	@JsonProperty("hotelSearchResultUrl")
	public void setHotelSearchResultUrl(String hotelSearchResultUrl) {
		this.hotelSearchResultUrl = hotelSearchResultUrl;
	}

	@Override
	public String toString() {
		return "HotelUrls [hotelInfositeUrl=" + hotelInfositeUrl + ", hotelSearchResultUrl=" + hotelSearchResultUrl
				+ "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(hotelInfositeUrl).append(hotelSearchResultUrl).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof HotelUrls) == false) {
			return false;
		}
		HotelUrls rhs = ((HotelUrls) other);
		return new EqualsBuilder().append(hotelInfositeUrl, rhs.hotelInfositeUrl)
				.append(hotelSearchResultUrl, rhs.hotelSearchResultUrl).isEquals();
	}

}
