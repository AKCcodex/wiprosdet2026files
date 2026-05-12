package day17;
import java.sql.*;

public class DisplayStudents {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school1";
        String user = "root";
        String password = "Root@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM students";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            System.out.println("ID\tNAME\tAGE");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getInt("age"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}