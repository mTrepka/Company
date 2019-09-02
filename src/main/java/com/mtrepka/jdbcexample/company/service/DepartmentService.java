package com.mtrepka.jdbcexample.company.service;

import com.mtrepka.jdbcexample.company.domain.Departments;
import com.mtrepka.jdbcexample.company.domain.Employees;

import java.util.List;

public interface DepartmentService {
	Departments getByNo(String no);
	List<Departments> getAll();
	List<Employees> getEmployeesByDepartmentNo(String no);
}
