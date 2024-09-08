package com.example.task_manager_app;

import java.sql.Connection;
import java.sql.SQLException;


public class TestConnection {

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer conexão.");
            }
        } catch (SQLException e) {
        }
    }
}
