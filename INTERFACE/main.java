package INTERFACE;

public class main {
	public class MainApp {

	    public static void main(String[] args) {

	        Payment p = new UPIPayment();

	        p.makePayment(500);  
	        p.makePayment(-100);  
	    }
	}
}
