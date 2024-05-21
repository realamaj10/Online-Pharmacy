package model.base;

public class Employee extends User {

    private String name;
    private String surname;
    private Date bdt;
    private String email;
    private String phoneNumber;
    private String salary;

    public Employee(String user, String pass, String name, String surname, Date bdt, String email,
            String phoneNumber, String salary) {
        super(user, pass);
        this.name = name;
        this.surname = surname;
        this.bdt = bdt;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBdt() {
        return bdt;
    }

    public void setBdt(Date bdt) {
        this.bdt = bdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public void setType(Type type) {
        super.type = type;

    }

    @Override
    public String toString() {
        return "Employee{" + " name=" + name + ", surname=" + surname
                + ", bdt=" + bdt + ", email=" + email
                + ", phoneNumber=" + phoneNumber + ", salary=" + salary + '}';
    }

}
