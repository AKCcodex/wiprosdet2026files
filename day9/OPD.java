package day9;
import java.util.*;

class Patient {
    int id;
    String name;
    int age;

    Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public String toString() {
        return "[ID: " + id + " | Name: " + name + " | Age: " + age + "]";
    }
}

public class OPD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        LinkedList<Patient> records = new LinkedList<>();
        int id=1;
        while (true) {
            System.out.println("\n--- HOSPITAL OPD (LINKED LIST) ---");
            System.out.println("1. Register Patient ");
            System.out.println("2. Register Patient (EMERGENCY)");
            System.out.println("3. Call Next Patient ");
            System.out.println("4. View All Patients");
            System.out.println("5. Search Patient by Name");
            System.out.println("6. Show Next Patient");
            System.out.println("7. Show Last Patient");
            System.out.println("8. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
           
           
            switch (choice) {
                case 1:
                    
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    records.addLast(new Patient(id, name, age));
                    id++;
                    System.out.println("Added to the end of the queue.");
                    break;

                case 2:
                    
                    System.out.print("Name: "); String ename = sc.nextLine();
                    System.out.print("Age: "); int eage = sc.nextInt();
                    records.addFirst(new Patient(id, ename, eage));
                    id++;
                    System.out.println("Emergency patient moved to the front!");
                    break;

                case 3:
                    if (!records.isEmpty()) {
                        Patient removed = records.removeFirst();
                        System.out.println("Calling patient: " + removed.name);
                    } else {
                        System.out.println("No patients waiting.");
                    }
                    break;

                case 4:
                    if (records.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Current Queue:");
                        for (Patient p : records) System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.print("Search Name: ");
                    String sName = sc.nextLine();
                    boolean found = false;
                    for (Patient p : records) {
                        if (p.name.equalsIgnoreCase(sName)) {
                            System.out.println("Found: " + p);
                            found = true;
                        }
                    }
                    if (!found)
                    	System.out.println("Patient not in records.");
                    break;

                case 6:
                    if (!records.isEmpty()) 
                        System.out.println("Next up: " + records.peekFirst());
                    else 
                        System.out.println("Queue empty.");
                    break;

                case 7:
                    if (!records.isEmpty()) 
                        System.out.println("Last in line: " + records.peekLast());
                    else 
                        System.out.println("Queue empty.");
                    break;

                case 8:
                    System.out.println("System Closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}