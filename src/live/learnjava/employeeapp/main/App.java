package live.learnjava.employeeapp.main;

import java.util.Scanner;

import live.learnjava.employeeapp.dao.EmployeeDAO;
import live.learnjava.employeeapp.db.Database;
import live.learnjava.employeeapp.model.Employee;

public class App {

	public static void main(String[] args) throws Exception {
		Database.connect();
		Scanner scanner = new Scanner(System.in);
		boolean incorrectSelection;
		System.out.println("[Employee Management Application]");
		System.out.println("=================================");
		String menu = "Choose (1-4): ";
		menu = menu + "  1 = Create Employee ";
		menu = menu + "  2 = Read Employee ";
		menu = menu + "  3 = Update Employee ";
		menu = menu + "  4 = Delete Employee ";
		menu = menu + "  0 = Exit Application ";
		menu = menu + "%n  Enter here: ";
		System.out.printf(menu);
		do {
			incorrectSelection = false;
			switch (scanner.nextInt()) {
			case 1:
				Scanner input1 = new Scanner(System.in);
				;
				System.out.printf("Create Employee Selected %n");
				System.out.println("Enter Employee Name: ");
				String name = input1.nextLine();

				System.out.println("Enter Employee Email: ");
				String email = input1.nextLine();

				/*
				 * It is better to read all lines using input.nextLine() and passing to required
				 * format, otherwise it will start skipping and we will have to use
				 * input.nextLine() to stop the execution.
				 */
				System.out.println("Enter Employee Salary: ");
				Float salary = Float.parseFloat(input1.nextLine());

				System.out.println("Enter Employee City: ");
				String addr = input1.nextLine();

				Employee employee = new Employee(name, email, salary, addr);
				EmployeeDAO.createEmployee(employee);
				input1.close();
				break;
			case 2:
				// Read Employee
				System.out.printf("Read Employee Selected %n");
				Scanner input2 = new Scanner(System.in);
				System.out.println("Read Employee Selected");
				System.out.println("Enter employee id: ");
				int empId = Integer.parseInt(input2.nextLine());
				EmployeeDAO.readEmployee(empId);
				input2.close();
				break;
			case 3:
				// Update Employee (name)
				System.out.printf("Update Employee Selected %n");
				Scanner input3 = new Scanner(System.in);
				System.out.println("Enter employee id to update:");
				int empIdtoBeUpdated = Integer.parseInt(input3.nextLine());
				Employee emp = EmployeeDAO.readEmployee(empIdtoBeUpdated);
				System.out.println(emp);

				System.out.print("Enter New Name: " + emp.getName() + ":");
				String newName = input3.nextLine();
				if (newName != "" || newName != null) {
					emp.setName(newName);
				}

				System.out.println("Enter New Email: " + emp.getEmail() + ":");
				String newEmail = input3.nextLine();
				if (newEmail != "" || newEmail != null) {
					emp.setEmail(newEmail);
				}

				System.out.println("Enter New Salary: " + emp.getSal() + ":");
				Float newSal = Float.parseFloat(input3.nextLine());
				if (newSal != 0.0 || newSal != null) {
					emp.setSal(newSal);
				}

				System.out.println("Enter New Address: " + emp.getAddr() + ":");
				String newAddr = input3.nextLine();
				if (newAddr != "" | newAddr != null) {
					emp.setAddr(newAddr);
				}

				System.out.println("Saving Employee Details ");
				Thread.sleep(1000);
				EmployeeDAO.updateEmployee(emp);
				input3.close();
				break;
			case 4:
				// delete
				System.out.printf("Delete Employee - Selected %n");
				Scanner input4 = new Scanner(System.in);
				System.out.println("Enter employee id to delete:");
				int eid = Integer.parseInt(input4.nextLine());
				EmployeeDAO.deleteEmployee(eid);
				input4.close();
				break;
			case 0:
				System.out.println("Existing application...");
				Thread.sleep(1000);
				System.out.println("Goodbye!");
				System.exit(0);
			default:
				String alternateMenu = "Choose between 1 to 4";
				alternateMenu = alternateMenu + "%n  Enter here: ";
				System.out.printf(alternateMenu);
				incorrectSelection = true;
			}
		} while (incorrectSelection);

		// remove code below
		Thread.sleep(1000);
		System.out.println("====================");
		System.out.println("Job Done! Exiting app!");
		scanner.close();
		System.exit(0);
	}
}
