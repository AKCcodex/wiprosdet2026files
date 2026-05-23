package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parabanksignup {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver1 = new ChromeDriver();
	 driver1.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=7D91048E9BB4780892AA0E66DAB71545");
	 driver1.manage().window().maximize();
	 Thread.sleep(2000);
	 
		 driver1.get("https://parabank.parasoft.com/parabank/register.htm");
	 driver1.findElement(By.id("customer.firstName")).sendKeys("Ashish");
	 driver1.findElement(By.id("customer.lastName")).sendKeys("Choudhary");
	 driver1.findElement(By.id("customer.address.street")).sendKeys("dilchand");
	 driver1.findElement(By.id("customer.address.city")).sendKeys("danapur");
	 driver1.findElement(By.id("customer.address.state")).sendKeys("bihar");
	 driver1.findElement(By.id("customer.address.zipCode")).sendKeys("801503");
	 driver1.findElement(By.id("customer.phoneNumber")).sendKeys("9097826201");
	 driver1.findElement(By.id("customer.ssn")).sendKeys("745812asd");
	 driver1.findElement(By.id("customer.username")).sendKeys("Ashish12345");
	 driver1.findElement(By.id("customer.password")).sendKeys("Qazwsx@123");
	 driver1.findElement(By.id("repeatedPassword")).sendKeys("Qazwsx@123");
	 
	 driver1.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[13]/td[2]/input")).click();
	 Thread.sleep(2000);
}
}
