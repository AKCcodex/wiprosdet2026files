package day12;
import java.io.*;
import java.util.*;
public class bankingapplication {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to Banking System");

    try {
        FileWriter fw = new FileWriter("transaction.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Exit");
            System.out.println("3.backend option only for account holder");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = sc.next();

                System.out.print("Enter Amount: ");
                int amount = sc.nextInt();

                String transaction = name + " deposited " + amount;
                
                bw.write(transaction);
                bw.newLine();
                bw.flush(); 
                System.out.println("Transaction Saved!");

            } else if (choice == 2) {
                System.out.println("Exiting...");
                break;
            }
            else if(choice==3){
            	FileReader fr = new FileReader("transaction.txt");
                BufferedReader br = new BufferedReader(fr);
                String ln;
                while((ln=br.readLine())!=null) {
                	System.out.println(ln);
                }
                br.close();
            }
            else {
                System.out.println("Invalid choice!");
            }
        }

        bw.close();
        sc.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
