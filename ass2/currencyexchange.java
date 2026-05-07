package ass2;
import java.util.Scanner;
public class currencyexchange {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        double inr, result = 0;

        System.out.println("1. INR to USD");
        System.out.println("2. INR to EUR");
        System.out.println("3. INR to GBP");
        
        System.out.print("Enter choice: ");
        choice = sc.nextInt();

        System.out.print("Enter amount in INR: ");
        inr = sc.nextDouble();

        if (choice == 1) {
            result = inr / 97;
            System.out.println("USD = " + result);
        } 
        else if (choice == 2) {
            result = inr /77;
            System.out.println("EUR = " + result);
        } 
        else if (choice == 3) {
            result = inr / 27;
            System.out.println("GBP = " + result);
        } 
        else {
            System.out.println("Invalid choice");
        }
    }
}
