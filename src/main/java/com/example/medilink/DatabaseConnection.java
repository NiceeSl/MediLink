package com.example.medilink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5434/template1";
    private static final String USER = "slavik";
    private static final String PASSWORD = "64ubamed";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Успешное подключение к базе данных.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка подключения к базе данных.", e);
            }
        }
        return connection;
    }
}