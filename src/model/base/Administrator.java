package model.base;

public class Administrator extends Employee {

    public Administrator(String user, String pass, String name, String surname, Date bdt, String email,
            String phoneNumber, String salary) {
        super(user, pass, name, surname, bdt, email, phoneNumber, salary);
        setType(Type.Administrator);
    }

    public String toString() {
        return "Administrator has name: " + super.getName() + " and surname: " + super.getSurname();
    }

}
