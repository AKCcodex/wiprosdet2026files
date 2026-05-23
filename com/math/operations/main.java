package com.math.operations;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first num");
		int a=sc.nextInt();
		System.out.println("enter second num");
		int b=sc.nextInt();
		cal obj=new cal();
		System.out.println("what operation want to perform + or -");
		System.out.println("1. add");
		System.out.println("2. subtract");
		
		int option=sc.nextInt();
		if(option==1) {
			obj.add(a , b);
		}
		if(option==2) {
			obj.sub(a, b);
		}
		sc.close();
		
		
	}

}
