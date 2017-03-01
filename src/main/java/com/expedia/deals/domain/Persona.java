package com.expedia.deals.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "personaType" })
public class Persona {

	@JsonProperty("personaType")
	private String personaType;

	@JsonProperty("personaType")
	public String getPersonaType() {
		return personaType;
	}

	@JsonProperty("personaType")
	public void setPersonaType(String personaType) {
		this.personaType = personaType;
	}

	@Override
	public String toString() {
		return "Persona [personaType=" + personaType + "]";
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(personaType).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Persona) == false) {
			return false;
		}
		Persona rhs = ((Persona) other);
		return new EqualsBuilder().append(personaType, rhs.personaType).isEquals();
	}

}