package utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String name) {

        try {

            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File("./reports/" + name + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}