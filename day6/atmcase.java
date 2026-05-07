package day6;
import java.util.Scanner;

class atmchecker{
	String card;
	int pin;
	 atmchecker(String card,int pin) {
		this.card=card;
		this.pin=pin;
	}
	void pinchecker() throws Exception {
		if(pin==0000) {
			System.out.println("card and pin correct");
		}
		else {
			throw new Exception("pin is incorrect");
		}
	}
}
public class atmcase {

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Atm exception handling");
	System.out.println("please insert your card xxxx-xxxx-xxxx");
	String card=sc.nextLine();
	System.out.println("enter your pin");
	int pin=sc.nextInt();
	try {
		atmchecker obj=new atmchecker(card,pin);
		obj.pinchecker();
		
	}
	catch (Exception e) {
		System.out.println("exception caught " + e.getMessage());
	}
	finally {
		System.out.println("transation logged");
		sc.close();
	}
	
	
	
}
}
