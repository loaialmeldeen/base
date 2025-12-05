package pages;

import bots.Actionbot;
import bots.Waitbot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Loginpage {

    //locators
    private final By emailField = By.id("auth-login-form-email");
    private final By passField = By.id("auth-login-form-password");
    private final By loginButton = By.id("auth-login-form-submit");
    private final By setuplaterButton = By.id("auth-2fa-setup-form-setup-later");

    //variables
    private WebDriver driver;
    private Actionbot actionbot;

    //constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        this.actionbot = new Actionbot(driver);
    }

    //Actions
    public Loginpage enterEmail(String email, String password) {
        actionbot.sendKey(emailField, email);
        actionbot.sendKey(passField, password);
        actionbot.click(loginButton);
        actionbot.click(setuplaterButton);
        return this;
    }


    public Homepage verifyLoginSuccess(String expectedUrl) throws InterruptedException {

        new Waitbot(driver).fluentWait();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new Homepage(driver);
    }

}
