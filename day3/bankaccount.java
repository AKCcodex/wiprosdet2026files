package day3;

public class bankaccount {
static class BankAccount{
	private double balance;
	
	public BankAccount(double balance) {
		this.balance=balance;
	}
	public void diposit(double amount) {
		if(amount>0) {
			balance+=amount;
		}
		else {
			System.out.println("Invalid deposite amount");
			
		}
		
	}
	public void withdraw(double amount) {
		if(amount>balance) {
			System.out.println("insficient balance");
		}
		else {
			balance=balance-amount;
		}
	}
	public double getBalance() {
		return balance;
	}
}
public static void main(String[] args) {
	double sa = 400000;
	BankAccount emp=new BankAccount(sa);
	System.out.println(emp.getBalance());
	emp.withdraw(40000);
	System.out.println(emp.getBalance());
}
}
