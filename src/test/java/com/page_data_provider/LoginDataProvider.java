package com.page_data_provider;


import com.dataProvider.DataProvider;
import com.database_connection.ConfigDataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

public class LoginDataProvider {

    public static HashMap<String, String> get_user_name() throws SQLException {

        HashMap<String, String> data = new HashMap<>();
        Connection connection = ConfigDataBase.configure_database();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM employees");
        while (set.next()) {
            data.put(set.getString("first_name"), set.getString("last_name"));
            break;
        }
        return data;
    }

    public static String get_login_page_title() {
        Properties properties = DataProvider.read_properties_file("src/test/resources/Properties_File/login_page_data.properties");
        String title = properties.getProperty("title");
        return title;
    }

}
