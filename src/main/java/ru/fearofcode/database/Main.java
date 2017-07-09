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
            preparedStatement = connection.prepareStatement(GET_ALL);



            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String title = res.getString("title");
                String desc = res.getString("description");
                float rating = res.getFloat("rating");
                boolean published = res.getBoolean("published");
                Date date = res.getDate("creaated");
                byte[] icon = res.getBytes("icon");

                System.out.println("id: " + id
                        + ", title: " + title
                        + ", description: " + desc
                        + ", rating: " + rating
                        + ", published: " + published
                        + ", create: " + date
                        + ", icon length: " + icon.length
                );
            }



        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
