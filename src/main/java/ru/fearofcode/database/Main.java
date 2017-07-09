package ru.fearofcode.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

/**
 * Created by Max on 7/8/2017.
 */
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?);";
    private static final String GET_ALL = "SELECT * FROM dish;";


    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3, "Inserted dest");
            preparedStatement.setFloat(4, 0.0f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("smile.png"));

            preparedStatement.execute();




        } catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
