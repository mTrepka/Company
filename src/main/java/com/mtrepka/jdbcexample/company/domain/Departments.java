package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Departments {
	@NotNull
	private String deptNo;
	@NotNull
	private String deptName;
}
