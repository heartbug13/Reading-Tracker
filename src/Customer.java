public class Customer {
    private final String customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String reasonForAdopting;

    public Customer(String customerID, String firstName, String lastName, String email, String phone, String reasonForAdopting) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.reasonForAdopting = reasonForAdopting;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setReasonForAdopting(String reasonForAdopting) {
        this.reasonForAdopting = reasonForAdopting;
    }

    public String getReasonForAdopting() {
        return this.reasonForAdopting;
    }

    public String toString() {
        return String.format("%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s", customerID, firstName, lastName, email, phone,reasonForAdopting);
    }


}
