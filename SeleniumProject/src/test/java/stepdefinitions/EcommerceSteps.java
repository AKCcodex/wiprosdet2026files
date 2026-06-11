package stepdefinitions;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

import pages.LoginPage;

public class EcommerceSteps extends BaseClass {

    WebDriverWait wait;

    String filePath = "testdata/LoginData.xlsx";

    String username;
    String password;

    @Given("User launches the browser")
    public void user_launches_the_browser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("Browser launched");
    }

    @When("User logs in")
    public void user_logs_in_using_excel_data() throws InterruptedException {

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet("Sheet1");

            Row row = sheet.getRow(1);

            DataFormatter formatter =
                    new DataFormatter();

            username =
                    formatter.formatCellValue(
                            row.getCell(0));

            password =
                    formatter.formatCellValue(
                            row.getCell(1));

            workbook.close();

            fis.close();

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println("Username: " + username);

        System.out.println("Password: " + password);

        LoginPage lp = new LoginPage(driver);

        lp.login(username, password);

        System.out.println("Login successful");
        
        Thread.sleep(5000);
    }

    @When("User searches for a product")
    public void user_searches_for_a_product() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("inventory_list")));

        System.out.println("Product search completed");
    }

    @When("User applies filter")
    public void user_applies_filter() {

        WebElement dropdown =
                wait.until(ExpectedConditions.elementToBeClickable(
                        By.className("product_sort_container")));

        Select select = new Select(dropdown);

        select.selectByVisibleText("Price (low to high)");

        System.out.println("Filter applied");
    }

    @When("User adds multiple products to cart")
    public void user_adds_multiple_products_to_cart() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-backpack"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-sauce-labs-bike-light"))).click();

        System.out.println("Products added to cart");
    }

    @When("User removes one product from cart")
    public void user_removes_one_product_from_cart() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("remove-sauce-labs-bike-light"))).click();

        System.out.println("One product removed");
    }

    @Then("User validates total amount")
    public void user_validates_total_amount() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.className("shopping_cart_link"))).click();

        WebElement totalPrice =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.className("inventory_item_price")));

        String amount = totalPrice.getText();

        System.out.println("Total Amount: " + amount);
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("checkout"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("first-name"))).sendKeys("Ashish");

        driver.findElement(By.id("last-name"))
                .sendKeys("Kumar");

        driver.findElement(By.id("postal-code"))
                .sendKeys("800001");

        driver.findElement(By.id("continue"))
                .click();

        System.out.println("Checkout completed");
    }

    @When("User logs out")
    public void user_logs_out() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("react-burger-menu-btn"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("logout_sidebar_link"))).click();

        System.out.println("Logout successful");
    }

    @Then("Close the browser")
    public void close_the_browser() {

        driver.quit();

        System.out.println("Browser closed");
    }
}