package day27;



import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRT {

    WebDriver driver;


    @Parameters("browser")

    @BeforeMethod
    public void setup(String browser) throws MalformedURLException {


        if(browser.equalsIgnoreCase("chrome")) {

//            WebDriverManager.chromedriver().setup();
//
//            driver = new ChromeDriver();

                ChromeOptions options =
                        new ChromeOptions();

                driver = new RemoteWebDriver(

                        new URL("http://localhost:4444"),

                        options
                );

                System.out.println(
                        "Chrome browser launched on Grid");
            }

        else if(browser.equalsIgnoreCase("firefox")) {

//            WebDriverManager.firefoxdriver().setup();
//
//            driver = new FirefoxDriver();

        	  FirefoxOptions options =
                      new FirefoxOptions();

              driver = new RemoteWebDriver(

                      new URL("http://localhost:4444"),

                      options
              );

              System.out.println(
                      "Firefox browser launched on Grid");
          }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }


    @Parameters({"username", "password"})

    @Test
    public void loginTest(String username,
                          String password) throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys(username);

        driver.findElement(By.id("password"))
                .sendKeys(password);

        driver.findElement(By.id("login-button"))
                .click();

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(currentURL.contains("inventory"));

        System.out.println("Login successful");
        Thread.sleep(20000);
    }


    @AfterMethod
    public void tearDown() {
    	
        driver.quit();

        System.out.println("Browser closed");
    }
}