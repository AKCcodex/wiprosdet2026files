////package day5;
////interface UPI {
////	final int accountno=1234567;
////    void sendMoney(double amount);
////    void receiveMoney(double amount);
////    void balance();
////    default void transactionStatus() {
////        System.out.println("thank you for using UPI");
////    }
////}
////
////class GooglePay implements UPI {
////    private double balance = 1000;
////
////    public void sendMoney(double amount) {
////        if (balance >= amount) {
////            balance -= amount;
////            System.out.println("GPay: Sent " + amount + " on " + UPI.accountno);
////        } else {
////            System.out.println("GPay: Insufficient balance");
////        }
////    }
////    public void balance() {
////    	System.out.println(balance);
////    	}
////    public void receiveMoney(double amount) {
////        balance += amount;
////        System.out.println("GPay: Received " + amount + " on " + UPI.accountno);
////    }
////}
//
//
//
//public class upiinterface {
//	  public static void main(String[] args) {
//	        UPI app1 = new GooglePay();
//	        app1.sendMoney(200);
//	        app1.balance();
//	        app1.transactionStatus();
//
//
//	    }
//	}