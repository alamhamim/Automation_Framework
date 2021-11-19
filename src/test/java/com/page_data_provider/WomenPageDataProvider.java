package com.page_data_provider;

import com.dataProvider.DataProvider;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class WomenPageDataProvider {


    public static String get_women_page_title() {
        Properties properties = DataProvider.read_properties_file("ssrc/test/resources/Properties_File/women_page_data.properties");
        String title = properties.getProperty("title");
        return title;
    }

    public static ArrayList<Object> get_women_page_product() throws IOException {
        ArrayList<Object> products = DataProvider.get_data_from_spread_sheets("src/test/resources/Properties_File/women_page_data.properties");
        return products;
    }

    public static String get_add_to_cart_data() {
        Properties properties = DataProvider.read_properties_file("src/test/resources/Properties_File/women_page_data.properties");
        String data = properties.getProperty("addToCart");
        return data;
    }

    public static String get_add_to_cart_msg(){
        Properties properties = DataProvider.read_properties_file("src/test/resources/Properties_File/women_page_data.properties");
        String data = properties.getProperty("addToCartMsg");
        return data;
    }

}
