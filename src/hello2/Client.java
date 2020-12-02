package hello2;
import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
 
public class Client extends JFrame{
JFrame f;
   // Host or IP of Server
   private static final String HOST = "localhost";
   private static final int PORT = 1098;
   private static Registry registry;
   static ArrayList<StudentData> infoStudent;
   static StudentService service;
   public Client() {
	   f = new JFrame();
	   String column[] = { "Id", "Name", "Email" ,"Class","Address"};
       String [][] data =  new String[infoStudent.size()][column.length];
	   
       for (int i = 0; i < infoStudent.size(); i++) {
    	   data[i][0] = Integer.toString(infoStudent.get(i).getId());
    	   data[i][1] = infoStudent.get(i).getName();
    	   data[i][4] = infoStudent.get(i).getEmail();
    	   data[i][2] = infoStudent.get(i).getClass_();
    	   data[i][3] = infoStudent.get(i).getAddress();
     
       }
       
       JTable jt = new JTable(data, column);
       jt.setBounds(30, 40, 200, 300);
       JScrollPane sp = new JScrollPane(jt);
       f.add(sp);
       f.setSize(500, 300);
       f.setVisible(true);
   }
   
   private String String(int id) {
	// TODO Auto-generated method stub
	return null;
}
public static boolean login() {
	boolean result =  false;
	JTextField username = new JTextField();
	   JTextField password = new JPasswordField();
	   Object[] message = {
	       "Username:", username,
	       "Password:", password
	   };

	   int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
	   if (option == JOptionPane.OK_OPTION) {
	       try {
			if (service.login(username.getText(), password.getText())) {
	    	 // if (service.login("quybui","quybui")) {
			       System.out.println("Login successful");
			       result = true;
			   } else { 
			       System.out.println("login failed");
			       JOptionPane.showMessageDialog(null, "False");

			  }
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   } else {
	       System.out.println("Login canceled");
	   }
	return result;
}
public static void main(String[] args) throws Exception {
       // Search the registry in the specific Host, Port.
	registry = LocateRegistry.getRegistry(HOST, PORT);
	service = (StudentService) registry
            .lookup(StudentService.class.getSimpleName());
       if(login()) {
           // Lookup StudentService in the Registry.
           infoStudent = service.getListStudent();
           
       }
       new Client();
 
//       System.out.println("Student today: " + infoStudent.get(0).getEmail());
 
   }
   
}