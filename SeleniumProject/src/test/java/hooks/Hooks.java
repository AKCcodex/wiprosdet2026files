package hooks;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import stepdefinitions.BaseClass;

public class Hooks extends BaseClass {

    @After
    public void takeScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            try {

                File src =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.FILE);

                File dest =
                        new File("screenshots/"
                                + scenario.getName() + ".png");

                FileUtils.copyFile(src, dest);

            }

            catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}