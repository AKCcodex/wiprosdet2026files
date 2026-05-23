package ass2;
import java.util.Scanner;
public class fibonachi {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int n, a = 0, b = 1, i = 1;

	        System.out.print("Enter number of terms: ");
	        n = sc.nextInt();

	        while (i <= n) {
	            System.out.print(a + " ");
	            int next = a + b;
	            a = b;
	            b = next;
	            i++;
	        }
	    }
}
