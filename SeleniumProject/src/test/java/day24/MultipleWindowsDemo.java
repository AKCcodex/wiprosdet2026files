package day24;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class MultipleWindowsDemo {
 
	public static void main(String[] args)
	{
 
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		
		String parent=driver.getWindowHandle();   //Handle current window ID
		
		System.out.println("Parent Window ID : " +parent);
		
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> windows=driver.getWindowHandles(); //Gets all window IDs
		
		for(String win: windows)
		{
			driver.switchTo().window(win);
			
			System.out.println("Window ID : " + win);
			
			System.out.println("Title : " + driver.getTitle());
			
			System.out.println("URL : " + driver.getCurrentUrl());
			
			if(!win.equals(parent))
			{
				String text=driver.findElement(By.id("sampleHeading")).getText();
				System.out.println("Child Window Text : " +text);
				driver.close();
			}
			
		}
		driver.switchTo().window(parent);
		System.out.println("Back To Parent Window");
		driver.quit();
		}
	}
 