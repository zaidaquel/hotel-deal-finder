package com.expedia.deals.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.expedia.deals.config.SpringProfiles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test.xml" })
@ActiveProfiles(SpringProfiles.PROFILE_TEST)
public class HotelDealsServiceTest {

	private static final String FIELD_NAME_HOTEL_DEALS_JSON_URL_SPEC = "hotelDealsJsonUrlSpec";
	private static final String MALFORMED_URL = "MalformedURL";
	private static final String INVALID_SERVICE_PROVIDER_URL = "http:\\100.20.20.11:18080";

	@Value("${hotel.deals.url}")
	private String hotelDealsJsonUrl;

	@Autowired
	private HotelDealsService hotelDealsService;

	@Test
	public void given_EmptyDealsFilter_when_findHotelDeals_then_ReturnNonEmptyListOfDeals() {
		setHotelDealsJsonUrl(hotelDealsJsonUrl);
		org.junit.Assert.assertFalse(hotelDealsService.filter(null).isEmpty());
	}

	@Test(expected = DataRetrievalException.class)
	public void given_EmptyDealsFilter_when_findHotelDeals_and_MalformedServiceProviderUrl_then_ThrowDataRetrievalException() {
		setHotelDealsJsonUrl(MALFORMED_URL);
		org.junit.Assert.assertFalse(hotelDealsService.filter(null).isEmpty());
	}

	@Test(expected = DataRetrievalException.class)
	public void given_EmptyDealsFilter_when_findHotelDeals_and_InvalidServiceProviderUrl_then_ThrowDataRetrievalException() {
		setHotelDealsJsonUrl(INVALID_SERVICE_PROVIDER_URL);
		org.junit.Assert.assertFalse(hotelDealsService.filter(null).isEmpty());
	}

	private void setHotelDealsJsonUrl(String urlAsString) {
		ReflectionTestUtils.setField(hotelDealsService, FIELD_NAME_HOTEL_DEALS_JSON_URL_SPEC, urlAsString);
	}

}
