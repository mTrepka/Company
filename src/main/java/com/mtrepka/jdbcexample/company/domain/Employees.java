package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class Employees {
	@NotNull
	private int empNO;
	@NotNull
	private Date birthDate;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Gender gender;
	@NotNull
	private Date hireDate;
}
