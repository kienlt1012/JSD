package fa.training.problem02.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class InputValidator {
	public static boolean validateMainInputEmp_no(int emp_no) {
		boolean bl = false;
		String sql = "SELECT emp_no FROM employee";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stm = conn.prepareStatement(sql)) {
			ResultSet rs = stm.executeQuery();
			List<Integer> emp_noList = new ArrayList<>();
			while (rs.next()) {
				emp_noList.add(rs.getInt(1));
			}
			if (emp_noList.contains(emp_no)) {
				bl = true;
			} else {
				System.err.print("Invalid ID");
				bl = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	public static boolean validateAddWorkingHistoryInput(int emp_no, int dept_no) {
		boolean bl = false;
		String sql1 = "SELECT emp_no FROM employee";
		String sql2 = "SELECT dept_no FROM department";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stm1 = conn.prepareStatement(sql1);
				PreparedStatement stm2 = conn.prepareStatement(sql2)) {
			ResultSet rs1 = stm1.executeQuery();
			ResultSet rs2 = stm2.executeQuery();
			List<Integer> emp_noList = new ArrayList<>();
			while (rs1.next()) {
				emp_noList.add(rs1.getInt(1));
			}
			List<Integer> dept_noList = new ArrayList<>();
			while (rs2.next()) {
				dept_noList.add(rs2.getInt(1));
			}
			if (!emp_noList.contains(emp_no)) {
				System.err.println("Invalid emp_no!");
				bl = false;
			} else if (!dept_noList.contains(dept_no)) {
				System.err.println("Invalid dept_no!");
				bl = false;
			} else if (!emp_noList.contains(emp_no) && !dept_noList.contains(dept_no)) {
				System.err.println("Invalid emp_no and dept_no");
				bl = false;
			} else {
				bl = true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}
	public static boolean ValidateFrom_dateTo_date(Date from_date, Date to_date) {
		boolean bl = false;
		if(from_date.compareTo(to_date) == -1) {
			bl = true;
		}else {
			bl = false;
			System.err.println();
		}
		return bl;
	}
}
