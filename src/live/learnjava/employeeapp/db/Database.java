package live.learnjava.employeeapp.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	static String database = "employee_jdbc_db";
	public static Connection connect() throws Exception {
		Connection connection = null;
		try {
		String url = "jdbc:mysql://localhost:3306/"+Database.database;
		String userName = "root";
		String passCode = "Guruji123$";
		connection = DriverManager.getConnection(url, userName, passCode);
		System.out.println("Database connection established");
		} catch(Exception e) {
			System.out.println("Connection unsuccessful...");
			e.printStackTrace();
		}
		return connection;
	}
}
