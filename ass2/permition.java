package ass2;
import java.util.Scanner;
public class permition {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        String role;

	        System.out.print("Enter role (Admin/User/Guest): ");
	        role = sc.nextLine();

	        if (role.equalsIgnoreCase("Admin")) {
	            System.out.println("Full access");
	        } 
	        else if (role.equalsIgnoreCase("User")) {
	            System.out.println("Limited access");
	        } 
	        else if (role.equalsIgnoreCase("Guest")) {
	            System.out.println("View only access");
	        } 
	        else {
	            System.out.println("Invalid role");
	        }
	    }
}
