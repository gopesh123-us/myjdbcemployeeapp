package live.learnjava.employeeapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import live.learnjava.employeeapp.db.Database;
import live.learnjava.employeeapp.db.Query;
import live.learnjava.employeeapp.model.Employee;

public class EmployeeDAO {
	// CRUD Methods

	// Create
	public static void createEmployee(Employee employee) throws Exception {
		Connection connection = Database.connect();
		String query = Query.create;

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getEmail());
		preparedStatement.setFloat(3, employee.getSal());
		preparedStatement.setString(4, employee.getAddr());

		System.out.println("\n ps = " + preparedStatement + " \n" + employee);
		int result = preparedStatement.executeUpdate();
		System.out.println("Employee created successfully " + result);
		connection.close();
	}

	// Update
	public static void updateEmployee(Employee employee) throws Exception {
		Connection connection = Database.connect();
		String query = Query.update;
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, employee.getName());
		pstmt.setString(2, employee.getEmail());
		pstmt.setFloat(3, employee.getSal());
		pstmt.setString(4, employee.getAddr());
		pstmt.setInt(5, employee.getId());
		System.out.println("\nps = " + pstmt + " \n" + employee);
		int result = pstmt.executeUpdate();
		System.out.println("Employee updated successfully " + result);
		connection.close();
	}

	// Delete
	public static boolean deleteEmployee(int empId) throws Exception {
		Connection connection = Database.connect();
		String delete = Query.delete;
		PreparedStatement pstmt = connection.prepareStatement(delete);
		pstmt.setInt(1, empId);
		Employee emp = EmployeeDAO.readEmployee(empId);
		int result = pstmt.executeUpdate();
		if (result == 0) {
			System.out.println("Sorry! Employee with eid " + empId + " not found");
			return false;
		} else {
			System.out.println("Row count: " + result);
			System.out.println("[Deleted] " + emp);
		}
		return true;
	}

	// Read
	public static Employee readEmployee(int empId) throws Exception {
		Connection connection = Database.connect();
		String query = Query.read;
		PreparedStatement pstatement = connection.prepareStatement(query);
		pstatement.setInt(1, empId);
		System.out.println("\nps = " + pstatement + "\n");
		ResultSet rs = pstatement.executeQuery();
		System.out.println("Printing results for employee with id: " + empId);
		System.out.println("====================");

		if (rs == null) {
			System.out.println("Sorry! No employee found with id: " + empId);
			System.exit(0);
		}
		Employee emp = new Employee();
		while (rs.next()) {

			System.out.println("id	: " + rs.getInt(1));
			System.out.println("Name	: " + rs.getString(2));
			System.out.println("Email	: " + rs.getString(3));
			System.out.println("Salary	: " + rs.getFloat(4));
			System.out.println("City	: " + rs.getString(5));
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setEmail(rs.getString(3));
			emp.setSal(rs.getFloat(4));
			emp.setAddr(rs.getString(5));
		}

		System.out.println("emp:" + emp);
		connection.close();
		pstatement.close();
		return emp;

	}
}
