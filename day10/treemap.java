package day10;
import java.util.*;
public class treemap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Patient> map = new TreeMap<>();
        //TreeMap<Integer, Patient> map = new TreeMap<>(Collections.reverseOrder());
        int refid=1;
        while (true) {
            System.out.println("\n--- HOSPITAL SYSTEM ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Retrieve Patient");
            System.out.println("4. Remove Patient");
            System.out.println("5. List All Patients");
            System.out.println("6. Check Patient Exists");
            System.out.println("7. Count Patients");
            System.out.println("8. Clear System");
            System.out.println("9. first Patient & last Patient");
            System.out.println("10. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter ID: ");
                    System.out.println("refrence id is :" + refid);
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (map.containsKey(id)) {
                        System.out.println("Patient already exists!");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    map.put(id, new Patient(id, name, age));
                    System.out.println("Patient added.");
                    refid++;
                    break;
                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    if (!map.containsKey(uid)) {
                        System.out.println("Patient not found.");
                        break;
                    }
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    map.put(uid, new Patient(uid, newName, newAge));
                    System.out.println("Patient updated.");
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int rid = sc.nextInt();
                    Patient p = map.get(rid);
                    if (p != null)
                        System.out.println("Found: " + p);
                    else
                        System.out.println("Not found.");
                    break;
                case 4:
                    System.out.print("Enter ID to remove: ");
                    int did = sc.nextInt();
                    if (map.remove(did) != null)
                        System.out.println("Patient removed.");
                    else
                        System.out.println("Not found.");
                    break;
                case 5:
                    if (map.isEmpty()) {
                        System.out.println("No patients.");
                    } else {
                        for (Patient patient : map.values()) {
                            System.out.println(patient);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter ID: ");
                    int cid = sc.nextInt();
                    if (map.containsKey(cid))
                        System.out.println("Patient exists.");
                    else
                        System.out.println("Patient not found.");
                    break;
                case 7:
                    System.out.println("Total Patients: " + map.size());
                    break;
                case 8:
                    map.clear();
                    System.out.println("System cleared.");
                    break;
                case 9:
                	Patient pk=map.get(map.firstKey());
                	System.out.println("first patitent is :" + pk);
                	Patient lk=map.get(map.lastKey());
                	System.out.println("last patient is :"+ lk);
                	break;
                case 10:
                    System.out.println("System Closed.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}