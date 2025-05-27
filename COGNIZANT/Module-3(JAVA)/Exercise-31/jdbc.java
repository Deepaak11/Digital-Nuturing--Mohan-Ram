import java.sql.*;
public class jdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school"; 
        String user = "root"; 
        String password = "Saravanan@1104"; 
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM students";
            rs = stmt.executeQuery(sql);
            System.out.println("ID\tName\t\tGrade");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                System.out.println(id + "\t" + name + "\t\t" + grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
