public class Vaccine {
    private String vaccineID;
    private String nameOfVaccine;
    private String typeOfPet;
    private String expirationDate;
    private double weightRequirement;
    private double dosageMl;

    public Vaccine(String vaccineID, String nameOfVaccine, String typeOfPet, String expirationDate, double weightRequirement, double dosageMl) {
        this.vaccineID = vaccineID;
        this.nameOfVaccine = nameOfVaccine;
        this.typeOfPet = typeOfPet;
        this.expirationDate = expirationDate;
        this.weightRequirement = weightRequirement;
        this.dosageMl = dosageMl;
    }

    public String getVaccineID() {
        return this.vaccineID;
    }

    public String getNameOfVaccine() {
        return this.nameOfVaccine;
    }
    public void setNameOfVaccine(String nameOfVaccine) {
        this.nameOfVaccine = nameOfVaccine;
    }

    public String getTypeOfPet() {
        return this.typeOfPet;
    }

    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public String getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public double getWeightRequirement() {
        return this.weightRequirement;
    }
    public void setWeightRequirement(double weightRequirement) {
        this.weightRequirement = weightRequirement;
    }
    public double getDosageMl() {
        return this.dosageMl;
    }
    public void setDosageMl(double dosageMl) {
        this.dosageMl = dosageMl;
    }

    public String toString() {
        return String.format("%s\n\t%s\n\t%s\n\t%s\n\t%.1f\n\t%.1f", vaccineID, nameOfVaccine, typeOfPet, expirationDate, weightRequirement, dosageMl);
    }
}
