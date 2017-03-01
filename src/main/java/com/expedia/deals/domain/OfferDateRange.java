package com.expedia.deals.domain;

import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "travelStartDate", "travelEndDate", "lengthOfStay" })
public class OfferDateRange {

	@JsonProperty("travelStartDate")
	private List<Integer> travelStartDate = null;
	@JsonProperty("travelEndDate")
	private List<Integer> travelEndDate = null;
	@JsonProperty("lengthOfStay")
	private Integer lengthOfStay;

	@JsonProperty("travelStartDate")
	public List<Integer> getTravelStartDate() {
		return travelStartDate;
	}

	@JsonProperty("travelStartDate")
	public void setTravelStartDate(List<Integer> travelStartDate) {
		this.travelStartDate = travelStartDate;
	}

	@JsonProperty("travelEndDate")
	public List<Integer> getTravelEndDate() {
		return travelEndDate;
	}

	@JsonProperty("travelEndDate")
	public void setTravelEndDate(List<Integer> travelEndDate) {
		this.travelEndDate = travelEndDate;
	}

	@JsonProperty("lengthOfStay")
	public Integer getLengthOfStay() {
		return lengthOfStay;
	}

	@JsonProperty("lengthOfStay")
	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	@Override
	public String toString() {
		return "OfferDateRange [travelStartDate=" + travelStartDate + ", travelEndDate=" + travelEndDate
				+ ", lengthOfStay=" + lengthOfStay + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(travelStartDate).append(travelEndDate).append(lengthOfStay).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OfferDateRange) == false) {
			return false;
		}
		OfferDateRange rhs = ((OfferDateRange) other);
		return new EqualsBuilder().append(travelStartDate, rhs.travelStartDate).append(travelEndDate, rhs.travelEndDate)
				.append(lengthOfStay, rhs.lengthOfStay).isEquals();
	}

}
