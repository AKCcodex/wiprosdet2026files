package day25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exwait {
public static void main(String[] args) throws InterruptedException {
	 WebDriver driver1 = new ChromeDriver();
	 driver1.get("https://www.saucedemo.com/");
	 driver1.manage().window().maximize();
	 Thread.sleep(2000);

	 
	 driver1.findElement(By.id("user-name")).sendKeys("standard_user");
	 driver1.findElement(By.id("password")).sendKeys("secret_sauce");
	 driver1.findElement(By.id("login-button")).click();


	  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));


      WebElement username = wait.until(
              ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
      username.click();
	 
	 Thread.sleep(1000);

	 
	 driver1.findElement(By.className("shopping_cart_link")).click();
	 Thread.sleep(2000);

	 
	 driver1.findElement(By.id("checkout")).click();
	 Thread.sleep(2000);

	 
	 driver1.findElement(By.id("first-name")).sendKeys("Ashish");
	 driver1.findElement(By.id("last-name")).sendKeys("Choudhary");
	 driver1.findElement(By.id("postal-code")).sendKeys("110001");
	 Thread.sleep(1000);

	 
	 driver1.findElement(By.id("continue")).click();
	 Thread.sleep(2000);

	 
	 driver1.findElement(By.id("finish")).click();
	 Thread.sleep(2000);

	
	 System.out.println("Order placed! Title: " + driver1.getTitle());
	 System.out.println("Confirmation: " + driver1.findElement(By.className("complete-header")).getText());

	 Thread.sleep(3000);
	 driver1.quit();
}
}
