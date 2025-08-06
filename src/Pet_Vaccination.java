public class Pet_Vaccination {
    private String employeeID;
    private String vaccineID;
    private String petID;
    private String dateAdministered;
    private String nextDueDate;
    private String notes;

    public Pet_Vaccination(String employeeID, String vaccineID, String petID, String dateAdministered, String nextDueDate, String notes) {
        this.employeeID = employeeID;
        this.vaccineID = vaccineID;
        this.petID = petID;
        this.dateAdministered = dateAdministered;
        this.nextDueDate = nextDueDate;
        this.notes = notes;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getVaccineID() {
        return this.vaccineID;
    }

    public String getPetID() {
        return this.petID;
    }

    public String getDateAdministered() {
        return this.dateAdministered;
    }

    public void setDateAdministered(String dateAdministered) {
        this.dateAdministered = dateAdministered;
    }

    public String getNextDueDate() {
        return this.nextDueDate;
    }

    public void setNextDueDate(String nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return String.format("%s %s %s\n\t%s\n\t%s\n\t%s\n", employeeID, vaccineID, petID, dateAdministered, nextDueDate, notes);
    }
}
