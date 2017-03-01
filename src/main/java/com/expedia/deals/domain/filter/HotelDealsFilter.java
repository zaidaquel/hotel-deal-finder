package com.expedia.deals.domain.filter;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class HotelDealsFilter {

	private String destinationName;
	private String destinationCity;
	private String[] regionIds;
	private Date minimumTripStartDate;
	private Date maximumTripStartDate;
	private Integer lengthOfStay;
	private RateRange starRating = new RateRange();
	private RateRange totalRate = new RateRange();
	private RateRange guestRating = new RateRange();

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String[] getRegionIds() {
		if (Objects.isNull(regionIds)) {
			regionIds = new String[] {};
		}
		return regionIds;
	}

	public void setRegionIds(String[] regionIds) {
		this.regionIds = regionIds;
	}

	public Date getMinimumTripStartDate() {
		return minimumTripStartDate;
	}

	public void setMinimumTripStartDate(Date minimumTripStartDate) {
		this.minimumTripStartDate = minimumTripStartDate;
	}

	public Date getMaximumTripStartDate() {
		return maximumTripStartDate;
	}

	public void setMaximumTripStartDate(Date maximumTripStartDate) {
		this.maximumTripStartDate = maximumTripStartDate;
	}

	public Integer getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(Integer lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}

	public RateRange getStarRating() {
		return starRating;
	}

	public void setStarRating(RateRange starRating) {
		if (starRating == null) {
			this.starRating = new RateRange();
		} else {
			this.starRating = starRating;
		}
	}

	public RateRange getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(RateRange totalRate) {
		if (totalRate == null) {
			this.totalRate = new RateRange();
		} else {
			this.totalRate = totalRate;
		}
	}

	public RateRange getGuestRating() {
		return guestRating;
	}

	public void setGuestRating(RateRange guestRating) {
		if (guestRating == null) {
			this.guestRating = new RateRange();
		} else {
			this.guestRating = guestRating;
		}
	}

	@Override
	public String toString() {
		return "HotelDealsFilter [destinationName=" + destinationName + ", destinationCity=" + destinationCity
				+ ", regionIds=" + Arrays.toString(regionIds) + ", minTripStartDate=" + minimumTripStartDate
				+ ", maxTripStartDate=" + maximumTripStartDate + ", lengthOfStay=" + lengthOfStay + ", starRating="
				+ starRating + ", totalRate=" + totalRate + ", guestRating=" + guestRating + "]";
	}

}