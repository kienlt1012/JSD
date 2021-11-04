package fa.training.problem02.service;

import java.util.List;
import java.sql.Date;
import fa.training.problem02.entities.Employee;
/**
 * This interface declared employee management service classes that will be implemented
 * 
 * @author Logan Ly
 *
 */
public interface EmployeeManagementService{
	
	//Add a new employee
	void save(Employee employee);
	//Find all employee
	List<Employee> findAll();
	// update employee
	void update(Employee employee);
	// find an employee by ID
	Employee findByID(int emp_no);
	//Find an emplyee by work time
	List<Employee> findByWorkTime(Date from_date, Date to_date);
	
}
