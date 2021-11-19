package com.database_connection;

import org.testng.annotations.Test;

import java.sql.*;

public class ConfigDataBase {

    private static String url = "localhost:3306/sql_db";
    private static String username = "root";
    private static String pass = "Sarthok69";

    public static Connection configure_database() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_hr", username, pass);
            System.out.println("Connected To DATABASE");
            //Statement statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;

    }


    /*private static Statement create_satement() throws SQLException {
        Statement statement = configure_database().createStatement();
        return statement;
    }

    public static ResultSet execute_queries_and_get_data(String queries) throws SQLException {
        ResultSet set = create_satement().executeQuery(queries);
        return set;
    }*/




}
