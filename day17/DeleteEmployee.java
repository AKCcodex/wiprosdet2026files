package day17;
import java.sql.*;

public class DeleteEmployee {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "Root@123");

            String query = "DELETE FROM employee WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 102);

            int rows = ps.executeUpdate();

            System.out.println(rows + " Record Deleted");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}