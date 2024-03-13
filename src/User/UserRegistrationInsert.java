package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRegistrationInsert {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		// Step 1: Load the JDBC driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step 2: Establish a connection to the database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=12345");

			// Step 3: Create a statement
			stmt = conn.createStatement();

			// Step 4: Execute the SQL statement to insert into a table
			int rs = stmt.executeUpdate(
                    "INSERT INTO userdetails(user_firstname, user_lastname, user_emailid, user_password, user_phonenumber, user_address) VALUES " +
                            "('Allu', 'vamsi', 'alluvamsi1407@gmail.com', '14072', '8977933577', 'Khammam')," +
                            "('Allu', 'Ramya', 'ramyaallu17@gmail.com', '17019', '9603131343', 'Khammam')");
			if (rs != 0) {
				System.out.println("Table found");
				System.out.println("Inserted succesfully and Registred succesfully");
			} else {
				System.out.println("Table not found");
				System.out.println("Unsuccesfully registred");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
