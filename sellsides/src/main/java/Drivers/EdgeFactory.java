package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstractDriver {
    @Override
    public WebDriver createDriver() {
        // Implementation for creating and returning a Chrome WebDriver instance
        return new EdgeDriver(getOptions()); // Placeholder return statement
    }

    private EdgeOptions getOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--headless=new");
        //options.addArguments("--incognito");
        return options;
    }
}
