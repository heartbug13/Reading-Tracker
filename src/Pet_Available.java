public class Pet_Available {
    private String petID;
    private String employeeID;
    private String petName;
    private String dateOfBirth;
    private String typeOfPet;
    private String description;

    public Pet_Available(String petID, String employeeID, String petName, String dateOfBirth, String typeOfPet, String description) {
        this.petID = petID;
        this.employeeID = employeeID;
        this.petName = petName;
        this.dateOfBirth = dateOfBirth;
        this.typeOfPet = typeOfPet;
        this.description = description;
    }

    public String getPetID() {
        return this.petID;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTypeOfPet() {
        return this.typeOfPet;
    }

    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("%s\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s", petID, employeeID, petName, dateOfBirth, typeOfPet, description);
    }

}
