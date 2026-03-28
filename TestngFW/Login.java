package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;


public class Login{
    static void main() throws IOException {



    WebDriver driver = new ChromeDriver();
       // driver.get("https://adactinhotelapp.com/");
        //driver.manage().window().maximize();
        ExcelReader reader = new ExcelReader("src/main/resources/Inputdata.xlsx");

    try (FileInputStream file = new FileInputStream("src/main/resources/Inputdata.xlsx");
    Workbook  wb = new XSSFWorkbook(file)) {
        String input = "src/main/resources/Inputdata.xlsx";

        Sheet sheet = wb.getSheet("Sheet1");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            String uname = reader.getCellData("Sheet1", 1, 1);
            String pword = reader.getCellData("Sheet1", 2, 2);

            System.out.println(uname);
            System.out.println(pword);

            WebElement user = driver.findElement(By.xpath("//input[@id='username']"));
            user.sendKeys(uname);

            WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
            pass.sendKeys(pword);

            WebElement login = driver.findElement(By.xpath("//input[@id='login']"));
            login.click();

//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//            WebElement alog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Welcome to Adactin Group of Hotels")));
//            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://adactinhotelapp.com/ForgotPassword.php']")));
//
//            String navipage = "https://adactinhotelapp.com/SearchHotel.php";
//            String actpage = driver.getCurrentUrl();

        }


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//        WebElement alog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Welcome to Adactin Group of Hotels")));
//        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='http://adactinhotelapp.com/ForgotPassword.php']")));
//
//        String navipage = "https://adactinhotelapp.com/SearchHotel.php";
//        String actpage = driver.getCurrentUrl();
//
//        driver.close();
//
//        if (navipage.equals(actpage)) {
//           Boolean result = reader.setCellData("Sheet1", "Status", 2,"Pass");
//           WebElement logout = driver.findElement(By.xpath("//a[@href='Logout.php']"));
//           logout.click();
//        }
//        else {
//            Boolean result = reader.setCellData("Sheet1", "Status", 2,"Fail");
//        }
//
//
//    } catch (IOException e) {
//        throw new RuntimeException(e);}
    }

    }
}
