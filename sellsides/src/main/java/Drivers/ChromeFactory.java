package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstractDriver {

    @Override
    public WebDriver createDriver() {
        // Implementation for creating and returning a Chrome WebDriver instance
        return new ChromeDriver(getOptions()); // Placeholder return statement
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //  options.addArguments("--headless=new");
        //  options.addArguments("--incognito");
        return options;
        // TODO Auto-generated constructor stub
    }
}

