package com.expedia.deals.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Helper methods for use in Spring MVC Controllers.
 *
 */
public class WebUtils {

	/**
	 * Adds all parameters submitted by the request to the passed
	 * <code>org.springframework.ui.ModelMap</code>.
	 * 
	 * @param modelMap
	 *            <code>org.springframework.ui.ModelMap</code> which should be
	 *            holding data to be sent to the UI/request caller.
	 * 
	 */
	public static void populateHttpServletRequestParametersFromModelMap(ModelMap modelMap) {
		final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		final Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String param = parameterNames.nextElement();
			modelMap.addAttribute(param, request.getParameter(param));
		}
	}
}