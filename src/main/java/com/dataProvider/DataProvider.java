package com.dataProvider;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class DataProvider {


    /*Use this for only properties file*/
    public static Properties read_properties_file(String path) {
        FileInputStream file = null;
        Properties properties = null;

        try {
            file = new FileInputStream(new File(path));
            properties = new Properties();
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    /*only use this to read single row from spreadsheet*/
    public ArrayList<Object> get_data_from_spread_sheets(String path) throws IOException {

        FileInputStream file = null;
        XSSFWorkbook book = null;
        XSSFSheet sheet = null;
        ArrayList<Object> data = new ArrayList<>();


        try {
            file = new FileInputStream(new File(path));
            book = new XSSFWorkbook(file);
            sheet = book.getSheetAt(0);

            //

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //do nothing because we are only getting cell

                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            data.add(cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_STRING:
                            data.add(cell.getStringCellValue());
                            break;

                        default:

                    }

                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file == null) {
                file.close();
            }
        }

        return data;

    }




}
