package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from employee");
			// Is Before is used true if the cursor is before the first row;
			// false if the cursor is at any other position or the result set contains no
			// rows
			if (rs.isBeforeFirst()) {
				System.out.println("\t\temp_id\t\temp_name\t\temp_salary\t\temp_deptno");
				while (rs.next()) {
					int emp_id = rs.getInt("emp_id");
					String emp_name = rs.getString("emp_name");
					Double emp_salary = rs.getDouble("emp_salary");
					int emp_deptno = rs.getInt("emp_salary");
					System.out.println("\t\t" + emp_id + "\t\t" + emp_name + "\t\t" + emp_salary + "\t\t" + emp_deptno);
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
