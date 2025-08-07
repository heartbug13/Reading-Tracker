import java.sql.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static final String line = "==========================================";
    private static ArrayList<Customer> customerList = new ArrayList<Customer>();
    private static ArrayList<Adoption> adoptionList = new ArrayList<Adoption>();
    private static ArrayList<Pet_Available> petList = new ArrayList<Pet_Available>();
    private static ArrayList<Pet_Vaccination> petVaccineList = new ArrayList<Pet_Vaccination>();
    private static ArrayList<Caretaker> caretakerList = new ArrayList<Caretaker>();
    private static ArrayList<Vaccine> vaccineList = new ArrayList<Vaccine>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userInput;

        customerList.add(new Customer("C100", "Jess", "Day", "jday@gmail.com", "317-331-7127", "loves dogs"));
        customerList.add(new Customer("C101", "Winston", "Bishop", "wbishop@gmail.com", "317-710-0420", "is obsessed with cats"));

        adoptionList.add(new Adoption("A100", "P100", "C100", "10-01-2024", "agrees to care for the dog Mario",25.00));
        adoptionList.add(new Adoption("A101", "P101", "C101", "01-25-2004", "agrees to care for the cat Ferguson", 30.00));

        petList.add(new Pet_Available("P00", "E002", "Mario", "07-20-2020", "dog", "white and brown dog with dark brown eyes"));
        petList.add(new Pet_Available("P101", "E001", "Ferguson", "05-19-2000", "cat", "white and gray cat with brown eyes"));

        petVaccineList.add(new Pet_Vaccination("E100", "V100", "P100", "06-19-2021", "06-19-2022", "none"));
        petVaccineList.add(new Pet_Vaccination("E101", "V101", "P101", "06-19-2002", "06-19-2003", "none"));

        caretakerList.add(new Caretaker("E100", "Cee", "Parekh", "cpariak@gmail.com", "111-111-1111"));
        caretakerList.add(new Caretaker("E101", "Winston", "Schmidt", "cpariak@gmail.com", "111-111-1111"));

        vaccineList.add(new Vaccine("V100", "fake name 1", "dog", "01-20-2022", 10, 0.5));
        vaccineList.add(new Vaccine("V101", "fake name 1", "cat", "01-20-2003", 10, 1));



        do {
            System.out.println(line);
            System.out.println("1. Customer");
            System.out.println("2. Pet");
            System.out.println("3. Caretaker");
            System.out.println("4. Vaccine");
            System.out.println("5. Adoption");
            System.out.println("6. Pet Vaccination");
            System.out.println("7. Exit");
            System.out.println(line);

            System.out.println("Please enter an option of 1-7");

            userInput = scan.nextLine().toUpperCase();

            switch(userInput) {
                case "1":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Customer");
                        System.out.println("B. Edit Customer");
                        System.out.println("C. Print Customers");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createCustomer();
                        } else if (userInput.equals("B")) {
                            editCustomer();
                        } else if (userInput.equals("C")) {
                            printCustomer();
                        }
                    } while (!(userInput.equals("D")));
                    break;

                case "2":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Pet");
                        System.out.println("B. Edit Pet");
                        System.out.println("C. Print Pets");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createPet();
                        } else if (userInput.equals("B")) {
                            editPet();
                        } else if (userInput.equals("C")) {
                            printPet();
                        }
                    } while (!(userInput.equals("D")));
                    break;
                case "3":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Caretaker");
                        System.out.println("B. Edit Caretaker");
                        System.out.println("C. Print Caretakers");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createCareTaker();
                        } else if (userInput.equals("B")) {
                            editCareTaker();
                        } else if (userInput.equals("C")) {
                            printCareTaker();
                        }
                    } while (!(userInput.equals("D")));
                    break;
                case "4":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Vaccine");
                        System.out.println("B. Edit Vaccine");
                        System.out.println("C. Print Vaccines");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createVaccine();
                        } else if (userInput.equals("B")) {
                            editVaccine();
                        } else if (userInput.equals("C")) {
                            printVaccine();
                        }
                    } while (!(userInput.equals("D")));
                    break;
                case "5":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Adoption");
                        System.out.println("B. Edit Adoption");
                        System.out.println("C. Print Adoptions");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createAdoption();
                        } else if (userInput.equals("B")) {
                            editAdoption();
                        } else if (userInput.equals("C")) {
                            printAdoption();
                        }
                    } while (!(userInput.equals("D")));
                    break;
                case "6":
                    do {
                        System.out.println(line);
                        System.out.println("A. Create Pet Vaccination");
                        System.out.println("B. Edit Pet Vaccination");
                        System.out.println("C. Print Pet Vaccination");
                        System.out.println("D. Exit");
                        userInput = scan.nextLine().toUpperCase();

                        if (userInput.equals("A")) {
                            createPetVaccination();
                        } else if (userInput.equals("B")) {
                            editPetVaccination();
                        } else if (userInput.equals("C")) {
                            printPetVaccination();
                        }
                    } while (!(userInput.equals("D")));
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }

        } while (!userInput.equals("7"));

        System.out.println("Good Bye :)");

    }

    public static void createCustomer() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String customerID;
        String customerFirstName;
        String customerLastName;
        String customerEmail;
        String customerPhone;
        String reasonForAdopting;

        do {
            System.out.println(line);
            System.out.println("Please enter the Customer ID:");
            customerID = scan.nextLine();
            System.out.println("Please enter the First Name:");
            customerFirstName = scan.nextLine();
            System.out.println("Please enter the Last Name:");
            customerLastName = scan.nextLine();
            System.out.println("Please enter the Email:");
            customerEmail = scan.nextLine();
            System.out.println("Please enter the Phone Number");
            customerPhone = scan.nextLine();
            System.out.println("Please enter the reason for adopting");
            reasonForAdopting = scan.nextLine();

            System.out.println("Please verify all the information entered");
            System.out.printf("Customer ID:  %s\n", customerID);
            System.out.printf("FirstName:    %s\n", customerFirstName);
            System.out.printf("LastName:     %s\n", customerLastName);
            System.out.printf("Email:        %s\n", customerEmail);
            System.out.printf("Phone:        %s\n", customerPhone);
            System.out.printf("Reason For Adopting:  %s\n", reasonForAdopting);
            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        Customer newCus = new Customer(customerID, customerFirstName, customerLastName, customerEmail, customerPhone, reasonForAdopting);
        customerList.add(newCus);

    }

    public static void editCustomer() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

            System.out.println(line);
            System.out.println("Please enter the Customer ID of the customer you are looking for");
            String cusID = scan.nextLine();
            int index = -1;
            do {
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getCustomerID().equals(cusID)) {
                        index = i;
                    }
                }
                if (index == -1) {
                    System.out.println("Please enter a valid Customer ID, if you wish to exit please enter Y");
                    cusID = scan.nextLine().toUpperCase();
                    if (cusID.equals("Y")) {
                        return;
                    }
                }
            } while (index == -1);
            do {
                System.out.println(line);
                System.out.println("Which element would you like to change for the customer");
                System.out.println("1. First Name");
                System.out.println("2. Last Name");
                System.out.println("3. Email");
                System.out.println("4. Phone");
                System.out.println("5. Reason for Adopting");
                System.out.println("6. Exit");
                userInput = scan.nextLine();
                String newVal;
                switch(userInput) {
                    case "1":
                        System.out.println("Please enter the new first name");
                        newVal = scan.nextLine();
                        customerList.get(index).setFirstName(newVal);
                        break;
                    case "2":
                        System.out.println("Please enter the new last name");
                        newVal = scan.nextLine();
                        customerList.get(index).setLastName(newVal);
                        break;
                    case "3":
                        System.out.println("Please enter the new email");
                        newVal = scan.nextLine();
                        customerList.get(index).setEmail(newVal);
                        break;
                    case "4":
                        System.out.println("Please enter the new phone number");
                        newVal = scan.nextLine();
                        customerList.get(index).setPhone(newVal);
                        break;
                    case "5":
                        System.out.println("Please enter the new reason for adopting");
                        newVal = scan.nextLine();
                        customerList.get(index).setReasonForAdopting(newVal);
                        break;
                    default:
                        System.out.println("Please enter a valid option");
                }

            } while (!userInput.equals("6"));

    }

    public static void printCustomer() {
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    public static void createCareTaker() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String caretakerEmployeeID;
        String caretakerFirstName;
        String caretakerLastName;
        String caretakerEmail;
        String caretakerPhone;

        do {
            System.out.println(line);
            System.out.println("Please enter the employee ID:");
            caretakerEmployeeID = scan.nextLine();
            System.out.println("Please enter the first name");
            caretakerFirstName = scan.nextLine();
            System.out.println("Please enter the last name");
            caretakerLastName = scan.nextLine();
            System.out.println("Please enter the email");
            caretakerEmail = scan.nextLine();
            System.out.println("Please enter the phone");
            caretakerPhone = scan.nextLine();

            System.out.println("Please verify all the information entered");
            System.out.printf("Employee ID:   %s\n", caretakerEmployeeID);
            System.out.printf("First Name:    %s\n", caretakerFirstName);
            System.out.printf("Last Name:     %s\n", caretakerLastName);
            System.out.printf("Email:         %s\n", caretakerEmail);
            System.out.printf("Phone:         %s\n", caretakerPhone);

            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        caretakerList.add(new Caretaker(caretakerEmployeeID, caretakerFirstName, caretakerLastName, caretakerEmail, caretakerPhone));
    }

    public static void editCareTaker() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void printCareTaker() {
        for (Caretaker caretaker : caretakerList) {
            System.out.println(caretaker);
        }
    }

    public static void createPet() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String petID;
        String employeeID;
        String petName;
        String dateOfBirth;
        String typeOfPet;
        String description;

        do {
            System.out.println(line);
            System.out.println("Please enter the pet ID");
            petID = scan.nextLine();
            System.out.println("Please enter the employee ID");
            employeeID = scan.nextLine();
            System.out.println("Please enter the pet name");
            petName = scan.nextLine();
            System.out.println("Please enter the date of birth");
            dateOfBirth = scan.nextLine();
            System.out.println("Please enter the type of pet");
            typeOfPet = scan.nextLine();
            System.out.println("Please enter the description of the animal");
            description = scan.nextLine();

            System.out.println("Please verify all the information entered");
            System.out.printf("Pet ID:         %s\n", petID);
            System.out.printf("Employee ID:    %s\n", employeeID);
            System.out.printf("Pet Name:       %s\n", petName);
            System.out.printf("Date of Birth:  %s\n", dateOfBirth);
            System.out.printf("Description:    %s\n", description);

            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        petList.add(new Pet_Available(petID, employeeID, petName, dateOfBirth, typeOfPet, description));
    }

    public static void editPet() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void printPet() {
        for (Pet_Available pet : petList) {
            System.out.println(pet);
        }
    }

    public static void createVaccine() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String vaccineID;
        String nameOfVaccine;
        String typeOfPet;
        String expirationDate;
        double weightRequirement = 0;
        double dosageMl = 0;

        do {
            System.out.println(line);
            System.out.println("Please enter the vaccine ID");
            vaccineID = scan.nextLine();
            System.out.println("Please enter the name of vaccine");
            nameOfVaccine = scan.nextLine();
            System.out.println("Please enter the type of pet");
            typeOfPet = scan.nextLine();
            System.out.println("Please enter the expiration date");
            expirationDate = scan.nextLine();
            System.out.println("Please enter the weight requirement");
            boolean isValid = false;
            while (!isValid) {
                try {
                    weightRequirement = scan.nextDouble();
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
                scan.nextLine();
            }
            System.out.println("Please enter the dosage ml");

            isValid = false;

            while (!isValid) {
                try {
                    dosageMl = scan.nextDouble();
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
                scan.nextLine();
            }

            System.out.println("Please verify all the information entered");
            System.out.printf("Vaccine ID:     %s\n", vaccineID);
            System.out.printf("Vaccine Name:   %s\n", nameOfVaccine);
            System.out.printf("Type of Pet:    %s\n", typeOfPet);
            System.out.printf("Exp Date:       %s\n", expirationDate);
            System.out.printf("Weight Req:     %s\n", weightRequirement);
            System.out.printf("Dosage ML:      %s\n", dosageMl);


            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        vaccineList.add(new Vaccine(vaccineID, nameOfVaccine, typeOfPet, expirationDate, weightRequirement, dosageMl));
    }

    public static void editVaccine() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void printVaccine() {
        for (Vaccine vaccine : vaccineList) {
            System.out.println(vaccine);
        }
    }

    public static void createAdoption() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String adoptionID;
        String petID;
        String customerID;
        String pickUpDate;
        String adoptionAgreement;
        double adoptionCost = 0;

        do {
            System.out.println(line);
            System.out.println("Please enter the adoption ID");
            adoptionID = scan.nextLine();
            System.out.println("Please enter the pet ID");
            petID = scan.nextLine();
            System.out.println("Please enter the customer ID");
            customerID = scan.nextLine();
            System.out.println("Please enter the pick up date");
            pickUpDate = scan.nextLine();
            System.out.println("Please enter the adoption agreement");
            adoptionAgreement = scan.nextLine();
            System.out.println("Please enter the adoptionCost");

            boolean isValid = false;

            while (!isValid) {
                try {
                    adoptionCost = scan.nextDouble();
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                }
                scan.nextLine();
            }

            System.out.println("Please verify all the information entered");
            System.out.printf("Adoption ID:  %s\n", adoptionID);
            System.out.printf("Pet ID:       %s\n", petID);
            System.out.printf("Customer ID:  %s\n", customerID);
            System.out.printf("Pickup Date:  %s\n", pickUpDate);
            System.out.printf("Adoption Agr: %s\n", adoptionAgreement);
            System.out.printf("Adoption Cos: %s\n", adoptionCost);

            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        adoptionList.add(new Adoption(adoptionID, petID, customerID, pickUpDate, adoptionAgreement, adoptionCost));
    }

    public static void editAdoption() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void printAdoption() {
        for (Adoption adoption : adoptionList) {
            System.out.println(adoption);
        }
    }

    public static void createPetVaccination()  {
        Scanner scan = new Scanner(System.in);
        String userInput = "";

        String employeeID;
        String vaccineID;
        String petID;
        String dateAdministered;
        String nextDueDate;
        String notes;

        do {
            System.out.println(line);
            System.out.println("Please enter the employee ID");
            employeeID = scan.nextLine();
            System.out.println("Please enter the vaccine ID");
            vaccineID = scan.nextLine();
            System.out.println("Please enter the petID");
            petID = scan.nextLine();
            System.out.println("Please enter the date administered");
            dateAdministered = scan.nextLine();
            System.out.println("Please enter the next due date");
            nextDueDate = scan.nextLine();
            System.out.println("Please enter the notes");
            notes = scan.nextLine();

            System.out.println("Please verify all the information entered");
            System.out.printf("Employee ID:    %s\n", employeeID);
            System.out.printf("Vaccine ID:     %s\n", vaccineID);
            System.out.printf("Pet ID:         %s\n", petID);
            System.out.printf("Date Admin:     %s\n", dateAdministered);
            System.out.printf("Next Due Date:  %s\n", nextDueDate);
            System.out.printf("Notes:          %s\n", notes);

            System.out.println("If the information is correct please enter y, if not please enter n");

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));

        petVaccineList.add(new Pet_Vaccination(employeeID, vaccineID, petID, dateAdministered, nextDueDate, notes));
    }

    public static void editPetVaccination() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void printPetVaccination() {
        for (Pet_Vaccination petVaccination : petVaccineList) {
            System.out.println(petVaccination);
        }
    }
}

