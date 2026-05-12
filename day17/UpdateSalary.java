package day17;
import java.sql.*;

public class UpdateSalary {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "Root@123");

            String query = "UPDATE employee SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, 80000);
            ps.setInt(2, 101);

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Updated");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}