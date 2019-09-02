package com.mtrepka.jdbcexample.company.service;

import com.mtrepka.jdbcexample.company.domain.Employees;

import java.util.List;

public interface EmployeesService {
	Employees getEmployeeByNo(int no);
	List<Employees> getAllEmployees();

	void saveEmployee(Employees employee);

	void updateEmployee(Employees employees);

	void deleteEmployee(Employees emp);
}
