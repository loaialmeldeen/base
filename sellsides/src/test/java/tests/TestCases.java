package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCases {
    ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        //options.addArguments("start-maximized");
        WebDriver driver = ThreadGuard.protect(new ChromeDriver(options));
        tdriver.set(driver);
        // tdriver.get().manage().window().maximize();
        tdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        tdriver.get().get("https://dev.emmhub.io/auth");
    }

    @Test
    public void testMethod() {
        tdriver.get().findElement(By.cssSelector("#auth-login-form-email")).sendKeys("loai.saleh@dafagate.com");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-password")).sendKeys("Loai@12345");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-submit")).click();
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-email\"]")).sendKeys("loai.saleh@dafagate.com");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-password\"]")).sendKeys("Loai@12345");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-submit\"]")).click();
    }

    @Test
    public void testMethod2() {

        //  tdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        tdriver.get().findElement(By.cssSelector("#auth-login-form-email")).sendKeys("loai.saleh");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-password")).sendKeys("Loai@12345");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-submit")).click();
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-email\"]")).sendKeys("loai.saleh@dafagate.com");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-password\"]")).sendKeys("Loai@12345");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-submit\"]")).click();
    }

    @Test
    public void testMethod3() {
        // tdriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        tdriver.get().findElement(By.cssSelector("#auth-login-form-email")).sendKeys("loai.saleh@dafagate.com");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-password")).sendKeys("oai@12345");
        tdriver.get().findElement(By.cssSelector("#auth-login-form-submit")).click();
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-email\"]")).sendKeys("loai.saleh@dafagate.com");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-password\"]")).sendKeys("Loai@12345");
//        driver.findElement(By.xpath("//*[@id=\"auth-login-form-submit\"]")).click();
    }

    @AfterMethod
    public void tearDown() {
        tdriver.get().quit();
        tdriver.remove();
    }


}