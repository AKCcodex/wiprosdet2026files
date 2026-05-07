package day9;
import java.util.*;

class patient {
    int id;
    String name;
    int age;

    patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }
}

public class hospitalOPD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<patient> records = new ArrayList<>();
        Set<Integer> patientIds = new HashSet<>();
        while (true) {
            System.out.println("\n--- WELCOME TO OPD SYSTEM ---");
            System.out.println("1. Register a new patient");
            System.out.println("2. Register emergency patient");
            System.out.println("3. Remove patient (Next in line)");
            System.out.println("4. View all patients");
            System.out.println("5. Search patient by name");
            System.out.println("6. View first patient");
            System.out.println("7. View last patient");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter patient age: ");
                    int age = sc.nextInt();
                    records.add(new patient(id, name, age));
                    System.out.println("Patient added.");
                    break;

                case 2:
                    System.out.print("Enter emergency Patient ID: ");
                    int eid = sc.nextInt();
                    sc.nextLine(); // Flush
                    System.out.print("Enter emergency patient name: ");
                    String ename = sc.nextLine();
                    System.out.print("Enter emergency patient age: ");
                    int eage = sc.nextInt();
                    // Adds to the front of the list
                    records.add(0, new patient(eid, ename, eage));
                    System.out.println("Emergency patient prioritized.");
                    break;

                case 3:
                    if (records.isEmpty()) {
                        System.out.println("No patients in OPD.");
                    } else {
                        records.remove(0);
                        System.out.println("Patient removed.");
                    }
                    break;

                case 4:
                    if (records.isEmpty()) {
                        System.out.println("No patients in records.");
                    } else {
                        for (patient k : records) {
                            System.out.println(k);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (patient s : records) {
                        if (s.name.equalsIgnoreCase(searchName)) {
                            System.out.println("Patient found: " + s);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Patient not found.");
                    break;

                case 6:
                    if (!records.isEmpty()) {
                        System.out.println("First patient: " + records.get(0));
                    } else {
                        System.out.println("Record is empty.");
                    }
                    break;

                case 7:
                    if (!records.isEmpty()) {
                        System.out.println("Last patient: " + records.get(records.size() - 1));
                    } else {
                        System.out.println("Record is empty.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting... Thank you.");
                    sc.close();
                    return; // Terminates the program

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}