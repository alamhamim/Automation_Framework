package com.page_data_provider;

import com.dataProvider.DataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class HomePageDataProvider {

    public static ArrayList<Object> get_home_page_product() throws IOException {
        ArrayList<Object> homePageData = DataProvider.get_data_from_spread_sheets("src/test/resources/Spread_Sheets/all_product_homepage.xlsx");
        return homePageData;

    }

    public static ArrayList<Object> get_home_page_header_data() throws IOException {
        ArrayList<Object> homePageHeade = DataProvider.get_data_from_spread_sheets("src/test/resources/Spread_Sheets/home_page_header.xlsx");
        return homePageHeade;
    }

    public static String get_home_page_title() {
       Properties properties = DataProvider.read_properties_file("src/test/resources/Properties_File/home_page_data.properties");
        String title = properties.getProperty("title");
        return title;
    }



}
