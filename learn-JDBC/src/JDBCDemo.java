import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		

		
		String url = "jdbc:mysql://localhost:3306/employees_database";
		try {
			// establish a connection
			Connection conn = DriverManager.getConnection(url,"root","Ruka@123"); 
			
			// create a statement object to send to the database
			Statement statement = conn.createStatement();
			
			// execute the statement object and store the results in to result set object
			ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
			
			statement.executeUpdate("insert into employees_tbl (id, name, dept,salary) values(900,'liet','Love',5800);");
			
			// delete the data
			statement.executeUpdate("DELETE from employees_tbl WHERE id = 300");
			
			// update the data
			statement.executeUpdate("UPDATE employees_tbl SET salary = 5900 WHERE id = 700;");
			
			
			// process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}

}
