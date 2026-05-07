package day12;
import java.io.*;
public class fooddelivary {
	 public static void main(String[] args) {

	        try {

	            BufferedWriter mw = new BufferedWriter(
	                    new FileWriter("menu.txt"));

	            mw.write("101, Pizza, 250");
	            mw.newLine();
	            mw.write("102, Burger, 120");
	            mw.newLine();
	            mw.write("103, Pasta, 200");

	            mw.close();
	            System.out.println("Menu Created");


	            BufferedWriter ow = new BufferedWriter(
	                    new FileWriter("orders.txt"));

	            int orderId = 1;
	            String name = "ashish";
	            String item = "pizza";
	            int qty = 2;
	            double total = 500;

	            String order = "OrderID: " + orderId +
	                           " Name: " + name +
	                           " Item: " + item +
	                           " Qty: " + qty +
	                           " Total: " + total;

	            ow.write(order);
	            ow.newLine();
	            ow.close();

	            System.out.println("Order Saved");


	            BufferedWriter dw = new BufferedWriter(
	                    new FileWriter("delivery" + orderId + ".txt"));

	            String status = "Delivered";
	            String time = "10:30AM";

	            dw.write("----- DELIVERY DETAILS -----\n");
	            dw.write("Order ID: " + orderId + "\n");
	            dw.write("Customer: " + name + "\n");
	            dw.write("Item: " + item + "\n");
	            dw.write("Status: " + status + "\n");
	            dw.write("Time: " + time + "\n");

	            dw.close();

	            System.out.println("Delivery File Created: delivery" + orderId + ".txt");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
