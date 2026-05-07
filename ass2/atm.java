package ass2;
import java.util.Scanner;
public class atm {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 1000;

        while (true) {
            System.out.println("\n1.Check Balance\n2.Deposit\n3.Withdraw\n4.Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("Balance: " + balance);
            } else if (ch == 2) {
                System.out.print("Enter amount: ");
                balance += sc.nextDouble();
            } else if (ch == 3) {
                System.out.print("Enter amount: ");
                double amt = sc.nextDouble();
                if (amt <= balance) balance -= amt;
                else System.out.println("Insufficient balance");
            } else if (ch == 4) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
