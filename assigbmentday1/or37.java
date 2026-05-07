package assigbmentday1;
import java.util.Scanner;
public class or37 {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int num = sc.nextInt();
	        sc.close();
	        if (num % 3 == 0 || num % 7 == 0) {
	            System.out.println("divisible by 3 or 7.");
	        } else {
	            System.out.println("not divisible by 3 or 7.");
	        }
	 
	    }
}
