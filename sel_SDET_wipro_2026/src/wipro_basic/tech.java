package wipro_basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tech {
public static void main(String[] args)throws InterruptedException {
    WebDriver driver1 = new ChromeDriver();
    driver1.get("https://skill-assist.ai/wipro/auth");
    driver1.manage().window().maximize();
    Thread.sleep(2000);
    driver1.findElement(By.id("signin-email")).sendKeys("ashishchoudharythefuture@gmail.com");
    Thread.sleep(2000);
    driver1.findElement(By.id("signin-password")).sendKeys("Qazwsx@123");
    Thread.sleep(5000);
    WebElement btn = driver1.findElement(
    	    By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div/form/button")
    	);
    Thread.sleep(5000);
    btn.click();
    Thread.sleep(2000);
    System.out.println(driver1.getTitle());
    Thread.sleep(12000);
    driver1.quit();
}
}
