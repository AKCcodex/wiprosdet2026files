package ass2;
import java.util.Scanner;
public class armstronnum {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n, original, sum = 0;

	        System.out.print("Enter a number: ");
	        n = sc.nextInt();
	        sc.close();
	        original = n;

	        while (n > 0) {
	            int digit = n % 10;
	            sum = sum + (digit * digit * digit);
	            n = n / 10;
	        }

	        if (sum == original) {
	            System.out.println("Armstrong number");
	        } else {
	            System.out.println("Not an Armstrong number");
	        }
	    }
}
