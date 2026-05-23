package ass2;

import java.util.Scanner;

public class fact {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	       	        int n, fact = 1;

	        System.out.print("Enter a number: ");
	        n = sc.nextInt();

	        while (n > 0) {
	            fact = fact * n;
	            n--;
	        }

	        System.out.println("Factorial = " + fact);
	        sc.close();

	    }
}
