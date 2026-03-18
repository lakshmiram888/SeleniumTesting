package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.xml.sax.Locator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;

public class baseTest {
    WebDriver driver;
    Properties confi = new Properties();
   // ExcelReader excel = new ExcelReader("src/test/Resources/testdata.xlsx");

@BeforeSuite
    public void config() throws IOException {
    FileInputStream fis = new FileInputStream("src/test/Resources/Input.properties");
    confi.load(fis);
    driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get(confi.getProperty("URL"));
    System.out.println("Testing started and navigated to the site");
}

@AfterSuite
    public void teardown(){
    driver.quit();
    System.out.println("Testing completed");
}
@Test
public void click(){
    try {


          // driver.findElement(By.xpath("Log_in")).click();
           driver.findElement(By.xpath("Log_in")).click();
           driver.findElement(By.xpath()).
           driver.findElement(By.xpath("//input[@id='Email']")).clear();




    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

}


