package ass2;
import java.util.Scanner;
public class prime {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, i = 2;
        boolean isPrime = true;

        System.out.print("Enter a number: ");
        n = sc.nextInt();

        if (n <= 1) {
            isPrime = false;
        } else {
            while (i <= n / 2) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
        }

        if (isPrime) {
            System.out.println("Prime number");
        } else {
            System.out.println("Not a prime number");
        }
    }
}
