package com.mtrepka.jdbcexample.company.configuration.rest;


import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/employees/")
@RequiredArgsConstructor
public class RestEmployees {
	private final EmployeesService employeesService;

	@PostMapping("/")
	ResponseEntity putEmployee(@RequestBody Employees emp) {
		try {
			employeesService.saveEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/")
	ResponseEntity deleteEmployee(@RequestBody Employees emp) {
		try {
			employeesService.deleteEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/")
	ResponseEntity patchEmployee(@RequestBody Employees emp) {
		try {
			employeesService.updateEmployee(emp);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	Employees getEmployeesByNo(@PathVariable("id") Integer id) {
		return employeesService.getEmployeeByNo(id);
	}
}
