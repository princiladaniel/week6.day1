package runner;

import org.testng.annotations.BeforeTest;

import base.ProjectSpecificMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/java/features/CreateIncident1.feature",
glue="pages",
monochrome=true,
publish=true)
public class ServiceNowRunner extends ProjectSpecificMethod  {

	@BeforeTest
	public void setFile() {
		
		testName="Create New Incident";
		testDescription="ServiceNow Application";
		testCategory="smoke";
		testAuthor="Princila";	
		
	}
	
}
