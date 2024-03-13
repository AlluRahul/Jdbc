package AdnaveJdbc;


//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Jdbc1 {
//
//	public static void main(String[] args) {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			// step1
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// step 2
////			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");;
//			// step3
//			stmt = conn.createStatement();
//			// step4
//			rs = stmt.executeQuery("select * from demo.employee");
//			while (rs.next()) {
//				int emp_id = rs.getInt("emp_id");
//				String emp_name = rs.getString("emp_name");
//				double emp_salary = rs.getDouble("emp_salary");
//				int emp_deptno =rs.getInt("emp_deptno");
//				System.out.println("emp_id : " + emp_id);
//				System.out.println("emp_name : " + emp_name);
//				System.out.println("emp_salary : " + emp_salary);
//				System.out.println("emp_deptno : " + emp_deptno);
//				
//				
//			}
//          System.out.println("hello rahul");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (rs != null) {
//					rs.close();
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // step1
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step 2
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "12345");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");;
            // step3
            stmt = conn.createStatement();
            // step4
            rs = stmt.executeQuery("select * from demo.employee");

            // Print table header
            System.out.printf("%-10s%-20s%-15s%-15s\n", "emp_id", "emp_name", "emp_salary", "emp_deptno");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                int emp_id = rs.getInt("emp_id");
                String emp_name = rs.getString("emp_name");
                double emp_salary = rs.getDouble("emp_salary");
                int emp_deptno = rs.getInt("emp_deptno");

                // Print table rows
                System.out.printf("%-10d%-20s%-15.2f%-15d\n", emp_id, emp_name, emp_salary, emp_deptno);
            }
            System.out.println("hello rahul");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
