package fa.training.problem02.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private DBConnection() {
		
	}
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jpl_test01";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			if(conn == null || conn.isClosed()) {
				OpenConnection();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	private static synchronized void OpenConnection() {
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void CloseConnection() {
		if(conn !=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
