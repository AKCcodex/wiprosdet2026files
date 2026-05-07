package day2;
import java.util.Scanner;
public class task2_5_shopping {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int total=0;
	int i=1;
	while(i!=0) {
		System.out.println("enter the amount");
		int alpha=sc.nextInt();
		i=alpha;
		total+=alpha;
		
	}
	System.out.println("total amount is" + total );
}
}
