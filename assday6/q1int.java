package assday6;

public class q1int {
	
	    static void changeValue(int x) {
	        x = x + 10;
	        System.out.println("Inside method: " + x);
	    }

	    public static void main(String[] args) {
	        int num = 5;
	        System.out.println("Before method call: " + num);
	        
	        changeValue(num);
	        
	        System.out.println("After method call: " + num);
	    }
	
}
