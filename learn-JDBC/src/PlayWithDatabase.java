import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayWithDatabase {

	public static void main(String[] args) {

		Connection con = MyConnection.getConnection();
		int id, salary;
		String name, department;
		try {
			//The object used for executing a static SQL statement and returning the results it produces.
			Statement statement = con.createStatement();

			// ------------insert query ------------------------
			statement.executeUpdate("INSERT INTO employees_tbl VALUES(900,'Tommy','IT', 6000)");
			// OR
			//statement.executeUpdate("insert into employees_tbl (id, name, dept,salary) values(900,'liet','Love',5800);");

			
			// -------------update query -----------------------
			statement.executeUpdate("UPDATE employees_tbl SET name = 'Cassendra' WHERE id=200");

			
			// -------------delete query -----------------------
			statement.executeUpdate("DELETE FROM employees_tbl WHERE id= 800");

			
			// --------select query - returns data as result set-----------
			ResultSet results = statement.executeQuery("SELECT * FROM employees_tbl");
						
			
			System.out.format("%-8s%-15s%-15s%-8s%n", "Id", "Name", "Department", "Salary");
			System.out.println("----   ------------    ------------  --------");

			while (results.next()) {
				id = results.getInt("id");
				name = results.getString("name");
				department = results.getString("dept");
				salary = results.getInt("salary");
				System.out.format("%-8d%-15s%-15s%-8d%n", id, name, department, salary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
