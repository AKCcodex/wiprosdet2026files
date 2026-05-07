package assigbmentday1;
import java.util.Scanner;
public class positiveornegative {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number");
	int i=sc.nextInt();
	if(i>0) {
		System.out.println("the number is positive");
		
	}
	else if(i<0){
		System.out.println("the number is negative");
	}
	else {
		System.out.println("the number is zero");
	}
	sc.close();
}
}
