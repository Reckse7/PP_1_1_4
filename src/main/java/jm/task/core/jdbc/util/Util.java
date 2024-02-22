package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pp11_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private final Connection connection;
    public Util() throws SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public Connection getConnection() {
        return connection;
    }
}
