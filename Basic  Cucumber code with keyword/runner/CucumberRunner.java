package runner;

import io.cucumber.java.an.Cuan;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/features/Login.feature",
glue="steps",
monochrome=true,
publish=true)
public class CucumberRunner extends AbstractTestNGCucumberTests{
	

}
