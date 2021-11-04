package fa.training.problem02.dao;

import fa.training.problem02.utils.DBConnection;
import fa.training.problem02.entities.Department;

/**
 * @Overviews: This class provide function to access the database for creating,retrieving,updating,deleting department  
 * @author Logan Ly
 */
public interface DepartmentDAO<T,K> {
	void create (T department);
}
