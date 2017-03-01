package com.expedia.deals.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.expedia.deals.domain.filter.HotelDealsFilter;
import com.expedia.deals.domain.filter.RateRange;
import com.expedia.deals.service.DataRetrievalException;
import com.expedia.deals.service.HotelDealsService;
import com.expedia.deals.utils.WebUtils;

@Controller
@RequestMapping("/deals")
public class HotelDealsController {

	public HotelDealsController() {
		System.out.println("CONTRRRR");
	}

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HotelDealsService hotelDealsService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "filterHotelDeals", method = RequestMethod.GET)
	public String search() {
		return "hotelDeals";
	}

	@RequestMapping(value = "filterHotelDeals", method = RequestMethod.POST)
	public String search(ModelMap modelMap, @RequestParam String destinationName, @RequestParam String destinationCity,
			@RequestParam String regionIds, @RequestParam Date minTripStartDate, @RequestParam Date maxTripStartDate,
			@RequestParam Integer lengthOfStay, @RequestParam Double minStarRating, @RequestParam Double maxStarRating,
			@RequestParam Integer minTotalRate, @RequestParam Integer maxTotalRate, @RequestParam Double minGuestRating,
			@RequestParam Double maxGuestRating) {

		WebUtils.populateHttpServletRequestParametersFromModelMap(modelMap);

		HotelDealsFilter hotelDealsFilter = new HotelDealsFilter();
		hotelDealsFilter.setDestinationCity(destinationCity);
		hotelDealsFilter.setDestinationName(destinationName);
		hotelDealsFilter.setGuestRating(new RateRange(minGuestRating, maxGuestRating));
		hotelDealsFilter.setLengthOfStay(lengthOfStay);
		hotelDealsFilter.setMinimumTripStartDate(minTripStartDate);
		hotelDealsFilter.setMaximumTripStartDate(maxTripStartDate);
		hotelDealsFilter.setRegionIds(Objects.isNull(regionIds) ? null : regionIds.split(","));
		hotelDealsFilter.setStarRating(new RateRange(minStarRating, maxStarRating));
		hotelDealsFilter.setTotalRate(new RateRange(minTotalRate, maxTotalRate));
		try {
			modelMap.put("deals", hotelDealsService.filter(hotelDealsFilter));
		} catch (DataRetrievalException e) {
			logger.error("Error", e);
			modelMap.put("errorMessage", e.getMessage());
		}

		return "hotelDeals";
	}
}