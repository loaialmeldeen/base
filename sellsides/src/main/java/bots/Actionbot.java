package bots;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actionbot {
    private WebDriver driver;
    private Waitbot waitbot;

    public Actionbot(WebDriver driver) {
        this.driver = driver;
        this.waitbot = new Waitbot(driver);
    }

    public void click(By locator) {
        waitbot.fluentWait().until(d ->
        {
            try {
                WebElement element = d.findElement(locator);
                //   new Actions(webDriver).scrollToElement(element);
                element.click();
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }

    public void sendKey(By locator, String text) {
        waitbot.fluentWait().until(d ->
        {
            try {
                WebElement element = d.findElement(locator);
                //    new Actions(webDriver).scrollToElement(element);
                element.clear();
                element.sendKeys(text);
                return true;
            } catch (Exception e) {
                return false;
            }
        });

    }


}
