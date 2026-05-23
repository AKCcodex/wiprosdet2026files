package assigbmentday1;
import java.util.Scanner;
public class oddoreven {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number");
	int i=sc.nextInt();
	if(i%2==0) {
		System.out.println("number is even");
	}
	else {
		System.out.println("number is odd");
	}
	sc.close();
}
}
