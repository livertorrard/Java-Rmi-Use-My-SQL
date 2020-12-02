package hello2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class TestDb {
    private static String DB_URL = "jdbc:mysql://localhost:3306/rmi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
 
    public static void main(String args[]) {
//        try {
//            // connnect to database 'testdb'
//            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
//            // crate statement
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from student");
//            // show data
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
//                        + "  " + rs.getString(3));
//            }
//            conn.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    	DB db = new DB();
    	ResultSet rs = db.getListStudent();
    	try {
			while (rs.next()) {
			  System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)+" "+rs.getString(4));
			  System.out.print(db.login("quybui", "quybui"));
     }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
     System.out.print(db.login("quybui", "quybui"));
    }
 

    public static Connection getConnection(String dbURL, String userName, 
            String password) {
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
}