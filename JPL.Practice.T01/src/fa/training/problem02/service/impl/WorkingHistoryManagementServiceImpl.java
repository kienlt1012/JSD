package fa.training.problem02.service.impl;

import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.dao.WorkingHistoryDAO;
import fa.training.problem02.service.WorkingHistoryManagementService;
import fa.training.problem02.dao.impl.WorkingHistoryDAOimpl;

public class WorkingHistoryManagementServiceImpl implements WorkingHistoryManagementService{

	@Override
	public void save(WorkingHistory wh) {
		WorkingHistoryDAO whDAO = new WorkingHistoryDAOimpl();
		whDAO.create(wh);
		System.out.println("Successful!");
	}

}
