package MyBudget;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static final String DBUSER = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mybudget";

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, DBUSER, PASSWORD);
    }

}
