package assigbmentday1;
import java.util.Scanner;
public class Loaneligibility {
public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);

     System.out.print("Enter Age: ");
     int age = sc.nextInt();
     System.out.print("Enter Monthly Salary: ");
     double salary = sc.nextDouble();
     if (age >= 18 && age <= 60 && salary >= 15000) {
         System.out.println("Congratulations! You are eligible for the loan.");
     } else {
         System.out.println("Sorry, you are not eligible based on age or income.");
     }
     
     sc.close();
}
}
