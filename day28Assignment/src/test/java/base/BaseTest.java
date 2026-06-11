package base;

import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void setup() {
        driver.set(DriverFactory.initDriver("chrome"));
    }

    public void tearDown() {
        getDriver().quit();
    }
}