package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fa.training.problem02.dao.DepartmentDAO;
import fa.training.problem02.entities.Department;
import fa.training.problem02.utils.DBConnection;

public class DepartmentDAOimpl implements DepartmentDAO<Department,Integer> {

	@Override
	public void create(Department department) {
		String sql = "INSERT INTO department VALUES(?,?)";
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, department.getDept_no());
			stm.setString(2, department.getDept_name());
			stm.setString(3, department.getDescription());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
