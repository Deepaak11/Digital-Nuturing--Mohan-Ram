import java.sql.*;
public class transaction {
    static final String URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASSWORD = "Saravanan@1104";
    public static void transferMoney(int fromAccount, int toAccount, double amount) {
        String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccount);
                debitStmt.executeUpdate();
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccount);
                creditStmt.executeUpdate();
                conn.commit();
                System.out.println("Transfer successful!");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transfer failed, transaction rolled back.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        transferMoney(1, 2, 100.0); 
    }
}
