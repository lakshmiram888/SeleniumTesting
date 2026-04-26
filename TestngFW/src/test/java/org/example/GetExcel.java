package org.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Baseclass {
    public static Map<String, String[]> getLocators(String filePath) throws Exception {
        Map<String, String[]> locators = new HashMap<>();


        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet("Sheet1");

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            String element = row.getCell(0).getStringCellValue();
            String type    = row.getCell(1).getStringCellValue();
            String value   = row.getCell(2).getStringCellValue();

            locators.put(element, new String[]{type, value});
        }

        wb.close();
        fis.close();

        return locators;
    }
}
