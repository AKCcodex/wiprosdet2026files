package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import base.BaseTest;
import utilities.ScreenshotUtils;

public class Hooks extends BaseTest {

    @After
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {

            ScreenshotUtils.captureScreenshot(
                    getDriver(),
                    scenario.getName());
        }

        getDriver().quit();
    }
}