package day5;
class payment{
	private int balance=0;
	private final int upiid=123456;
	final void processpay(int id,int key,int amount) {
		if(key==0) {
		if(upiid==id) {
			balance+=amount;
			System.out.println("payment success amount creadited is" + balance + " to upi id is " + upiid );
		}
		else {
			System.out.println("payment failed");
		}
	}
	else {
		if(upiid==id) {
			balance-=amount;
			System.out.println("payment success amount creadited is" + balance + " to upi id is " + upiid );
		}
		else {
			System.out.println("payment failed");
		}
	}
		
	}
	
}
public class processpayment {
public static void main(String[] args) {
	payment a1=new payment();
	a1.processpay(123456, 1, 1000);
	a1.processpay(123456, 1, 1000);
}
}
