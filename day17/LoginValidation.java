package day17;
import java.sql.*;
import java.util.Scanner;

public class LoginValidation {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school1";
        String user = "root";
        String password = "Root@123";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            
            
            String pass = sc.nextLine();

            String query = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, username);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}