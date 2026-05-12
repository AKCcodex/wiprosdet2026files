package day17;
import java.sql.*;

public class CRUDDemo {

    static Connection con;

    static {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company",
                    "root",
                    "Root@123");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void insert(int id, String name, String dept, double sal) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employee VALUES(?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, dept);
        ps.setDouble(4, sal);

        ps.executeUpdate();
        System.out.println("Inserted");
    }

    static void display() throws Exception {
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM employee");

        while (rs.next())
            System.out.println(rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3) + " " +
                    rs.getDouble(4));
    }

    static void update(int id, double sal) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "UPDATE employee SET salary=? WHERE id=?");

        ps.setDouble(1, sal);
        ps.setInt(2, id);

        ps.executeUpdate();
        System.out.println("Updated");
    }

    static void delete(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM employee WHERE id=?");

        ps.setInt(1, id);

        ps.executeUpdate();
        System.out.println("Deleted");
    }

    public static void main(String[] args) throws Exception {

        insert(106, "Amit", "IT", 60000);
        display();

        update(106, 75000);
        display();

        delete(106);
        display();
    }
}