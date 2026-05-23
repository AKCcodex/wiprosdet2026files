package day17;
import java.sql.*;

public class DepartmentWise {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "Root@123");

            String query = "SELECT * FROM employee ORDER BY department";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("department"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}