package ass2;
import java.util.Scanner;
public class table {
	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n, i = 1;

	        System.out.print("Enter a number: ");
	        n = sc.nextInt();

	        while (i <= 10) {
	            System.out.println(n + " x " + i + " = " + (n * i));
	            i++;
	        }
	    }
}
