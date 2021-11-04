package fa.training.problem02.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.problem02.entities.Department;
import fa.training.problem02.entities.Employee;
import fa.training.problem02.entities.WorkingHistory;
import fa.training.problem02.service.DepartmentManagementService;
import fa.training.problem02.service.EmployeeManagementService;
import fa.training.problem02.service.WorkingHistoryManagementService;
import fa.training.problem02.service.impl.DepartmentManagementServiceImpl;
import fa.training.problem02.service.impl.EmployeeManagementServiceImpl;
import fa.training.problem02.service.impl.WorkingHistoryManagementServiceImpl;
import fa.training.problem02.utils.InputValidator;

public class Application {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean invalidOption;
		do {
			System.out.println("1. Employee management" + "\n" + "2. Department management" + "\n" + "3. Close program"
					+ "\n" + "What is your choice? ");
			int choice = sc.nextInt();
			invalidOption = false;
			switch (choice) {
			case 1:
				EmployeeManagement();
				break;
			case 2:
				DepartmentManagement();
				break;
			case 3:
				System.out.println("Thanks for using my system!");
				break;
			default:
				System.out.println("Unexpected value: " + choice + ". Please re-enter your choice!");
				invalidOption = true;
			}
		} while (invalidOption);
	}

	private static void DepartmentManagement() {
		Scanner sc = new Scanner(System.in);
		boolean invalidOption;
		do {
			System.out.println("1. Add a new department");
			int option1 = sc.nextInt();
			invalidOption = false;
			switch (option1) {
			case 1:
				DepartmentManagementService dms = new DepartmentManagementServiceImpl();
				addDepartment();
				break;
			default:
				System.err.println("Invalid Option: " + option1);
				invalidOption = true;
			}

		} while (invalidOption);
	}

	private static void EmployeeManagement() {
		Scanner sc = new Scanner(System.in);
		boolean invalidOption;
		do {
			System.out.println("1. Add a new Employee" + "\n" + "2. Update a specific Employee" + "\n"
					+ "3. Find an employee by emp_no" + "\n" + "4. Add the working history" + "\n"
					+ "5. Find all the employees by working period of time" + "\n" + "What is your choice?");
			invalidOption = false;
			int option = sc.nextInt();
			switch (option) {
			case 1:
				addEmployee();
				break;
			case 2:
				updateEmployee();
				break;
			case 3:
				findByID();
				break;
			case 4:
				addWorkinghistory();
				break;
			case 5:
				findByWorkTime();
				break;
			case 6:
				EmployeeManagementService ems = new EmployeeManagementServiceImpl();
				ems.findAll().forEach(e -> System.out.println(e));
				break;
			default:
				System.err.println("Invalid option: " + option);
				invalidOption = true;
			}
		} while (invalidOption);
	}

	private static void addDepartment() {
		DepartmentManagementService dms = new DepartmentManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add a new department");
		System.out.print("Insert dept_no: ");
		int dept_no = sc.nextInt();
		String input = sc.nextLine();
		System.out.print("Insert dept_name: ");
		String dept_name = sc.nextLine();
		System.out.print("Insert description: ");
		String description = sc.nextLine();
		Department department = new Department(dept_no, dept_name, description);

		dms.save(department);
	}

	private static void findByWorkTime() {
		EmployeeManagementService ems = new EmployeeManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Find Employee By Work Time");
		System.out.print("Insert from_date: ");
		String from_date = sc.nextLine();
		System.out.println("Insert to_date: ");
		String to_date = sc.nextLine();
		if(InputValidator.ValidateFrom_dateTo_date(Date.valueOf(from_date), Date.valueOf(to_date))) {
			ems.findByWorkTime(Date.valueOf(from_date), Date.valueOf(to_date)).forEach(e -> System.out.println(e));
		}
	}

	private static void addWorkinghistory() {
		WorkingHistoryManagementService whm = new WorkingHistoryManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add working History");
		System.out.print("Insert emp_no: ");
		int emp_no = sc.nextInt();
		String input = sc.nextLine();
		System.out.print("Insert dept_no: ");
		int dept_no = sc.nextInt();
		String sql1 = "SELECT emp_no FROM employee";
		String sql2 = "SELECT dept_no FROM department";
		if (InputValidator.validateMainInputEmp_no(emp_no)) {
			System.out.print("Insert from_date(YYYY-MM-DD):");
			String input1 = sc.nextLine();
			String from_date = sc.nextLine();
			System.out.print("Insert to_date(YYYY-MM-DD): ");
			String to_date = sc.nextLine();
			if (InputValidator.ValidateFrom_dateTo_date(Date.valueOf(from_date), Date.valueOf(to_date))) {
				WorkingHistory wh = new WorkingHistory(emp_no, dept_no, Date.valueOf(from_date), Date.valueOf(to_date));
				whm.save(wh);
			} else {
				System.err.println("Invalid date!");
			}
		}
	}

	private static void findByID() {
		EmployeeManagementService ems = new EmployeeManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Find employee by ID");
		System.out.print("Insert ID: ");
		int emp_no = sc.nextInt();
		String sql = "SELECT emp_no FROM employee";
		if (InputValidator.validateMainInputEmp_no(emp_no)) {
			System.out.println("Your employee: " + ems.findByID(emp_no));
		}
	}

	private static void updateEmployee() {
		EmployeeManagementService ems = new EmployeeManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Update employee");
		System.out.print("Insert ID: ");
		int emp_no = sc.nextInt();
		String input = sc.nextLine();
		String sql = "SELECT emp_no FROM employee";
		if (InputValidator.validateMainInputEmp_no(emp_no)) {
			System.out.print("Insert new birth_date(YYYY-MM-DD):");
			String birth_date = sc.nextLine();
			System.out.print("Insert new first_name: ");
			String first_name = sc.nextLine();
			System.out.print("Insert new last_name: ");
			String last_name = sc.nextLine();
			System.out.print("Insert new gender: ");
			String gender = sc.nextLine();
			System.out.print("Insert new hire_date(YYYY-MM-DD): ");
			String hire_date = sc.nextLine();
			Employee employee = new Employee(emp_no, Date.valueOf(birth_date), first_name, last_name, gender.charAt(0),
					Date.valueOf(hire_date));
			ems.update(employee);
			System.out.println("Your updated employee: " + "\n" + ems.findByID(emp_no));
		}

	}

	private static void addEmployee() {
		EmployeeManagementService ems = new EmployeeManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add a new employee");
		System.out.println("Insert emp_no: ");
		int emp_no = sc.nextInt();
		String input = sc.nextLine();
		System.out.print("Insert birth_date(YYYY-MM-DD): ");
		String birth_date = sc.nextLine();
		System.out.print("Insert first_name: ");
		String first_name = sc.nextLine();
		System.out.print("Insert last_name: ");
		String last_name = sc.nextLine();
		System.out.print("Insert gender: ");
		String gender = sc.nextLine();
		System.out.print("Insert hire_date(YYYY-MM-DD): ");
		String hire_date = sc.nextLine();
		Employee employee = new Employee(emp_no, Date.valueOf(birth_date), first_name, last_name, gender.charAt(0),
				Date.valueOf(hire_date));
		ems.save(employee);
	}
}
