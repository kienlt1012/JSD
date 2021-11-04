package fa.training.problem02.dao;

import java.util.List;

import fa.training.problem02.entities.Employee;

import java.sql.Date;

public interface EmployeeDAO<T,K> {
	List<T> findAll();
	
	void update(T employee);
	
	void create(T employee);
	
	Employee retrieve(K key);
	
	List<T> FindByWorkTime(Date from_date, Date to_date);

	void delete(K key);
}
