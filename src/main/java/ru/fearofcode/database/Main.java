package ru.fearofcode.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Max on 7/8/2017.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e){
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            statement.addBatch("INSERT INTO animal(name, dest) VALUE('batch1','dest');");
            statement.addBatch("INSERT INTO animal(name, dest) VALUE('batch2','dest');");
            statement.addBatch("INSERT INTO animal(name, dest) VALUE('batch3','dest');");

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
