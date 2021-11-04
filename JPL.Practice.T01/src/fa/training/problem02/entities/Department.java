package fa.training.problem02.entities;

/**
 * @Overviews: model of department
 * @author Logan Lee
 */
public class Department {
	private int dept_no;
	private String dept_name;
	private String description;
	
	public Department() {
		
	}
	
	public Department(int dept_no, String dept_name, String description) {
		this.dept_no = dept_no;
		this.dept_name = dept_name;
		this.description = description;
	}
	//getter and setter
	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	//toString
	@Override
	public String toString() {
		return "Department [dept_no=" + dept_no + ", dept_name=" + dept_name + ", description=" + description + "]";
	}
	
	
}
