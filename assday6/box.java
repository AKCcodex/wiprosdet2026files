package assday6;
class Box {
    int length;

    Box(int l) {
        length = l;
    }
}
public class box {
	


	    static void modify(Box b) {
	        b.length = b.length + 10;
	        System.out.println("Inside method: " + b.length);
	    }

	    public static void main(String[] args) {
	    	System.out.println("box");
	        
	        Box box = new Box(5);
	        System.out.println("Before method call: " + box.length);
	        
	        modify(box);
	        
	        System.out.println("After method call: " + box.length);
	    
	}
}
