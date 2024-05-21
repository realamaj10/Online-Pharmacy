package model.RW;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.base.Administrator;
import model.base.Date;
import model.base.Employee;

public class UserRW {
    private final File fUser;
    private ArrayList<Employee> emp;
    
    
    public UserRW(){
        fUser = new File("employee.txt");
        emp = new ArrayList<Employee>();
        if(!fUser.exists()){
            writeEmployee();
        }else{
            emp = readEmployee();
        }
    }
    
    public ArrayList<Employee> readEmployee(){
        try{
            FileInputStream fis = new FileInputStream(fUser);
            ObjectInputStream ois = new ObjectInputStream(fis);
            emp = (ArrayList<Employee>) ois.readObject();
            ois.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (ClassNotFoundException e) {
			System.err.println("Class not Found!!!");
		} catch (IOException e) {
			System.err.println("File not accessable!!!");
		}
		return emp;
	}

	private void writeEmployee() {
		try {
			FileOutputStream fos = new FileOutputStream(fUser);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			if(emp.isEmpty()){
				emp.add(new Administrator("admin","pass","User",
                                        "ADMIN",new Date("10/2/2018"), "admin@pharmacy.com", 
                                        "670000000", "00000"));
			}
			oos.writeObject(emp);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not Found!!!");
		} catch (IOException e) {
			System.err.println("File not Writable!!!");
		}
		readEmployee();
        }
        
	public Employee checkUser(String username,String password){
		for(Employee x:emp){
			if(username.equals(x.getUsername()) && x.getPassword().equals(password)){
				return x;
			} 
		}
		return null;
                
               
	}
//	public void compareUsername(String username){
//		for(Employee x:emp){
//			if(username.equals(x.getUsername())){
//				remove(x);
//			} 
//		}
//		               
//	}
       
	public void addEmp(Employee e){
		emp.add(e);
		writeEmployee();
	}
	public void remove(Employee e){
		emp.remove(e);
		writeEmployee();
	}
}
