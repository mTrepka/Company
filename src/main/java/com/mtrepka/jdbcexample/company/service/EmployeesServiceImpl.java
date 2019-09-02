package com.mtrepka.jdbcexample.company.service;

import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.rowMappers.EmployeeRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("employeesService")
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService{
	private final JdbcTemplate jdbcTemplate;

	@Override
	public Employees getEmployeeByNo(int no) {
		String query = "SELECT * FROM employees WHERE emp_no = ?";
		return jdbcTemplate.queryForObject(
				query, new Object[]{no}, new EmployeeRowMapper());
	}

	@Override
	public List<Employees> getAllEmployees() {
		String query = "select * from employees";
		return jdbcTemplate.query(
				query, new EmployeeRowMapper());
	}

	public int getLastId() {
		String query = "select emp_no from employees order by emp_no desc limit 1";
		return jdbcTemplate.queryForObject(query,Integer.class);
	}

	@Override
	public void saveEmployee(Employees employee) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("employees");
		Map<String, Object> parameters = new HashMap<>();

		if(employee.getEmpNO()==0) parameters.put("emp_no",getLastId()+1);
		else parameters.put("emp_no",employee.getEmpNO());

		parameters.put("birth_date",employee.getBirthDate());
		parameters.put("first_name",employee.getFirstName());
		parameters.put("last_name",employee.getLastName());
		parameters.put("gender",employee.getGender());
		parameters.put("hire_date",employee.getHireDate());
		simpleJdbcInsert.execute(parameters);
	}

	@Override
	public void updateEmployee(Employees employees) {
		jdbcTemplate.update(
				"update employees set birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ? where emp_no = ?",
				employees.getBirthDate(),employees.getFirstName(),employees.getLastName(),employees.getGender().toString(),employees.getHireDate(),employees.getEmpNO());
	}

	@Override
	public void deleteEmployee(Employees emp) {
		jdbcTemplate.update(
				"DELETE FROM employees WHERE emp_no = ?",
				emp.getEmpNO());
	}
}
