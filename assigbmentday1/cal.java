package assigbmentday1;
import java.util.Scanner;
public class cal {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter two numbers and operator: ");
	        double a = sc.nextDouble(); 
	        double b = sc.nextDouble();
	        char op = sc.next().charAt(0);

	        switch (op) {
	            case '+': 
	                System.out.print(a + b); 
	                break;
	            case '-': 
	                System.out.print(a - b); 
	                break;
	            case '*': 
	                System.out.print(a * b); 
	                break;
	            case '/': 
	                if(b==0) {
	                	System.out.print("error");
	                	 break;
	                }
	                else {
	                	System.out.print(a / b); 
		                break;
	                }
	            default: 
	                System.out.print("Invalid");
	        }
	    }
}
