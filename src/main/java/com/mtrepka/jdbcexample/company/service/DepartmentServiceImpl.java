package com.mtrepka.jdbcexample.company.service;

import com.mtrepka.jdbcexample.company.domain.Departments;
import com.mtrepka.jdbcexample.company.domain.Employees;
import com.mtrepka.jdbcexample.company.rowMappers.DepartmentRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	private final JdbcTemplate jdbcTemplate;

	@Override
	public Departments getByNo(String no) {
		String query = "SELECT * FROM departments WHERE dept_no = ?";
		return jdbcTemplate.queryForObject(
				query, new Object[]{no}, new DepartmentRowMapper());
	}

	@Override
	public List<Departments> getAll() {
		String query = "SELECT * FROM departments";
		return jdbcTemplate.query(
				query, new DepartmentRowMapper());
	}

	@Override
	public List<Employees> getEmployeesByDepartmentNo(String no) {
		String query = "SELECT employees.emp_no, employees.first_name,employees.last_name FROM departments " +
				"left join dept_emp on departments.dept_no = dept_emp.dept_no "+
				"left join employees on employees.emp_no =  dept_emp.emp_no "+
				"where departments.dept_no = ?";
		return jdbcTemplate.query(
				query, new Object[]{no}, new RowMapper<Employees>() {
					@Override
					public Employees mapRow(ResultSet rs, int i) throws SQLException {
						Employees employee = new Employees();
						employee.setEmpNO(rs.getInt("emp_no"));
						employee.setFirstName(rs.getString("first_name"));
						employee.setLastName(rs.getString("last_name"));
						return employee;
					}
				});
	}

	@Override
	public Departments getDepartmentByNo(Integer id) {
		String query = "SELECT * FROM departments WHERE dept_no = ?";
		return jdbcTemplate.queryForObject(
				query, new Object[]{id}, new DepartmentRowMapper());
	}

	@Override
	public void deleteDepartment(Departments dep) {
		jdbcTemplate.update(
				"DELETE FROM departments WHERE dept_no = ?",
				dep.getDeptNo());
	}

	@Override
	public void saveDepartment(Departments dep) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("departments");
		Map<String, Object> parameters = new HashMap<>();

		parameters.put("dept_no",dep.getDeptName());
		parameters.put("dept_name",dep.getDeptNo());
		simpleJdbcInsert.execute(parameters);
	}


	@Override
	public void updateDepartment(Departments dep) {
		jdbcTemplate.update(
				"update departments set dept_no = ?, dept_name = ? where dept_no = ?",
				dep.getDeptNo(),dep.getDeptName());
	}
}
