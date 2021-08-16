package com.fis.ormlearn.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

//	@Query("select s from Stock s where year(s.date) = ?1 and month(s.date) = ?2  and s.code= ?3")
//	List<Stock> findByYearAndMonthAndCode(int year, int month, String code);
	List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);

	List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal close);

	List<Stock> findTop3ByOrderByVolumeDesc();

	List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
