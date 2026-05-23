package day9;

import java.util.*;

class Patient2 {
    int id;
    String name;

    Patient2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> patientIds = new HashSet<>();

        List<Patient2> patients = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    if (patientIds.contains(id)) {
                        System.out.println(" Patient ID already registered!");
                    } else {
                        System.out.print("Enter Patient Name: ");
                        String name = sc.nextLine();

                        Patient2 p = new Patient2(id, name);
                        patients.add(p);
                        patientIds.add(id);

                        System.out.println(" Patient added to the system");
                    }
                    break;

                case 2:
                    if (patients.isEmpty()) {
                        System.out.println("No patients registered.");
                    } else {
                        System.out.println("\nRegistered Patients:");
                        for (Patient2 p : patients) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}