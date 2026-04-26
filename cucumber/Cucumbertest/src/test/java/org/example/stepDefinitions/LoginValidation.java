package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginValidation {

    public static WebDriver driver;
    public static Properties config;

    @Given("Launch the edge browser to navigate to url")
    public void launchTheEdgeBrowserToNavigateToUrl() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/Input.properties");
        config = new Properties();
        config.load(fis);

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(config.getProperty("Url"));
    }

    @When("Enter username and password")
    public void enterUsernameAndPassword(){
        driver.findElement(By.xpath(config.getProperty("uname_xpath"))).clear();
        driver.findElement(By.xpath(config.getProperty("uname_xpath"))).sendKeys(config.getProperty("Uname"));

        driver.findElement(By.xpath(config.getProperty("pswd_xpath"))).clear();
        driver.findElement(By.xpath(config.getProperty("pswd_xpath"))).sendKeys(config.getProperty("password"));
    }

    @Then("Click login to homepage")
    public void clickLoginForHomepage() {
        driver.findElement(By.xpath(config.getProperty("login_button"))).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
