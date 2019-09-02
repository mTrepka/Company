package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class DepartmentEmployee {
	private int deptNo;
	private int empNo;
	private Date fromDate;
	private Date toDate;
}
