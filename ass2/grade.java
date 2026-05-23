package ass2;
import java.util.Scanner;
public class grade {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("enter grade");
		char g= sc.next().charAt(0);
		sc.close();
		if(g=='A') System.out.println("Excellent");
        else if(g=='B') System.out.println("Good");
        else if(g=='C') System.out.println("Average");
        else if(g=='D') System.out.println("Poor");
        else System.out.println("Fail");
		
	}
}
