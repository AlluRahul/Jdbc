package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable2 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinformation?user=root&password=12345");

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the SQL statement to create a table
            String createTableSQL = "CREATE TABLE userdetails ("
                    + "user_id INT NOT NULL AUTO_INCREMENT,"
                    + "user_firstname VARCHAR(255) NOT NULL,"
                    + "user_lastname VARCHAR(255) NOT NULL,"
                    + "user_emailid VARCHAR(225) NOT NULL,"
                    + "user_password VARCHAR(225) NOT NULL,"
                    + "user_amount DOUBLE NOT NULL," // Corrected the field name from user_ammount to user_amount
                    + "user_mobilenumber VARCHAR(10) NOT NULL,"
                    + "user_accountnumber VARCHAR(11) NOT NULL,"
                    + "user_address VARCHAR(255) NOT NULL,"
                    + "PRIMARY KEY (user_id),"
                    + "UNIQUE INDEX user_emailid_UNIQUE (user_emailid ASC) VISIBLE,"
                    + "UNIQUE INDEX user_password_UNIQUE (user_password ASC) VISIBLE,"
                    + "UNIQUE INDEX user_mobilenumber_UNIQUE (user_mobilenumber ASC) VISIBLE,"
                    + "UNIQUE INDEX user_accountnumber_UNIQUE (user_accountnumber ASC) VISIBLE"
                    + ")";
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
