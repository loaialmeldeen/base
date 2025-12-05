package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {
    private final static String browser = System.getProperty("browserType");
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static WebDriver getDriver() {

        Browsers browserType = Browsers.valueOf(browser.toUpperCase());
        //      Browsers browserType = Browsers.valueOf(browser);
        AbstractDriver abstractDriver = browserType.getDriverfactory();
        return abstractDriver.createDriver();
    }

    public static WebDriver initDriver() {
        WebDriver driver = ThreadGuard.protect(getDriver());
        driverThreadLocal.set(driver);
        return WebDriverFactory.driverThreadLocal.get();
    }

    public static WebDriver getCurrentDriver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }


}