package hello2;
import java.io.Serializable;
import java.util.Date;
 
public class StudentData implements Serializable {
 
   private static final long serialVersionUID = 1L;
   
   private int id;
   private String name;
   private String email;
   private String class_;
   private String address;
 
   public StudentData(int id, String name, String email,String class_,String address) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.class_ = class_;
       this.address = address;
   }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getClass_() {
	return class_;
}

public void setClass_(String class_) {
	this.class_ = class_;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}