package fa.training.problem02.main;

import java.sql.Date;
import java.util.Scanner;

import fa.training.problem02.service.EmployeeManagementService;
import fa.training.problem02.service.impl.EmployeeManagementServiceImpl;
import fa.training.problem02.utils.InputValidator;

public class test {
	public static void main(String[] args) {
		EmployeeManagementService ems = new EmployeeManagementServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Find Employee By Work Time");
		System.out.print("Insert from_date: ");
		String from_date = sc.nextLine();
		System.out.println("Insert to_date: ");
		String to_date = sc.nextLine();
		if(InputValidator.ValidateFrom_dateTo_date(Date.valueOf(from_date), Date.valueOf(to_date))) {
			ems.findByWorkTime(Date.valueOf(from_date), Date.valueOf(to_date));
		}
	}
}
