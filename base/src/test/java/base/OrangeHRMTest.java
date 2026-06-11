package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

public class OrangeHRMTest {

    WebDriver driver;

    // ================= DRIVER SETUP (Grid) =================
    public WebDriver createDriver(String browser) {
        try {
            URL gridUrl = new URL("http://selenium-hub:4444");

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                return new RemoteWebDriver(gridUrl, options);
            }

            if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                return new RemoteWebDriver(gridUrl, options);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // ================= SETUP =================
    @BeforeMethod
    public void setup() {

        driver = createDriver("chrome");

        if (driver == null) {
            throw new RuntimeException("Driver not initialized. Check Grid connection.");
        }

        driver.manage().window().maximize();
    }

    // ================= TEST =================
    @Test
    public void loginTest() {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login Page actions (no separate class)
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Validation
        boolean isDashboard = driver.getCurrentUrl().contains("dashboard");

        Assert.assertTrue(isDashboard, "Login Failed ❌");
    }

    // ================= CLEANUP =================
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}