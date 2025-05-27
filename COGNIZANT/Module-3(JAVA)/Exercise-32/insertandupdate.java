import java.sql.*;
public class insertandupdate {
    static class Student {
        int id;
        String name;
        String grade;
        Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }
        Student(int id, String name, String grade) {
            this.id = id;
            this.name = name;
            this.grade = grade;
        }
    }
    static final String URL = "jdbc:mysql://localhost:3306/college"; 
    static final String USER = "root";
    static final String PASSWORD = "Saravanan@1104"; 
    public static void insertStudent(Student student) {
        String sql = "INSERT INTO students (name, grade) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.name);
            stmt.setString(2, student.grade);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, grade = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.name);
            stmt.setString(2, student.grade);
            stmt.setInt(3, student.id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Student newStudent = new Student("John Doe", "B");
        insertStudent(newStudent);
        Student updatedStudent = new Student(1, "John Updated", "A");
        updateStudent(updatedStudent);
    }
}
