package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.FluentWait;

public class LoginPage {

    WebDriver driver;

    By acknowledgeBtn =
            By.id("acknowledgeDemoWarning");

    By email =
            By.xpath("//input[@type='email']");

    By password =
            By.xpath("//input[@type='password']");

    By loginBtn =
            By.xpath("//*[@id=\"login-form\"]/div[4]/button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickAcknowledge() {

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        WebElement acknowledge =
                wait.until(driver ->
                        driver.findElement(acknowledgeBtn));

        acknowledge.click();
    }

    public void enterEmail(String user) {

        driver.findElement(email).sendKeys(user);
    }

    public void enterPassword(String pass) {

        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        WebElement login =
                wait.until(driver ->
                        driver.findElement(loginBtn));

        login.click();
    }
}