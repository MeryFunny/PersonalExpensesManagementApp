package com.mariazgoba.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties properties = new Properties();
                properties.load(new FileInputStream("src/database.properties"));

                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
