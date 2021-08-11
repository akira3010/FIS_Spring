package com.fis.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean.Employee;
import com.fis.springlearn.controller.EmployeeController;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(SpringLearnApplication.class, args);
//		displayDate();
//		displayCountry();
//		displayCountries();
//		displayEmployee();
		getEmployeeController();

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(EmployeeController.class);
//		displayEmployeeControllerAnnotation(applicationContext);
	}

	public static void displayEmployeeControllerAnnotation(ApplicationContext applicationContext) {
		LOGGER.info("START");
		EmployeeController employeeController = applicationContext.getBean("employeeController",
				EmployeeController.class);
		LOGGER.debug("EmployeeController : {}", employeeController);
		LOGGER.info("END");

	}

	static void getEmployeeController() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		EmployeeController employeeController = context.getBean("controller", EmployeeController.class);
		LOGGER.debug("EmployeeController : {}", employeeController);
		LOGGER.info("END");
	}

	static void displayEmployee() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = context.getBean("employee", Employee.class);
		LOGGER.debug("Employee : {}", employee);
		LOGGER.info("END");
	}

	static void displayCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
	}

	static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country);
		LOGGER.debug("Country : {}", anotherCountry);
	}

	static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date parseDate = format.parse("31/12/2018");
//			System.out.println(parseDate);
			LOGGER.debug(parseDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat format1 = context.getBean("dateFormat1", SimpleDateFormat.class);
		try {
			Date parseDate1 = format1.parse("08/09/2021");
//			System.out.println(parseDate1);
			LOGGER.debug(parseDate1.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

}