package day10;
import java.util.*;


class Patient implements Comparable<Patient> {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

@Override
    public int compareTo(Patient p) {
        return Integer.compare(this.id, p.id);
    }
@Override
    public String toString() {
        return "[ID: " + id + " | Name: " + name + " | Age: " + age + "]";
    }
}


public class OPD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idrefrence=1;
        TreeSet<Patient> records = new TreeSet<>();
        while (true) {
            System.out.println("\n--- HOSPITAL OPD (TREESET) ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Call Next Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    System.out.print("current available id slot: "+idrefrence);
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    Patient newPatient = new Patient(id, name, age);
                    idrefrence++;
                    if (!records.add(newPatient)) {
                        System.out.println("Patient already exists with this ID!");
                    } else {
                        System.out.println("Patient added successfully.");
                    }
                    break;
                case 2:
                    if (!records.isEmpty()) {
                        Patient first = records.pollFirst();
                        System.out.println("Calling patient: " + first);
                    } else {
                        System.out.println("No patients waiting.");
                    }
                    break;
                case 3:
                    if (records.isEmpty()) {
                        System.out.println("No patients.");
                    } else {
                        System.out.println("Patient List:");
                        for (Patient p : records) {
                            System.out.println(p);
                        }
                    }
                    break;
                case 4:
                    System.out.println("System Closed.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}