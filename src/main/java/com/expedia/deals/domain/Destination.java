package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "regionID", "longName", "country", "province", "city" })
public class Destination {

	@JsonProperty("regionID")
	private String regionID;
	@JsonProperty("longName")
	private String longName;
	@JsonProperty("country")
	private String country;
	@JsonProperty("province")
	private String province;
	@JsonProperty("city")
	private String city;

	@JsonProperty("regionID")
	public String getRegionID() {
		return regionID;
	}

	@JsonProperty("regionID")
	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}

	@JsonProperty("longName")
	public String getLongName() {
		return longName;
	}

	@JsonProperty("longName")
	public void setLongName(String longName) {
		this.longName = longName;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("province")
	public String getProvince() {
		return province;
	}

	@JsonProperty("province")
	public void setProvince(String province) {
		this.province = province;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Destination [regionID=" + regionID + ", longName=" + longName + ", country=" + country + ", province="
				+ province + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(regionID).append(longName).append(country).append(province).append(city)
				.toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Destination) == false) {
			return false;
		}
		Destination rhs = ((Destination) other);
		return new EqualsBuilder().append(regionID, rhs.regionID).append(longName, rhs.longName)
				.append(country, rhs.country).append(province, rhs.province).append(city, rhs.city).isEquals();
	}

}