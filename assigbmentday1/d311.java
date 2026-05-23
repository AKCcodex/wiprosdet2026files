package assigbmentday1;
import java.util.Scanner;
public class d311 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = sc.nextInt();   
    sc.close();
    if (num % 5 == 0 && num % 11 == 0) {
        System.out.println(" divisible by both 5 and 11.");
    } else {
        System.out.println("not divisible by both 5 and 11.");
    }

   
}
}
