package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Salaries {
	private int empId;
	private int salary;
	private Date fromDate;
	private Date toDate;
}
