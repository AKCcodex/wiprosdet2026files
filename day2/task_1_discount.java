package day2;

public class task_1_discount {
	static int amount=10002;
public static void main(String[] args) {
	
	if(amount>=5000) {
		System.out.println("eligible for discount");
		System.out.println(amount-45);
		
	}
	else if(amount>=1000) {
		System.out.println("eligible for discount");
		System.out.println(amount-100);
		
	}
	else {
		System.out.println("not eligible for discount");
	}
}
}
