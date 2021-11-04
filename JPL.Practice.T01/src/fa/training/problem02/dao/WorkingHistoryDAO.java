package fa.training.problem02.dao;
/**
 * @Overviews: This class provide function to create,retrieve,update,delete Working History in database  
 *
 */
public interface WorkingHistoryDAO<T> {
	
	void create(T workinghistory);
	
}
