public class Caretaker {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Caretaker(String employeeID, String firstName, String lastName, String email, String phone) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return String.format("%s\n\t%s\n\t%s\n\t%s\n\t%s", employeeID, firstName, lastName, email, phone);
    }


}
