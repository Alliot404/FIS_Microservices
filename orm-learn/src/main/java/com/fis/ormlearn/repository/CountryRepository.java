package com.fis.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

//	List<Country> findByNameContaining(String name);

//	List<Country> findByNameContainingOrderByName(String name);

	List<Country> findByNameStartingWithOrderByName(String name);

}