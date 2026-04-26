package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FrameworkLogin {
    static void main() {

        try (FileInputStream fis = new FileInputStream("src/main/resources/Inputdata.xlsx");
             Workbook wb = new XSSFWorkbook("src/main/resources/Inputdata.xlsx")) {
            Sheet sheet = wb.getSheet("Sheet1");
            //Row row = sheet.getRow(int ,Object i;i);
            //int rowcount = row.getRowNum();
            //System.out.println(rowcount);
            //https://demowebshop.tricentis.com/


        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}
