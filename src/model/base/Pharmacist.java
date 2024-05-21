package model.base;

public class Pharmacist extends Employee {
	public Pharmacist(String user, String pass, String name, String surname, Date bdt, String email,
             String phoneNumber, String salary) {
		super(user, pass, name, surname, bdt, email, phoneNumber, salary);
		
		setType(Type.Pharmacist);
	}
	

	public String toString(){
		return "Pharmacist has name : "+super.getName() + " and surname: "+super.getSurname();
	}
	
	
	
}

