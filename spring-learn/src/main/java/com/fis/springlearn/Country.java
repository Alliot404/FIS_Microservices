package com.fis.springlearn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "country")
public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	@Id
	@Column(name = "co_code")
	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;

	@Column(name = "co_name")
	@NotNull
	@Size(max = 50, message = "Country name cannot exceed 50 characters")
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor.");
	}

	public String getCode() {
		LOGGER.debug("Inside Country Code Getter.");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside Country Code Setter.");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside Country Name Getter.");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside Country Name Setter.");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
}
