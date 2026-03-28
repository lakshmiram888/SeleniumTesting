package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;


public class DDlogin {
   public static void main(String[] args) throws IOException {

        ExcelReader reader = new ExcelReader("src/main/resources/Inputdata.xlsx");

        try {
            int rowcount = reader.getRowCount("Sheet1");

            WebDriver driver = null;
            for (int i = 2; i <= rowcount; i++) {

                String uname = reader.getCellData("Sheet1", "Username", i);
                String pword = reader.getCellData("Sheet1", "Password", i);

                driver = new EdgeDriver();
                driver.manage().window().maximize();

                driver.get("https://demowebshop.tricentis.com/login");

                JavascriptExecutor js = (JavascriptExecutor) driver;
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Email']")));
                js.executeScript("arguments[0].scrollIntoView(true);", user);
                user.clear();
                user.sendKeys(uname);


                WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Password']")));
                pass.clear();
                pass.sendKeys(pword);


                WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='button-1 login-button']")));
                js.executeScript("arguments[0].scrollIntoView(true);", login);
                login.click();

                String op = "https://demowebshop.tricentis.com/";



                if (op.equals( driver.getCurrentUrl())) {

                    reader.setCellData("Sheet1", "Status", i, "Pass");
                    driver.quit();

                } else {


                    reader.setCellData("Sheet1", "Status", i, "Fail");
                    driver.quit();

                }
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }



    }}