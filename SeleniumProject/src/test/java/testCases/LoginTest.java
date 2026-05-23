package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.findElement(By.id("username"))
              .sendKeys("student");

        driver.findElement(By.id("password"))
              .sendKeys("Password123");

        driver.findElement(By.id("submit"))
              .click();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());

        driver.quit();
    }
}