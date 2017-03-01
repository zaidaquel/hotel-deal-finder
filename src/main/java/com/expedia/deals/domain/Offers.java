package com.expedia.deals.domain;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Hotel" })
public class Offers {

	@JsonProperty("Hotel")
	private List<Hotel> hotels = null;

	@JsonProperty("Hotel")
	public List<Hotel> getHotels() {
		return hotels;
	}

	@JsonProperty("Hotel")
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "Offers [hotel=" + hotels + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(hotels).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Offers) == false) {
			return false;
		}
		Offers rhs = ((Offers) other);
		return new EqualsBuilder().append(hotels, rhs.hotels).isEquals();
	}

}