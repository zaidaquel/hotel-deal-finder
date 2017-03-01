package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "siteID", "language", "currency" })
public class OfferInfo {

	@JsonProperty("siteID")
	private String siteID;
	@JsonProperty("language")
	private String language;
	@JsonProperty("currency")
	private String currency;

	@JsonProperty("siteID")
	public String getSiteID() {
		return siteID;
	}

	@JsonProperty("siteID")
	public void setSiteID(String siteID) {
		this.siteID = siteID;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "OfferInfo [siteID=" + siteID + ", language=" + language + ", currency=" + currency + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(siteID).append(language).append(currency).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof OfferInfo) == false) {
			return false;
		}
		OfferInfo rhs = ((OfferInfo) other);
		return new EqualsBuilder().append(siteID, rhs.siteID).append(language, rhs.language)
				.append(currency, rhs.currency).isEquals();
	}

}