package day17;
import java.sql.*;
import java.util.Scanner;

public class MultipleInsert {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school1";
        String user = "root";
        String password = "Root@123";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO students VALUES (?, ?, ?)";

            PreparedStatement pst = con.prepareStatement(query);

            System.out.print("How many records do you want to insert? ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {

                System.out.println("Enter Details for Student " + i);

                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();

                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setInt(3, age);
                pst.executeUpdate();
            }
            System.out.println("All Records Inserted Successfully");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}