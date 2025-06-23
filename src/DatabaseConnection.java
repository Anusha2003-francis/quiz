import java.sql.*;

public class DatabaseConnection {

    Connection con;

    public Connection connect() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/quiz_app", // DB URL
                "root",                                 // DB username
                "anusha"                         // DB password
            );

            return con;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveScore(String username, int score) {
        try {
            Connection con = connect();
            if (con != null) {
                String query = "INSERT INTO quiz_scores(username, score) VALUES (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setInt(2, score);
                pstmt.executeUpdate();
                pstmt.close();
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
