package wipro_basic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class basic_launch {
public static void main(String[] args) {

    WebDriver driver = new ChromeDriver();

    driver.get("https://google.com");
    driver.manage().window().maximize();
    System.out.println(driver.getTitle());

    driver.quit();
}
}
