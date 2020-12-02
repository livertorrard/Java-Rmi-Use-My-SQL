package hello2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	 private static String DB_URL = "jdbc:mysql://localhost:3306/rmi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	 private static String USER_NAME = "root";
	 private static String PASSWORD = "";
	 public Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
	 public ResultSet getListStudent() {
		 ResultSet rs = null;
		 Connection conn = this.getConnection(DB_URL, USER_NAME, PASSWORD);
		 try {
	            // connnect to database 'testdb'
	            // crate statement
	            Statement stmt = conn.createStatement();
	            rs = stmt.executeQuery("select * from student");
//	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return rs;
	 }
	 public boolean login(String username,String password) {
		 ResultSet rs = null;
		 boolean Result = false;
		 Connection conn = this.getConnection(DB_URL, USER_NAME, PASSWORD);
		 try {
	            // connnect to database 'testdb'
	            // crate statement
	            Statement stmt = conn.createStatement();
	            String sql = "select * from account where email = '"+username+"' and paskword = '"+password+"'";
	            System.out.print(sql);
	            rs = stmt.executeQuery(sql);
	            try {
	    			while (rs.next()) {
	    				Result= true;
	    			}
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		return Result;
		 
	 }
	
}
