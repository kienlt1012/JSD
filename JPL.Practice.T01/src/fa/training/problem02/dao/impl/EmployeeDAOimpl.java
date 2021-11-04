package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import fa.training.problem02.dao.EmployeeDAO;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.utils.DBConnection;

public class EmployeeDAOimpl implements EmployeeDAO<Employee,Integer> {

	@Override
	public List<Employee> findAll() {
		String sql = "SELECT * FROM employee";
		List<Employee> employees = new ArrayList<>();
		try(Connection conn = DBConnection.getConnection();
			Statement stm = conn.createStatement()	
			){
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				employees.add(new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public void update(Employee employee) {
		String sql = "UPDATE employee SET birth_date = ?, first_name = ?, last_name = ?, gender = ?, hire_date = ? WHERE emp_no = ?";
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setDate(1, employee.getBirth_date());
			stm.setString(2, employee.getFirst_name());
			stm.setString(3, employee.getLast_name());
			stm.setString(4, String.valueOf(employee.getGender()));
			stm.setDate(5, employee.getHire_date());
			stm.setInt(6, employee.getEmp_no());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void create(Employee employee) {
		String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?)";
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql);){
			stm.setInt(1, employee.getEmp_no());
			stm.setDate(2, employee.getBirth_date());
			stm.setString(3, employee.getFirst_name());
			stm.setString(4, employee.getLast_name());
			stm.setString(5, String.valueOf(employee.getGender()));
			stm.setDate(6, employee.getHire_date());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public Employee retrieve(Integer emp_no) {
		String sql = "SELECT * FROM employee WHERE emp_no = ?";
		Employee employee = null;
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, emp_no);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				employee = new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6));
			}
			rs.close();
			stm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> FindByWorkTime(Date from_date, Date to_date) {
		String sql = "SELECT emp.emp_no, emp.birth_date, emp.first_name, emp.last_name, emp.gender, emp.hire_date, wh.from_date, wh.to_date FROM (working_history as wh INNER JOIN employee as emp ON wh.emp_no = emp.emp_no) where wh.from_date = ? and wh.to_date =?";
		List<Employee> emp = new ArrayList<>();
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setDate(1, from_date);
			stm.setDate(2, to_date);
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				emp.add(new Employee(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5).charAt(0), rs.getDate(6)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void delete(Integer emp_no) {
		String sql = "DELETE * FROM employee WHERE emp_no = ?";
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
				stm.setInt(1, emp_no);
				stm.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

}
