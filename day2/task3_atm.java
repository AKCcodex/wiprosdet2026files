package day2;

public class task3_atm {
 static int cash =10000;
 static int balance =5000;
 public static void main(String[] args) {
	if(balance>=cash) {
		System.out.println("available for withdrawal");
	}
	else {
		System.out.println("not availabe for withdrawal");
	}
}
}
