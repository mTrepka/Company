package com.mtrepka.jdbcexample.company.configuration.rest;


import com.mtrepka.jdbcexample.company.domain.Departments;
import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/department/")
@RequiredArgsConstructor
public class RestDepartment {
	private final DepartmentService departmentService;

	@PostMapping("/")
	ResponseEntity putDepartment(@RequestBody @Valid Departments dep) {
		try {
			departmentService.saveDepartment(dep);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/")
	ResponseEntity deleteDepartment(@RequestBody @Valid Departments dep) {
		try {
			departmentService.deleteDepartment(dep);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/")
	ResponseEntity patchDepartment(@RequestBody @Valid Departments dep) {
		try {
			departmentService.updateDepartment(dep);
		} catch (Exception exception) {
			return new ResponseEntity(HttpStatus.CONFLICT);
		}
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	Departments getDepartmentByNo(@PathVariable("id") Integer id) {
		return departmentService.getDepartmentByNo(id);
	}
}
