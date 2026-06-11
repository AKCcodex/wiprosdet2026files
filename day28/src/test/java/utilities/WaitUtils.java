package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static WebDriverWait wait;

    public static WebDriverWait getWait(WebDriver driver) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait;
    }
}