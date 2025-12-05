package pages;

import bots.Actionbot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fapage {
    //locators
    private final By setuplaterButton = By.id("auth-2fa-setup-form-setup-later");
    //variables
    private WebDriver driver;
    private Actionbot actionbot;

    //constructor
    public Fapage(WebDriver driver) {
        this.driver = driver;
        this.actionbot = new Actionbot(driver);
    }

    public Fapage setupLater() {
        actionbot.click(setuplaterButton);
        return this;
    }

//    public Homepage clickSetupLater() {
//        actionbot.click(setuplaterButton);
//        return new Homepage(driver);
//    }
}
