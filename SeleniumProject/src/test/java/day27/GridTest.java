package day27;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {

    static WebDriver driver;

    public static void main(String[] args)
            throws Exception {

        String browser = "chrome";


        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            driver = new RemoteWebDriver(

                new URL("http://localhost:4444"),

                options
            );
        }


        else if(browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options =
                    new FirefoxOptions();

            driver = new RemoteWebDriver(

                new URL("http://localhost:4444"),

                options
            );
        }


        driver.get("https://www.saucedemo.com/");

     
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Test Executed");

        driver.quit();
    }
}