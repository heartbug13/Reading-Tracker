import java.sql.Array;
import java.util.ArrayList;
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
                    } while (!(userInput.equals("C")));
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
                    } while (!(userInput.equals("C")));
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
                    } while (!(userInput.equals("C")));
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
                    } while (!(userInput.equals("C")));
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
                    } while (!(userInput.equals("C")));
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
                    } while (!(userInput.equals("C")));
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
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
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

    }

    public static void createPet() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
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
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void createVaccine() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
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
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void createAdoption() {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
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
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
    }

    public static void createPetVaccination()  {
        Scanner scan = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(line);

            userInput = scan.nextLine();
        } while (!userInput.equals("y"));
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

    }
}

