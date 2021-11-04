package fa.training.problem02.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fa.training.problem02.dao.WorkingHistoryDAO;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.utils.DBConnection;

public class WorkingHistoryDAOimpl implements WorkingHistoryDAO<WorkingHistory> {

	@Override
	public void create(WorkingHistory workinghistory) {
		String sql = "INSERT INTO working_history VALUES(?,?,?,?)";
		try(Connection conn = DBConnection.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setInt(1, workinghistory.getDept_no());
			stm.setInt(2, workinghistory.getEmp_no());
			stm.setDate(3, workinghistory.getFrom_date());
			stm.setDate(4, workinghistory.getTo_date());
			stm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
