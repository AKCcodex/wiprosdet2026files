package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

features = "src/test/resources/features/hotelSearch.feature",
glue = {"stepdefinitions","hooks"},
plugin = {
        "pretty",
        "html:reports/cucumber-report.html"
},
tags = "@Smoke"

)

public class TestRunner extends AbstractTestNGCucumberTests {

}