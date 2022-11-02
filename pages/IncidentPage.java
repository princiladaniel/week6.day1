package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class IncidentPage extends ProjectSpecificMethod {
	
	@And("Get Incident Number")
	public IncidentPage incidentNum() {
		text2 = getDriver().findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		System.out.println("Inident NUmber"+text2);
		return this;
	}
	@And("Enter the shortDescription {string}")
	public IncidentPage shortDescription(String shortDesc) throws IOException {
		try {
			getDriver().findElement(By.id("incident.short_description")).sendKeys(shortDesc);
			 reportStep(" shortDescription enter sucessfully","pass");
		} catch (Exception e) {
			 reportStep(" shortDescription Not enter "+e,"fail");
		}
	    return this;
	}
	@When("Click on submit button")
	public DropPage submitButton() {
		getDriver().findElement(By.xpath("//button[text()='Submit']")).click();
		return new DropPage();
}
}