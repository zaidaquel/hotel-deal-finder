package com.expedia.deals.service;

import java.util.List;

import com.expedia.deals.domain.Hotel;
import com.expedia.deals.domain.filter.HotelDealsFilter;

/**
 * Responsible for communicating with Hotel Deals service or repository.
 */
public interface HotelDealsService {

	/**
	 * 
	 * @param hotelDealsFilter
	 *            will be ignored if null.
	 * @return A list of <code>com.expedia.deals.domain.Hotel</code> based on
	 *         the passed filter. <br />
	 *         This method should not return null.
	 */
	public List<Hotel> filter(HotelDealsFilter hotelDealsFilter);
}
