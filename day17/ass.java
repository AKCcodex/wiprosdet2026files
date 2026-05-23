package day17;
import java.sql.*;
import java.util.Scanner;

public class ass {
	 public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/school1";
	        String user = "root";
	        String password = "Root@123";

	        Scanner sc = new Scanner(System.in);

	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");
	     
	            Connection con = DriverManager.getConnection(url, user, password);
	
	            System.out.print("Enter Student ID: ");
	            int id = sc.nextInt();
	            sc.nextLine();

	            System.out.print("Enter Student Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Student Age: ");
	            int age = sc.nextInt();


	            String query = "INSERT INTO students VALUES (?, ?, ?)";

	            PreparedStatement pst = con.prepareStatement(query);

	            pst.setInt(1, id);
	            pst.setString(2, name);
	            pst.setInt(3, age);

	            int rows = pst.executeUpdate();

	            if (rows > 0) {
	                System.out.println("Record Inserted Successfully");
	            }

	            con.close();

	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
}
