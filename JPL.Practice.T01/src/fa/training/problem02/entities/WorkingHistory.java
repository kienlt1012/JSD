package fa.training.problem02.entities;

import java.sql.Date;

/**
 * @Overviews: model of Working History
 * @author Logan Lee
 *
 */
public class WorkingHistory {
	private int dept_no;
	private int emp_no;
	private Date from_date;
	private Date to_date;
	
	//constructor
	public WorkingHistory() {
		
	}
	public WorkingHistory(int dept_no, int emp_no, Date from_date, Date to_date) {
		if(to_date.before(from_date) && to_date.equals(from_date)) {
			System.err.println("Invalid from_date " + from_date +" and to_date "+to_date+".");
		}
		this.dept_no = dept_no;
		this.emp_no = emp_no;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	//Getter and Setter
	public int getDept_no() {
		return dept_no;
	}
	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	//toString
	@Override
	public String toString() {
		return "WorkingHistory [dept_no=" + dept_no + ", emp_no=" + emp_no + ", from_date=" + from_date + ", to_date="
				+ to_date + "]";
	}
	
}
