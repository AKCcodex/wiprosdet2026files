package ass2;
import java.util.Scanner;
public class reverce {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n, rev = 0;

	        System.out.print("Enter a number: ");
	        n = sc.nextInt();

	        while (n > 0) {
	            int digit = n % 10;
	            rev = rev * 10 + digit;
	            n = n / 10;
	        }

	        System.out.println("Reversed number = " + rev);
	    }
}
