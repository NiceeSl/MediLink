package com.example.medilink;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5436/postgres";
    private static final String USER = "slavik";
    private static final String PASSWORD = "64ubamed";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Успешное подключение к базе данных.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка подключения к базе данных.", e);
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    System.out.println("Соединение с базой данных закрыто.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка при закрытии подключения к базе данных.", e);
            }
        }
    }
}
