public class Adoption {
    private String adoptionID;
    private String petID;
    private String customerID;
    private String pickUpDate;
    private String adoptionAgreement;
    private double adoptionCost;

    public Adoption(String adoptionID, String petID, String customerID, String pickUpDate, String adoptionAgreement, double adoptionCost) {
        this.adoptionID = adoptionID;
        this.petID = petID;
        this.customerID = customerID;
        this.pickUpDate = pickUpDate;
        this.adoptionAgreement = adoptionAgreement;
        this.adoptionCost = adoptionCost;
    }

    public String getAdoptionID() {
        return this.adoptionID;
    }

    public String getPetID() {
        return this.petID;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getPickUpDate() {
        return this.pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getAdoptionAgreement() {
        return this.pickUpDate;
    }

    public void setAdoptionAgreement(String adoptionAgreement) {
        this.adoptionAgreement = adoptionAgreement;
    }

    public double getAdoptionCost() {
        return this.adoptionCost;
    }

    public void setAdoptionCost(double adoptionCost) {
        this.adoptionCost = adoptionCost;
    }

    public String toString() {
        return String.format("%s %s %s\n\t%s\n\t%s\n\t%.1f", adoptionID, customerID, petID, pickUpDate, adoptionAgreement, adoptionCost);
    }

}

