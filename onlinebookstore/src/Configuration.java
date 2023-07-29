import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configuration {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/books";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "asd123+1";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Failed to establish a database connection.");
        }
    }
}

