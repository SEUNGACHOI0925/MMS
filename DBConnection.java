import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/membermanagementsystem?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Success: Connected to MySQL database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

