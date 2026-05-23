package day2;
import java.util.Scanner;
public class task2_2_pasword {
public static void main(String[] args) {
	
	String password="ashish123";
	Scanner sc = new Scanner(System.in);
	for(int i=0;i<3;i++) {
		System.out.println("enter your password "+i+"/3 try");
		String pass=sc.nextLine();
		if(pass.equals(password)) {
			System.out.println("correct");
			break;
		}
		else {
			System.out.print("try again");
		}
	}
	System.out.println("thank you for using eclipse password protector");
	sc.close();
}
}
