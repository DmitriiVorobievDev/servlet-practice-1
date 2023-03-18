package com.dvdev.http.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";

//    нужно проинициализировать jdbc-драйвер в статическом блоке
    static {
        loadDriver();
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private ConnectionManager() {
    }

    public static Connection get() {
        try {
//            return DriverManager.getConnection(
//                    PropertiesUtil.get(URL_KEY),
//                    PropertiesUtil.get(URL_KEY),
//                    PropertiesUtil.get(PASSWORD_KEY));
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/flight_repository", "postgres", "1234");
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
