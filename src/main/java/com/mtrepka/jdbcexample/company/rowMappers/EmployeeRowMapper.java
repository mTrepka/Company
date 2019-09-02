package com.mtrepka.jdbcexample.company.rowMappers;

import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.domain.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employees> {
	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employees employee = new Employees();
		employee.setEmpNO(rs.getInt("emp_no"));
		employee.setBirthDate(rs.getDate("birth_date"));
		employee.setFirstName(rs.getString("first_name"));
		employee.setLastName(rs.getString("last_name"));
		employee.setGender(Gender.valueOf(rs.getString("gender")));
		employee.setHireDate(rs.getDate("hire_date"));
		return employee;
	}
}
