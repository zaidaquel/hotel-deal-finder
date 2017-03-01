package com.expedia.deals.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.expedia.deals.config.SpringProfiles;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-test.xml" })
@ActiveProfiles(SpringProfiles.PROFILE_TEST)
public class HotelDealsControllerTest {

	private static final String FILTER_HOTEL_DEALS_RELATIVE_PATH = "/deals/filterHotelDeals.htm";
	@Autowired
	private HotelDealsController hotelDealsController;

	@Test
	public void given_UserOnFilterDealsView_when_Search_then_StatusIsOk_and_ResultIsRetrievedAsAList()
			throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hotelDealsController).build();
		mockMvc.perform(post(FILTER_HOTEL_DEALS_RELATIVE_PATH).param("destinationName", "Four Seasons")
				.param("destinationCity", "Amman").param("regionIds", "100200").param("minTripStartDate", "2017-01-01")
				.param("maxTripStartDate", "").param("lengthOfStay", "").param("minStarRating", "")
				.param("maxStarRating", "").param("minTotalRate", "").param("maxTotalRate", "100")
				.param("minGuestRating", "1").param("maxGuestRating", "")).andExpect(status().isOk())
				.andExpect(model().attribute("deals", Matchers.isA(List.class)));
	}

}