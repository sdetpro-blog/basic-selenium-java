package com.sdetpro.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {

    public static void main(String[] args) {
        String excelFileName = "TestData.xlsx";
        File excelFileLocation = new File(System.getProperty("user.dir") + "/data/" + excelFileName);

        try {
            FileInputStream fis = new FileInputStream(excelFileLocation);
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet("Sheet_1_name");
            for(Row row : sheet) {
                for(Cell cell : row) {
                    System.out.println(cell);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
