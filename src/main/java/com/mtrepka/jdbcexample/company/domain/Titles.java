package com.mtrepka.jdbcexample.company.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Titles {
	private int empNo;
	private String title;
	private Date fromDate;
	private Date toDate;
}
