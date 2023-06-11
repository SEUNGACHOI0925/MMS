import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberMain {
	public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // MySQL 데이터베이스에 연결
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        } finally {
            // 리소스 정리
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
        }
    }
}
