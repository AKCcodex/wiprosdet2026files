package ass2;
import java.util.Scanner;
public class menu {
	public static void main(String[] args) {
		System.out.println("WELCOME TO eclipse cafe");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" MENU ");
		System.out.println("1.tea");
		System.out.println("2.black tea");
		System.out.println("3.milkshake");
		System.out.println("4.soup");
		System.out.println("5.apple");
		Scanner sc=new Scanner(System.in);
		int select=sc.nextInt();
		sc.close();
		switch(select) {
		case 1:
			System.out.println("one tea comming right up");
			System.out.println("bill is 45 Thank you for visiting eclipse cafe");
			break;
		case 2:
			System.out.println("one black tea comming right up");
			System.out.println("bill is 451 Thank you for visiting eclipse cafe");
			break;
		case 3:
			System.out.println("one milkshake comming right up");
			System.out.println("bill is 452 hank you for visiting eclipse cafe");
			break;
		case 4:
			System.out.println("one soup comming right up");
			System.out.println("bill is 453 Thank you for visiting eclipse cafe");
			break;
		case 5:
			System.out.println("one apple comming right up");
			System.out.println("bill is 454 Thank you for visiting eclipse cafe");
			break;
		default:
			System.out.println("we dont serve out of menu");
			System.out.println("bill is 455 Thank you for visiting eclipse cafe");
			break;
			
			
		}
	}
}
