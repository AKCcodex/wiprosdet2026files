package day12;
import java.util.*;
import java.io.*;
public class ecommerce {
	 public static void main(String[] args) throws IOException {
		 Scanner sc=new Scanner(System.in);
	        BufferedWriter bw = new BufferedWriter(
	                new FileWriter("orders.txt", true));
	        System.out.println("enter order details");
	        System.out.print("enter order id");
	        int orderId = sc.nextInt();
	        System.out.println("enter product name");
	        String product=sc.next();
	        System.out.println("enter product quantity");
	        int quant=sc.nextInt();
	        System.out.println("enter product price");
	        double price=sc.nextDouble();
	        String order = "OrderID : "+orderId+" , Product: "+product+" , Qty:  " + quant+" price: "+price;

	        bw.write(order);
	        bw.newLine();
	        bw.close();

	        System.out.println("Order Saved!");
	        
	        BufferedWriter biw = new BufferedWriter(
	                new FileWriter("invoice_" + orderId + ".txt"));

	        biw.write("----- INVOICE -----\n");
	        biw.write("Order ID: " + orderId + "\n");
	        biw.write("Product: \n"+product);
	        biw.write("Quantity: \n"+quant);
	        biw.write("Total: \n"+price);

	        biw.close();
	        System.out.println("Invoice Generated!");
	        
	        BufferedWriter dw = new BufferedWriter(
	                new FileWriter("shipping.txt", true));
	        System.out.println("enter shipping details");
	        System.out.println("enter coustomer name");
	        String name=sc.next();
	        sc.nextLine();
	        System.out.println("enter addresss");
	        String address=sc.nextLine();
	        
	        String data = "OrderID: "+orderId+"  Name: "+name+" Address:"+address;

	        dw.write(data);
	        dw.newLine();
	        dw.close();

	        System.out.println("Shipping Details Saved!");
	        
	    }
}
