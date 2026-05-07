package INTERFACE;

class UPIPayment implements Payment {

  
    public void makePayment(double amount) {
        try {
            if (amount <= 0) {
                throw new Exception("Invalid amount!");
            }
            System.out.println("Payment successful: ₹" + amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}