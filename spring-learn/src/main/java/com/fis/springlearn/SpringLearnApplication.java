package com.fis.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.controller.EmployeeController;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

//	static ApplicationContext applicationContext;
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Logged from Spring Learn Application");
//		System.out.println("Logged from Spring Learn Application");
//		displayDate();
//		displayCountry();
//		displayCountries();
//		displayEmployee();
//		getEmployeeController();
//		applicationContext = new ClassPathXmlApplicationContext("employee.xml");
//		displayEmployeeControllerAnnotation(applicationContext);

	}

	static void displayDate() throws ParseException {
//		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		System.out.println(date);
//		LOGGER.debug(date.toString());
//		LOGGER.info("END");
	}

	static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
	}

	static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		for (Country country : countries) {
			LOGGER.debug(country.toString());
		}
	}

	static void displayEmployee() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = context.getBean("employee", Employee.class);
		LOGGER.debug("Employee : {}", employee);
	}

	static void getEmployeeController() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);
		LOGGER.debug("Employee : {}", employeeController);
	}

	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext) {
		EmployeeController employeeController = applicationContext.getBean("employeeController",
				EmployeeController.class);
		LOGGER.debug("Employee : {}", employeeController);
	}
}
