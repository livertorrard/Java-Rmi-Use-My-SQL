package hello2;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
 
 
 
public interface StudentService extends Remote {
 
 // Method lấy về đối tượng thông tin thời tiết.
 // Tham số truyền vào ngày & địa điểm.
 public ArrayList<StudentData> getListStudent()
         throws RemoteException;
 public boolean login(String username,String password)
         throws RemoteException;
}