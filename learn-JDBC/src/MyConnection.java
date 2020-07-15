import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() {

		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/employees_database";
		String pass = "Ruka@123";
		String user = "root";

		try {
			con = DriverManager.getConnection(url, user, pass);
			if (con != null) {
				return con;
			}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode() + " " + e.getMessage());
		}

		return null;

	}
}
