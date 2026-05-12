package day17;
import java.sql.*;

public class FetchHighSalary {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "Root@123");

            String query = "SELECT * FROM employee WHERE salary > ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, 50000);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("department") + " " +
                        rs.getDouble("salary"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}