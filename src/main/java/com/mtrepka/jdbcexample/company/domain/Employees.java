package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Employees {
	private int empNO;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date hireDate;
}
