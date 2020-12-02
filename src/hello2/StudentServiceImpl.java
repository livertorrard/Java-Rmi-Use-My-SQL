package hello2;
import java.awt.List;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
 
 
public class StudentServiceImpl extends UnicastRemoteObject implements
      StudentService {
  private static final long serialVersionUID = 1L;

  public StudentServiceImpl() throws RemoteException {
      super();
  }
  @Override
  public synchronized ArrayList<StudentData> getListStudent()
          throws RemoteException {
	  ArrayList<StudentData> listStudent = new ArrayList<StudentData>();
	  	DB db = new DB();
  		ResultSet rs = db.getListStudent();
	  	try {
			while (rs.next()) {
				listStudent.add(new StudentData(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
//			  System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  return listStudent;
 
	 
  }
  public boolean login(String username, String password) throws RemoteException {
	  DB db = new DB();
	  return db.login(username, password);
  }
}