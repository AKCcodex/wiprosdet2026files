package tests;
 
import java.net.URL;
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class LoginTest {
 
    @Test
    public void login() throws Exception {
 
        ChromeOptions options = new ChromeOptions();
 
        WebDriver driver = new RemoteWebDriver(
                new URL("http://host.docker.internal:4444"),
                options);
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
        driver.manage().window().maximize();
 
        driver.get("https://opensource-demo.orangehrmlive.com/");
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("admin123");
 
        driver.findElement(By.xpath("//button[@type='submit']")).click();
 
        Thread.sleep(5000);
 
        System.out.println("Login Successful");
 
        driver.quit();
    }
}