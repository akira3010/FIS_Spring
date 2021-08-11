package com.fis.springjdbc.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springjdbc.product.Product;
import com.fis.springjdbc.product.ProductDAOImpl;

public class TestEmployee {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		EmployeeDAOImpl bean = context.getBean("employeeDao", EmployeeDAOImpl.class);

		System.out.println("===============================");
		System.out.println("Insert an Employee");
		Employee newEmployee = new Employee();
		newEmployee.setId(30);
		newEmployee.setName("eraser");
		bean.insertEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Delete Employee");
		int id = 1;
		bean.deleteEmployee(id);
		System.out.println("===============================");
		System.out.println("Get Employee Based on Id");
		id = 2;
		Employee employeeById = bean.getEmployeeById(id);
		System.out.println(employeeById);
		System.out.println("===============================");
		System.out.println("Update Employee");
		newEmployee = new Employee();
		newEmployee.setId(3);
		newEmployee.setName("browneraser");
		bean.updateEmployee(newEmployee);
		System.out.println("===============================");
		System.out.println("Get All Employees");
		System.out.println(bean.getAllEmployees());
		System.out.println("===============================");

		context.close();
	}

}
