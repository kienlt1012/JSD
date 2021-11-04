package fa.training.problem02.service.impl;

import java.sql.Date;
import java.util.List;

import fa.training.problem02.entities.Employee;
import fa.training.problem02.service.EmployeeManagementService;
import fa.training.problem02.dao.EmployeeDAO;
import fa.training.problem02.dao.impl.EmployeeDAOimpl;

public class EmployeeManagementServiceImpl implements EmployeeManagementService{

	@Override
	public void save(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		employeeDAO.create(employee);
		System.out.println("Successful!");
	}

	@Override
	public List<Employee> findAll() {
		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		List<Employee>emps = employeeDAO.findAll();
		return emps;
	}

	@Override
	public void update(Employee employee) {
		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		employeeDAO.update(employee);
	}

	@Override
	public Employee findByID(int emp_no) {
		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		return employeeDAO.retrieve(emp_no);
	}

	@Override
	public List<Employee> findByWorkTime(Date from_date, Date to_date) {
		EmployeeDAO employeeDAO = new EmployeeDAOimpl();
		return employeeDAO.FindByWorkTime(from_date, to_date);
	}
	
}
