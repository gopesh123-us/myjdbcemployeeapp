package live.learnjava.employeeapp.db;

public class Query {
	static String tableName = "";
	static {
		tableName = "employee";
	}
	public static String create = "INSERT INTO " + Query.tableName + " (name, email, sal, addr) VALUES (?, ?, ?, ?)";
	public static String read = "SELECT * FROM " + Query.tableName + " WHERE id = ?";
	public static String update = "UPDATE " + Query.tableName + "\r\n"
			+ "SET name = ?, email = ?, sal = ?, addr = ?\r\n" + "WHERE id = ?";
	public static String delete = "DELETE FROM " + Query.tableName + " WHERE id = ?";

}
