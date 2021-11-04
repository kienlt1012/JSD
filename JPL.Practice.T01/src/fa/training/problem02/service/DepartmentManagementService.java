package fa.training.problem02.service;

import fa.training.problem02.entities.Department;
/**
 * This interface declared department management method that will be implemented
 * @author Admin
 *
 */
public interface DepartmentManagementService {
	//Add a new department
	void save(Department department);
	
}
