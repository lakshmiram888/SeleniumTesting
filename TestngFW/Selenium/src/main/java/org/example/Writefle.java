package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

public class Readingfile {
    public static void main(String[] args) throws IOException {
        String sourcefile = "C:\\Users\\RamalakshmiRamasubbu\\OneDrive\\Desktop\\sourcefile.txt";
        try (BufferedWriter write = new BufferedWriter(new FileWriter(sourcefile));){
            WebDriver driver = new ChromeDriver();
            driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
            driver.manage().window().maximize();
            String pagesource = driver.getPageSource();
            write.write(pagesource);
        } catch (Exception e) {
            throw new RuntimeException(e);


                    }


        }

    }

FileInputStream input = new FileInputStream("src/main/resources/Inputdata.xlsx");