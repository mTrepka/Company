package com.mtrepka.jdbcexample.company.configuration;

import com.mtrepka.jdbcexample.company.domain.Departments;
import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.domain.Gender;
import com.mtrepka.jdbcexample.company.service.DepartmentService;
import com.mtrepka.jdbcexample.company.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Rest {
	private final EmployeesService employeesService;
	private final DepartmentService departmentService;

	@PutMapping("/employees/")
	ResponseEntity putEmployee(@RequestBody Employees emp) {
		try {
			employeesService.saveEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/employees/")
	ResponseEntity deleteEmployee(@RequestBody Employees emp) {
		try {
			employeesService.deleteEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@PatchMapping("/employees/")
	ResponseEntity patchEmployee(@RequestBody Employees emp) {
		try {
			employeesService.updateEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/employees/")
	List<Employees> getAllEmployees() {
		return employeesService.getAllEmployees();
	}

	@GetMapping("/employees/id/{id}")
	Employees getEmployeesByNo(@PathVariable("id") Integer id) {
		return employeesService.getEmployeeByNo(id);
	}

	@GetMapping("/employees/department/{id}")
	List<Employees> getEmployeesByDepartment(@PathVariable("id") String id) {
		return departmentService.getEmployeesByDepartmentNo(id);
	}


	@GetMapping("/department/")
	List<Departments> getAllDepartments() {
		return departmentService.getAll();
	}

	@GetMapping("/department/id/{id}")
	Departments getDepartmentByNo(@PathVariable("id") String id) {
		return departmentService.getByNo(id);
	}

}
