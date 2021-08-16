package com.fis.springlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.springlearn.Country;
import com.fis.springlearn.service.CountryService;
import com.fis.springlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {
	@Autowired
	private CountryService countryService;

//	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return countryService.findCountryByCode(code);
	}

	@GetMapping
	public List<Country> findByNameContaining(@RequestParam String key) throws CountryNotFoundException {
		return countryService.findByNameContaining(key);
	}

	@PostMapping
	public void addCountry(@RequestBody Country country) {
		countryService.addCountry(country);
	}

	@PutMapping
	public void updateCountry(@RequestBody Country country) throws CountryNotFoundException {
		String countryCode = country.getCode();
		String countryName = country.getName();
		countryService.updateCountry(countryCode, countryName);
	}

	@DeleteMapping("/{code}")
	public void deleteCountry(@PathVariable String code) {
		countryService.deleteCountry(code);
	}

//	@RequestMapping("/country")
//	public Country getCountryIndia() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("country", Country.class);
//		SpringLearnConstants.LOGGER.debug("Country : {}", country);
//		return country;
//	}
//
//	@GetMapping("/countries")
//	public ArrayList<Country> getCountries() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
//		for (Country country : countries) {
//			SpringLearnConstants.LOGGER.debug(country.toString());
//		}
//		return countries;
//	}
//
//	@GetMapping("/countries/{code}")
//	public Country getCountry(@PathVariable String code)throws CountryNotFoundException {
//		return countryService.getCountry(code);
//	}

}
