package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "persona", "userId" })
public class UserInfo {

	@JsonProperty("persona")
	private Persona persona;
	@JsonProperty("userId")
	private String userId;

	@JsonProperty("persona")
	public Persona getPersona() {
		return persona;
	}

	@JsonProperty("persona")
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserInfo [persona=" + persona + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(persona).append(userId).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof UserInfo) == false) {
			return false;
		}
		UserInfo rhs = ((UserInfo) other);
		return new EqualsBuilder().append(persona, rhs.persona).append(userId, rhs.userId).isEquals();
	}

}