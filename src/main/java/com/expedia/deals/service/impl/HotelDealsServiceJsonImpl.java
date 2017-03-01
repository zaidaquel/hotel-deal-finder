package com.expedia.deals.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.expedia.deals.domain.Hotel;
import com.expedia.deals.domain.HotelDeals;
import com.expedia.deals.domain.filter.HotelDealsFilter;
import com.expedia.deals.service.DataRetrievalException;
import com.expedia.deals.service.HotelDealsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("hotelDealsService")
public class HotelDealsServiceJsonImpl implements HotelDealsService {

	private final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private final static String PARAM_KEY_MAX_GUEST_RATING = "maxGuestRating";
	private final static String PARAM_KEY_MIN_GUEST_RATING = "minGuestRating";
	private final static String PARAM_KEY_MAX_TOTAL_RATE = "maxTotalRate";
	private final static String PARAM_KEY_MIN_TOTAL_RATE = "minTotalRate";
	private final static String PARAM_KEY_MAX_STAR_RATING = "maxStarRating";
	private final static String PARAM_KEY_MIN_STAR_RATING = "minStarRating";
	private final static String PARAM_KEY_LENGTH_OF_STAY = "lengthOfStay";
	private final static String PARAM_KEY_MAX_TRIP_START_DATE = "maxTripStartDate";
	private final static String PARAM_KEY_MIN_TRIP_START_DATE = "minTripStartDate";
	private final static String PARAM_KEY_REGION_IDS = "regionIds";
	private final static String PARAM_KEY_DESTINATION_CITY = "destinationCity";
	private final static String PARAM_KEY_DESTINATION_NAME = "destinationName";
	private final static String QUERY_STRING_NAME_VALUE_SEPERATOR = "=";
	private final static String QUERY_STRING_START_SEPERATOR = "?";
	private final static String QUERY_STRING_PAIRS_SEPERATOR = "&";
	private final static String CHARSET_UTF_8 = "utf-8";

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Value("${hotel.deals.url}")
	private String hotelDealsJsonUrlSpec;

	/**
	 * Appends filters to hotel deals service URL, retrieves data as JSON,
	 * format it to a list of <code>com.expedia.deals.domain.Hotel</code> and
	 * returns the result.
	 * 
	 * @param hotelDealsFilter
	 *            will be ignored if null.
	 * @return A list of <code>com.expedia.deals.domain.Hotel</code> based on
	 *         the passed filter. <br />
	 *         This method should not return null.
	 */
	public List<Hotel> filter(HotelDealsFilter hotelDealsFilter) {
		validate(hotelDealsFilter);
		URL hotelDealsJsonUrl = buildHotelDealsJsonUrl(hotelDealsFilter);
		logger.info("Hotel Deals JSON URL is {}", hotelDealsJsonUrl);
		try {
			HotelDeals hotelDeals = objectMapper.readValue(hotelDealsJsonUrl, HotelDeals.class);
			return Objects.isNull(hotelDeals.getOffers().getHotels()) ? new ArrayList<Hotel>()
					: hotelDeals.getOffers().getHotels();
		} catch (JsonParseException e) {
			logger.error("Error in parsing/reading data", e);
			throw new DataRetrievalException("Invalid URL", e);
		} catch (JsonMappingException e) {
			logger.error("Error in parsing/reading data", e);
			throw new DataRetrievalException("Invalid URL", e);
		} catch (Exception e) {
			logger.error("Error connecting to service provider:".concat(hotelDealsJsonUrl.toString()), e);
			throw new DataRetrievalException("Error connecting to service provider", e);
		}
	}

	private void validate(HotelDealsFilter hotelDealsFilter) {
		if (StringUtils.isBlank(hotelDealsFilter.getDestinationCity())) {
			throw new DataRetrievalException("Destination City must be provided");
		}
	}

	private URL buildHotelDealsJsonUrl(HotelDealsFilter hotelDealsFilter) {
		try {
			StringBuilder queryString = new StringBuilder();
			queryString.append(hotelDealsJsonUrlSpec);
			queryString.append(hotelDealsJsonUrlSpec.contains(QUERY_STRING_START_SEPERATOR)
					? QUERY_STRING_PAIRS_SEPERATOR : QUERY_STRING_START_SEPERATOR);

			appendFiltersToQueryString(hotelDealsFilter, queryString);
			queryString.replace(queryString.length() - 1, queryString.length(), "");
			return new URL(queryString.toString());
		} catch (MalformedURLException e) {
			logger.error("Invalid URL:".concat(hotelDealsJsonUrlSpec), e);
			throw new DataRetrievalException("Invalid URL", e);
		}
	}

	private void appendFiltersToQueryString(HotelDealsFilter hotelDealsFilter, StringBuilder queryString) {
		if (Objects.isNull(hotelDealsFilter)) {
			return;
		}

		appendToQueryString(PARAM_KEY_DESTINATION_NAME, hotelDealsFilter.getDestinationName(), queryString);
		appendToQueryString(PARAM_KEY_DESTINATION_CITY, hotelDealsFilter.getDestinationCity(), queryString);
		appendToQueryString(PARAM_KEY_REGION_IDS, String.join(",", hotelDealsFilter.getRegionIds()), queryString);
		appendToQueryString(PARAM_KEY_MIN_TRIP_START_DATE, dateAsString(hotelDealsFilter.getMinimumTripStartDate()),
				queryString);
		appendToQueryString(PARAM_KEY_MAX_TRIP_START_DATE, dateAsString(hotelDealsFilter.getMaximumTripStartDate()),
				queryString);
		appendToQueryString(PARAM_KEY_LENGTH_OF_STAY, hotelDealsFilter.getLengthOfStay(), queryString);
		appendToQueryString(PARAM_KEY_MIN_STAR_RATING, hotelDealsFilter.getStarRating().getMinimumRating(),
				queryString);
		appendToQueryString(PARAM_KEY_MAX_STAR_RATING, hotelDealsFilter.getStarRating().getMaximumRating(),
				queryString);
		appendToQueryString(PARAM_KEY_MIN_TOTAL_RATE, hotelDealsFilter.getTotalRate().getMinimumRating(), queryString);
		appendToQueryString(PARAM_KEY_MAX_TOTAL_RATE, hotelDealsFilter.getTotalRate().getMaximumRating(), queryString);
		appendToQueryString(PARAM_KEY_MIN_GUEST_RATING, hotelDealsFilter.getGuestRating().getMinimumRating(),
				queryString);
		appendToQueryString(PARAM_KEY_MAX_GUEST_RATING, hotelDealsFilter.getGuestRating().getMaximumRating(),
				queryString);
	}

	private void appendToQueryString(String key, Object value, StringBuilder queryString) {
		if (Objects.isNull(value) || StringUtils.isBlank(String.valueOf(value))) {
			return;
		}

		try {
			queryString.append(key).append(QUERY_STRING_NAME_VALUE_SEPERATOR)
					.append(URLEncoder.encode(String.valueOf(value), CHARSET_UTF_8))
					.append(QUERY_STRING_PAIRS_SEPERATOR);
		} catch (UnsupportedEncodingException e) {
			logger.warn("Parameter is not added to query String,".concat(key).concat(":").concat(value.toString())
					.toString(), e);
		}
	}

	private String dateAsString(Date date) {
		return Objects.isNull(date) ? StringUtils.EMPTY : DATE_FORMAT.format(date);
	}

}