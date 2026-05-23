package day24;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
 
 
public class Alert {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(6000);
	    org.openqa.selenium.Alert alert1 = driver.switchTo().alert();
	    alert1.accept();
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(6000);
		 org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
		 alert2.accept();
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(6000);
		 org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
		 alert3.dismiss();
		
		
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(6000);
		 org.openqa.selenium.Alert alert4= driver.switchTo().alert();
		 alert4.sendKeys(" vasudha ");
		 alert4.accept();
		
	       
		
		
		
		
	}
 
}
 