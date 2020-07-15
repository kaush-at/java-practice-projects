import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		
		// first thing we need to connect to the database - a connection (creating a connection object)
		//String url = "jdbc:mysql://"; // after String url = "jdbc:mysql://"; we need to provide the server address. 
		//this could be a IP address or url of the server followed by the port number
		// if you see the workbench you can see our db location and port localhost:3306
		// String url = "jdbc:mysql://localhost:3306/ " now after this slash we need to provide database  (employees_database)
		//Connection conn = DriverManager.getConnection(url); // url is database url whether it is seperate server or on this machine
		
		String url = "jdbc:mysql://localhost:3306/employees_database";
		try {
			// establish a connection
			Connection conn = DriverManager.getConnection(url,"root","Ruka@123"); 
			// get connection ekata gihin balanna monada pass karanna one kiyala
			
			// create a statement object to send to the database
			Statement statement = conn.createStatement();
			
			// execute the statement object and store the results in to result set object
			ResultSet resultSet = statement.executeQuery("select * from employees_tbl");
			
			// this is not a query - this is an insert statement (command to the data base to update/insert the data)
			// therefore instead of using executeQuery we use executeUpdate
			// int resultSet1 = statement.executeUpdate("insert into employees_tbl values(800,'Juliet','Love',5800");
			// we are not going to do any thing with this integer therefore we can get rid of it.
			statement.executeUpdate("insert into employees_tbl (id, name, dept,salary) values(900,'liet','Love',5800);");
			// for the above line we no need to loop through data therefore we can get rid of that loop too.
			// but here i am keep like this for refference
			
			// delete the data
			statement.executeUpdate("DELETE from employees_tbl WHERE id = 300");
			
			// update the data
			statement.executeUpdate("UPDATE employees_tbl SET salary = 5900 WHERE id = 700;");
			
			
			// process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getString("name"));
			}
			
			/*
			 * But with all these settup we cannot run 
			 * if we run we get an error called No suitable driver found
			 * 
			 * to include that driver - right click on the project and create a new folder called lib
			 * in this lib folder we put that driver downloaded from mysql website
			 * 
			 * then put that mysql-connector.jar in to that lib folder and right click on the project and add it to java build path
			 * library -> add jar and select the jar. but in ubuntu 
			 * 
			 *  we cannot find that jar inside downlaoaded folder therefore we can install it using 
			 *  First, apt-get install libmysql-java
			 *   then next Once it's installed, you'll have the file /usr/share/java/mysql.jar,
			 *   
			 *   Project -> Properties -> Java Build Path -> Libraries -> Add External JARs -> select /usr/share/java/mysql.jar
			 */
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  
	}

}
