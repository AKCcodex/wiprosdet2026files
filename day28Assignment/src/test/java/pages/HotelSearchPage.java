package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class HotelSearchPage {

    WebDriver driver;

    // ===== LOCATORS =====

    By acknowledgeBtn =
            By.id("acknowledgeDemoWarning");

    By destination =
            By.xpath("//input[@placeholder='Search By City']");

    By destinationOption =
            By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[1]/div[1]/div/div[2]/div[2]/div/div[2]");

    By checkIn =
            By.xpath("//input[@id='checkin']");

    By checkOut =
            By.xpath("//input[@id='checkout']");

    By travellers =
            By.xpath("//a[@data-bs-toggle='dropdown']");

    By adultPlus =
            By.xpath("(//button[contains(text(),'+')])[1]");

    By searchBtn =
            By.xpath("/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[3]/button");

    By hotelsList =
            By.xpath("//div[contains(@class,'hotel-card')]");


    By resultCountText =
            By.xpath("/html/body/div[2]/div/div/div[3]/div/aside/div[2]/div[1]/div/h3/span[2]");

    // ===== CONSTRUCTOR =====

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // ===== FLUENT WAIT =====

    private WebElement waitForElement(By locator, int timeoutSec) {

        FluentWait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(timeoutSec))
                        .pollingEvery(Duration.ofSeconds(2))
                        .ignoring(Exception.class);

        return wait.until(d -> d.findElement(locator));
    }

    // ===== ACTIONS =====

    public void clickAcknowledge() {

        waitForElement(acknowledgeBtn, 20).click();
    }

    public void enterDestination(String city) {

        driver.findElement(destination).sendKeys(city);

        waitForElement(destinationOption, 10).click();
    }

    public void Nationality() {

        driver.findElement(By.xpath(
                "/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[2]/div/div[1]/span[1]"
        )).click();

        driver.findElement(By.xpath(
                "/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[2]/div/div[2]/div[1]/input"
        )).sendKeys("india");

        driver.findElement(By.xpath(
                "/html/body/div[2]/div[3]/div/div/div[1]/div/div/form/div[2]/div[2]/div/div[2]/div[3]"
        )).click();
    }

    public void clickSearch() {

        waitForElement(searchBtn, 10).click();
    }

    // ===== RESULT COUNT FROM TEXT =====

    public int getResultCountFromText() {

        String text = waitForElement(resultCountText, 15).getText();

        System.out.println("Raw Result Text: " + text);

        int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));

        return count;
    }

    // ===== UI HOTEL COUNT =====

    public int getHotelsCount() {

        List<WebElement> hotels =
                driver.findElements(hotelsList);

        return hotels.size();
    }

   
}