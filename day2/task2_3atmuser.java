package day2;
import java.util.Scanner;
public class task2_3atmuser {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int i=0;
	while(i!=4) {
	System.out.println("Welcome to eclipse ATM");
	System.out.println("1.balance");
	System.out.println("2.OTP");
	System.out.println("3.quick pin");
	System.out.println("4.exit");
	i=sc.nextInt();
	}
	System.out.println("Thank you");
}
}
