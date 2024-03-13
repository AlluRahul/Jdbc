package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplaySalary {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true", "root", "12345");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select emp_salary from employee");
			// Is Before is used true if the cursor is before the first row;
			// false if the cursor is at any other position or the result set contains no
			// rows
			if (rs.isBeforeFirst()) {
				System.out.println("\t\temp_salary");
				while (rs.next()) {
					Double emp_salary = rs.getDouble("emp_salary");
					System.out.println( "\t\t" + emp_salary);
				}
			} else {
				System.out.println("data not found ");
				System.out.println("connection not establish");
			}
			System.out.println("! Data Found !");
			System.out.println("!Connecion establish !");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}


