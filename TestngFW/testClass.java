package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class testClass {

    WebDriver driver;
    Properties config = new Properties();
    ExcelReader excel = new ExcelReader("src/main/resources/Inputdata.xlsx");

    public void click(String locator){
                driver.findElement(By.xpath(locator)).click();

    }

    @BeforeSuite
    public void setup() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        config.load(fis);
        driver.manage().window().maximize();
        driver.get(config.getProperty("URL"));
    }

    @AfterSuite

    public void clos() {
        //driver.quit();
        System.out.println("Testing completed");
    }

    @Test

    public void Input() {

        try{

            int rowcount = excel.getRowCount("Sheet1");

             for (int i = 2; i <= rowcount; i++) {

                String uname = excel.getCellData("Sheet1", "Username", i);
                String pword = excel.getCellData("Sheet1", "Password", i);

                driver.findElement(By.xpath(config.getProperty("UName_xpath"))).sendKeys(uname);
                driver.findElement(By.id(config.getProperty("Password_ID"))).sendKeys(pword);
                driver.findElement(By.xpath(config.getProperty("Login"))).click();

            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);

        }
    }

}


