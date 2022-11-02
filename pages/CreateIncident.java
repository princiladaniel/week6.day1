package pages;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.Given;
import io.github.sukgu.Shadow;

public class CreateIncident extends ProjectSpecificMethod{


	@Given("Click on All")
	public  CreateIncident allPage() throws IOException {
		shadow.setImplicitWait(20);
		try {
			shadow.findElementByXPath("//div[@id='all']").click();
			 reportStep("All click sucessfully","pass");
		} catch (Exception e) {
			 reportStep("All click unsucessfully"+e,"fail");
		}
		return this;
}
	@Given("Click Incidents in Filter navigator")
public Newbutton clickIncident() throws IOException {
		//4.Click  Incidents in Filter navigator
		try {
			shadow.findElementByXPath("//span[text()='Incidents']").click();
			 reportStep("incident click sucessfully","pass");
		} catch (Exception e) {
			reportStep("incident click unsucessfully"+e,"fail");
		}
		System.out.println(getDriver().getTitle());
		return new Newbutton();
}
	
}
