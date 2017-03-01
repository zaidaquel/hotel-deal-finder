package com.expedia.deals.domain.filter;

public class RateRange {

	private final Number minimumRating;
	private final Number maximumRating;

	public RateRange() {
		this(null, null);
	}

	public RateRange(Number minimumRating, Number maximumRating) {
		this.minimumRating = minimumRating;
		this.maximumRating = maximumRating;
	}

	public Number getMinimumRating() {
		return minimumRating;
	}

	public Number getMaximumRating() {
		return maximumRating;
	}

	@Override
	public String toString() {
		return "RateRange [minimumRating=" + minimumRating + ", maximumRating=" + maximumRating + "]";
	}

}