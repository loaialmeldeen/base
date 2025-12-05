package pages;

import bots.Actionbot;
import bots.Waitbot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
    //variables
    private WebDriver driver;
    private Actionbot actionbot;

    //constructor
    public Homepage(WebDriver driver) {
        this.driver = driver;
        this.actionbot = new Actionbot(driver);
    }

    public Homepage verifyLoginSuccess(String expectedUrl) {
        new Waitbot(driver).fluentWait().until(d -> d.getCurrentUrl().equals(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "https://dev.emmhub.io/spot");
        return new Homepage(driver);
    }
//
//    public String getHomePageUrl() {
//        return driver.getCurrentUrl();
//    }
}
