package com.fis.springlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.springlearn.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByNameContaining(String name);
	
//	List<Country> findByNameContainingOrderByName(String name);
	
	List<Country> findByNameStartingWithOrderByName(String name);


}