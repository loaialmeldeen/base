package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory extends AbstractDriver {
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver(getOptions());
        // Implementation for creating Firefox WebDriver
    }

    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //    options.addArguments("--headless=new");
        //options.addArguments("--incognito");
        return options;
    }
}
