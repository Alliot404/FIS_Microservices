package com.fis.ormlearn;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fis.ormlearn.model.Country;
import com.fis.ormlearn.model.Department;
import com.fis.ormlearn.model.Employee;
import com.fis.ormlearn.model.Skill;
import com.fis.ormlearn.repository.StockRepository;
import com.fis.ormlearn.service.CountryService;
import com.fis.ormlearn.service.DepartmentService;
import com.fis.ormlearn.service.EmployeeService;
import com.fis.ormlearn.service.SkillService;
import com.fis.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockRepository stockRepository;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

//		countryService = context.getBean(CountryService.class);
//		testGetAllCountries();
//		getAllCountriesTest();
//		testAddCountry();
//		testUpdateCountry();
//		testDeleteCountry();
//		testSearchCountryByName();

//		stockRepository = context.getBean(StockRepository.class);
//		testfindByCodeAndDateBetween();
//		testfindByCodeAndPriceGreaterThan();
//		testTop3ByOrderByVolumeDesc();
//		testfindTop3ByCodeOrderByCloseAsc();

		employeeService = context.getBean(EmployeeService.class);
//		testGetEmployee();
		departmentService = context.getBean(DepartmentService.class);
		testAddEmployee();
//		testUpdateEmployee();
//		testGetDepartment();
//		skillService = context.getBean(SkillService.class);
//		testAddSkillToEmployee();

//		testGetAllPermanentEmployees();
//		testgetAverageSalary();
//		testgetAverageSalary(3);
//		testgetAllEmployeesNative();
	}

	private static void testgetAllEmployeesNative() {
		LOGGER.info("Start");
		LOGGER.debug("Employees Using Native Query:{}", employeeService.getAllEmployeesNative());
		LOGGER.info("End");
	}

	private static void testgetAverageSalary(int id) {
		LOGGER.info("Start");
		LOGGER.debug("Average Salary Based on Department:{}", employeeService.getAverageSalary(id));
		LOGGER.info("End");
	}

	private static void testgetAverageSalary() {
		LOGGER.info("Start");
		LOGGER.debug("Average Salary:{}", employeeService.getAverageSalary());
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		Employee employee = employeeService.get(5);
		Skill skill = skillService.get(1);

		employee.getSkillList().add(skill);

		employeeService.save(employee);
	}

	private static void testGetDepartment() {
		Department department = departmentService.get(3);
		LOGGER.debug("Employee List:{}", department.getEmployeeList());
	}

	private static void testUpdateEmployee() {
		Employee employee = employeeService.get(5);

		Department department = departmentService.get(3);
		employee.setDepartment(department);

		employeeService.save(employee);
	}

	private static void testAddEmployee() {
		Employee employee = new Employee();
//		employee.setId(5);
		employee.setName("Janani");
		employee.setSalary(500000);
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());

//		Department department = departmentService.get(2);
//		employee.setDepartment(department);

		employeeService.save(employee);

	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		try {
			Country country = countryService.findCountryByCode("IND");
			LOGGER.debug("Country:{}", country);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		Country country = new Country();
		country.setCode("ZZ");
		country.setName("ZooZoo");
		countryService.addCountry(country);
		try {
			LOGGER.debug("Country:{}", countryService.findCountryByCode("ZZ"));
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testUpdateCountry() {
		try {
			countryService.updateCountry("ZZ", "ZuuZuu");
			LOGGER.debug("Country:{}", countryService.findCountryByCode("ZZ"));
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void testDeleteCountry() {
		countryService.deleteCountry("ZZ");
	}

	private static void testSearchCountryByName() {
//		LOGGER.debug("countries={}", countryService.searchCountryByName("ou"));
		LOGGER.debug("countries={}", countryService.searchCountryByName("z"));
	}

	private static void testfindByCodeAndDateBetween() {
		LOGGER.debug("stocks={}",
				stockRepository.findByCodeAndDateBetween("FB",
						new GregorianCalendar(2019, Calendar.SEPTEMBER, 1).getTime(),
						new GregorianCalendar(2019, Calendar.SEPTEMBER, 30).getTime()));
	}

	private static void testfindByCodeAndPriceGreaterThan() {
		LOGGER.debug("stocks={}", stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal(1250)));
	}

	private static void testTop3ByOrderByVolumeDesc() {
		LOGGER.debug("stocks={}", stockRepository.findTop3ByOrderByVolumeDesc());
	}

	public static void testfindTop3ByCodeOrderByCloseAsc() {
		LOGGER.debug("stocks={}", stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX"));
	}

}
