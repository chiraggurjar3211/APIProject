package TestRunnerNG;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/feature",glue = "stepDefination")
public class TestRunner extends AbstractTestNGCucumberTests{

}
