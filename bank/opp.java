package bank;

public class opp {
public static void main(String[] args) {
	interest b1 = new sbi();
	interest b2 = new HDFC();
	

    System.out.println("SBI Interest Rate: " + b1.getInterestRate() + "%");
    System.out.println("HDFC Interest Rate: " + b2.getInterestRate() + "%");
   
}
}
