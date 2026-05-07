package assigbmentday1;
import java.util.Scanner;
public class larger3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first num1");
		int num1=sc.nextInt();
		System.out.println("enter the second num2");
		int num2=sc.nextInt();
		System.out.println("enter the second num3");
		int num3=sc.nextInt();
		sc.close();
		
		if(num1>num2 && num1>num3) {
			System.out.print("num1 is larger num");
		}
		else if(num2>num1 && num2>num3) {
			System.out.print("num2 is larger num");
		}
		else {
			System.out.print("num3 is larger");
		}
	}
}
