package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HotelSearchPage;

public class HotelSearchSteps {

    WebDriver driver;

    HotelSearchPage hotel;

    @Given("user opens hotel booking website")
    public void user_opens_hotel_booking_website() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://phptravels.net");

        hotel = new HotelSearchPage(driver);

        hotel.clickAcknowledge();
    }

    @When("user enters destination {string}")
    public void user_enters_destination(String city) {

        hotel.enterDestination(city);
    }
    @And("select Nationality")
    public void user_clicks_Nationality() {

        hotel.Nationality();
    }
   
    @And("user clicks on search button")
    public void user_clicks_on_search_button() throws InterruptedException {

        hotel.clickSearch();
        Thread.sleep(90000);
    }



    @And("validate available hotels count")
    public void validate_available_hotels_count() {

        int count = hotel.getHotelsCount();

        System.out.println(
                "Available Hotels Count: " + count);

        Assert.assertTrue(count > 0);

        driver.quit();
    }
}