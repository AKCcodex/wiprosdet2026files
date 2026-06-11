package day26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
public static void main(String[] args) throws InterruptedException {
	 WebDriver driver1 = new ChromeDriver();
	 driver1.get("https://demo.opencart.com/?utm_source=chatgpt.com");
	 driver1.manage().window().maximize();
	 Thread.sleep(2000);
}
}
