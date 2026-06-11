package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("user launches browser")
    public void user_launches_browser() throws InterruptedException {

        setup();

        getDriver().get("https://phptravels.net/login");
     
       

        loginPage = new LoginPage(getDriver());
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
    	 loginPage.clickAcknowledge();
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws InterruptedException {

        loginPage.clickLogin();
        Thread.sleep(10000);
    }

    @Then("validate login result")
    public void validate_login_result() {

        String title = getDriver().getTitle();

        System.out.println("Page Title: " + title);

        tearDown();
    }
}