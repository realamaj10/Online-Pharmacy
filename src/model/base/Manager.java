package model.base;

public class Manager extends Employee {


	public Manager(String user, String pass, String name, String surname, Date bdt, String email,
			String phoneNumber, String salary) {
		super(user, pass, name, surname, bdt, email, phoneNumber, salary);
	
		setType(Type.Manager);
	}

	public String toString(){
		return "Manager has name: "+ super.getName()+" and surname: "+super.getSurname();
	}
	

}
