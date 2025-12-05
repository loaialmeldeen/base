package tests.webportal.login;

import Drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Loginpage;
import utils.JsonReader;

import static utils.PropertyReader.getProperty;

public class LoginTest {
    //variables
    WebDriver driver;
    JsonReader jsonReader;


    //constructor
    @Test
    @Description("test")
    @Tag("TEST")
    @Owner("")
    @Severity(SeverityLevel.CRITICAL)
    @Link("")
    @TmsLink("")
    @Issue("")
    public void validLogin() throws InterruptedException {
        new Loginpage(driver)
                //PROPERTY
                .enterEmail(getProperty("clientEmail"), getProperty("clientPassword"));
        //JSON
        //.enterEmail(jsonReader.getJsonData("clientEmail"), jsonReader.getJsonData("clientPassword"))
        //  .verifyLoginSuccess("https://dev.emmhub.io/spot");
    }

    @Test
    @Epic("")
    @Feature("")
    @Story("")
    public void INvalidLogin() throws InterruptedException {
        new Loginpage(driver)
                //PROPERTY
                .enterEmail(getProperty("clientEmail"), getProperty("clientPassword"))
                //JSON
                //.enterEmail(jsonReader.getJsonData("clientEmail"), jsonReader.getJsonData("clientPassword"))
                .verifyLoginSuccess("https://dev.emmhub.io/spot");
    }

    //configurations
    @BeforeMethod
    public void setup() {
        jsonReader = new JsonReader("data");

        driver = WebDriverFactory.initDriver();
        driver.get(getProperty("baseURL"));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }
}