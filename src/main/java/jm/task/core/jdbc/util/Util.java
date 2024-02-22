package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pp11_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public Util() {

    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public SessionFactory getSessionFactory() {
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", URL);
        prop.setProperty("hibernate.connection.username", USERNAME);
        prop.setProperty("hibernate.connection.password", PASSWORD);
        prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "update");

        return new Configuration()
                .addProperties(prop)
                .addAnnotatedClass(jm.task.core.jdbc.model.User.class)
                .buildSessionFactory();
    }
}
