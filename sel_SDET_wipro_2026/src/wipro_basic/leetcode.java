package wipro_basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class leetcode {
public static void main(String[] args)throws InterruptedException  {

    WebDriver driver3 = new ChromeDriver();
    driver3.get("https://leetcode.com/accounts/login/");
    driver3.manage().window().maximize();
    
    driver3.findElement(By.id("id_login"))
    .sendKeys("ashishchoudharythefuture@gmail.com");

    driver3.findElement(By.id("id_password"))
    .sendKeys("'SK!uf8h>qAfvdQ");


driver3.findElement(By.xpath("//button[contains(text(),'Sign In')]"))
    .click();

    Thread.sleep(5000);
    Thread.sleep(2000);
    driver3.findElement(By.id("ap_email_login")).sendKeys("9097826201");

    driver3.findElement(By.id("continue")).click();
    System.out.println(driver3.getTitle());
    driver3.quit();
    
}
}
