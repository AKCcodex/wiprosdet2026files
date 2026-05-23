package wipro_basic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
public class spotyfi {
public static void main(String[] args) throws InterruptedException{
	  WebDriver driver1 = new ChromeDriver();
    driver1.get("https://accounts.spotify.com/en/login?login_hint=ashishchoudharyieee%40gmail.com&continue=https%3A%2F%2Fopen.spotify.com%2Fsearch%2Fopen%2520gungal%2520style%3Fflow_ctx%3D91f60dea-8538-429b-a34a-f649250040e4%253A1778948299&flow_ctx=91f60dea-8538-429b-a34a-f649250040e4&allow_password=1");
    driver1.manage().window().maximize();
    
    Thread.sleep(2000);
    driver1.findElement(By.id("password")).sendKeys("?e@i^!!Z8C$h;K2");
   
//    driver1.findElement(By.id("login-button")).click();
    WebElement loginBtn = driver1.findElement(
    	    By.cssSelector("[data-testid='login-button']")
    	);
    	((JavascriptExecutor) driver1).executeScript("arguments[0].click();", loginBtn);
    	
//    	Thread.sleep(28000);

    	driver1.findElement(By.tagName("body")).sendKeys(Keys.SPACE);
    	 Thread.sleep(13000);
    	 
    	 driver1.findElement(By.tagName("body")).sendKeys(Keys.SPACE);
    
    	 
}
}
