package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?user=root&password=12345");

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the SQL statement to create a table
    
            String createTableSQL =   "CREATE TABLE userdetails ("
            		  + "user_id INT NOT NULL AUTO_INCREMENT,"
            		  + "user_firstname VARCHAR(255) NOT NULL,"
            		  + "user_lastname VARCHAR(255) NOT NULL,"
            		  + "user_emailid VARCHAR(225) NOT NULL,"
            		  + "user_password VARCHAR(225) NOT NULL,"
            		  + "user_phonenumber VARCHAR(10) NOT NULL,"
            		  + "user_address VARCHAR(255) NOT NULL,"
            		  + "PRIMARY KEY (user_id),"
            		  + "UNIQUE INDEX user_emailid_UNIQUE (user_emailid ASC) VISIBLE,"
            		  + "UNIQUE INDEX user_password_UNIQUE (user_password ASC) VISIBLE,"
            		  + "UNIQUE INDEX user_phonenumber_UNIQUE (user_phonenumber ASC) VISIBLE)"
            		  +")";
            stmt.execute(createTableSQL);

            System.out.println("Table 'userdetails' created successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class CreateTableExample {
//
//    // JDBC URL, username, and password of MySQL server
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
//    private static final String USER = "your_username";
//    private static final String PASSWORD = "your_password";
//
//    public static void main(String[] args) {
//        // JDBC variables for opening, closing, and managing the connection
//        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
//
//            // SQL statement for creating a table
//            String createTableSQL = "CREATE TABLE userdetails ("
//                    + "user_id INT PRIMARY KEY AUTO_INCREMENT, "
//                    + "user_firstname VARCHAR(255), "
//                    + "user_lastname VARCHAR(255), "
//                    + "user_emailid VARCHAR(255), "
//                    + "user_password VARCHAR(255), "
//                    + "user_phonenumber VARCHAR(255)"
//                    + ")";
//
//            // Creating a statement
//            try (Statement statement = connection.createStatement()) {
//                // Executing the SQL statement to create the table
//                statement.execute(createTableSQL);
//                System.out.println("Table 'userdetails' created successfully.");
//            } catch (SQLException statementException) {
//                System.err.println("Error creating table: " + statementException.getMessage());
//            }
//
//        } catch (SQLException e) {
//            // Handle errors for JDBC
//            e.printStackTrace();
//        }
//    }
//}
