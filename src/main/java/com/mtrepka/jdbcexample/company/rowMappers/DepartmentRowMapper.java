package com.mtrepka.jdbcexample.company.rowMappers;

import com.mtrepka.jdbcexample.company.domain.Departments;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Departments> {
	@Override
	public Departments mapRow(ResultSet rs, int rowNum) throws SQLException {
		Departments department = new Departments();
		department.setDeptName(rs.getString("dept_name"));
		department.setDeptNo(rs.getString("dept_no"));
		return department;
	}


}
