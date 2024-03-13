package AdnaveJdbc;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class sampleDatabases {
//
//	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/demo";
//		String username = "root";
//		String password = "12345";
//		String createTableQuery = "CREATE TABLE IF NOT EXISTS users (" + "id INT PRIMARY KEY AUTO_INCREMENT,"
//				+ "username VARCHAR(50) NOT NULL," + "email VARCHAR(50) NOT NULL)";
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connection = DriverManager.getConnection(url, username, password);
//			Statement statement = connection.createStatement();
//			statement.executeUpdate(createTableQuery);
//			statement.close();
//			connection.close();
//			System.out.println("Table created successfully!");
//
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sampleDatabases {

    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "12345";

        // SQL query to drop the table
        String dropTableQuery = "DROP TABLE IF EXISTS users";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute the SQL query to drop the table
            statement.executeUpdate(dropTableQuery);

            // Close resources
            statement.close();
            connection.close();

            System.out.println("Table dropped successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

