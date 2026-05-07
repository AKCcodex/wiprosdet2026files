package ass2;
import java.util.Scanner;
public class evenoddswitch {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter your number");
	int  num = sc.nextInt();
	num=num%2;
	switch (num) {
	 case 0:
         System.out.println("EVEN number.");
         break;
     case 1:
         System.out.println("ODD number.");
         break;
     default:
         System.out.println("Invalid input.");
	}
	sc.close();
}
}
