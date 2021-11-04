package fa.training.problem02.service.impl;

import java.util.Scanner;

import fa.training.problem02.dao.DepartmentDAO;
import fa.training.problem02.dao.impl.DepartmentDAOimpl;
import fa.training.problem02.entities.Department;
import fa.training.problem02.service.DepartmentManagementService;

public class DepartmentManagementServiceImpl implements DepartmentManagementService {

	@Override
	public void save(Department department) {
		DepartmentDAO departmentDAO = new DepartmentDAOimpl();
		departmentDAO.create(department);
		System.out.println("Successful!");
	}

}
