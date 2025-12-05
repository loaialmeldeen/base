package bots;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.ArrayList;

public class Waitbot {
    private WebDriver driver;

    public Waitbot(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(600))
                .pollingEvery(java.time.Duration.ofMillis(10))
                //.ignoring(Exception.class);
                .ignoreAll(getExceptions());
    }

    private ArrayList<Class<? extends Exception>> getExceptions() {
        ArrayList<Class<? extends Exception>> exceptions = new ArrayList<>();
        exceptions.add(NoSuchElementException.class);
        exceptions.add(StaleElementReferenceException.class);
        exceptions.add(ElementClickInterceptedException.class);
        exceptions.add(ElementNotInteractableException.class);
        return exceptions;
    }
}