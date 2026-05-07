package ass2;
import java.util.Scanner;
public class palindrome {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, original, rev = 0;

        System.out.print("Enter a number: ");
        n = sc.nextInt();

        original = n;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }

        if (original == rev) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
