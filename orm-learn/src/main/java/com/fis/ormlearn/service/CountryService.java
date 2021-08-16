package com.fis.ormlearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fis.ormlearn.model.Country;
import com.fis.ormlearn.repository.CountryRepository;
import com.fis.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) {
			throw new CountryNotFoundException("Country Not Found !!!");
		} else {
			Country country = result.get();
			return country;
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
}
