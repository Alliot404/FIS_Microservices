package com.fis.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fis.springlearn.Country;
import com.fis.springlearn.repository.CountryRepository;
import com.fis.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		LOGGER.debug("result -> {} ", result.isPresent());
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found !!!");
		} else {
			Country country = result.get();
			return country;
		}
	}
	
	@Transactional
	public List<Country> findByNameContaining(String key) throws CountryNotFoundException {
		List<Country> countryList = countryRepository.findByNameContaining(key);
		LOGGER.debug("Country List -> {} ", countryList);
		if (countryList.isEmpty()) {
			throw new CountryNotFoundException("Country Not Found !!!");
		} else {
			return countryList;
		}
	}

	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	@Transactional
	public void updateCountry(String countryCode, String countryName) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found !!!");
		} else {
			Country country = result.get();
			country.setName(countryName);
			countryRepository.save(country);
		}
	}

	@Transactional
	public void deleteCountry(String countryCode) {
		countryRepository.deleteById(countryCode);
	}

	@Transactional
	public List<Country> searchCountryByName(String name) {
//		return countryRepository.findByNameContaining(name);
//		return countryRepository.findByNameContainingOrderByName(name);
		return countryRepository.findByNameStartingWithOrderByName(name);
	}

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		System.out.println(countries.size());
//		for (Country country : countries) {
//			if (country.getCode().equalsIgnoreCase(code)) {
//				SpringLearnConstants.LOGGER.debug(country.toString());
//				return country;
//			}
//		}
		Country filteredCountry = countries.stream().filter(country -> country.getCode().equalsIgnoreCase(code))
				.findFirst().orElseThrow(() -> new CountryNotFoundException());

		return filteredCountry;
	}
}
