package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class LoginPage extends ProjectSpecificMethod{
//  Create your own credentials
	
	@When("Enter Username as {string}")
	public LoginPage userName(String uname) throws IOException {
	try {
		getDriver().findElement(By.id("user_name")).sendKeys(uname);
		 reportStep("username enter sucessfully","pass");
	} catch (Exception e) {
		 reportStep("username not entered"+e,"fail");
	}
	return this;
	}
	@And("Enter Password as {string}")
	public LoginPage passWord(String pword) throws IOException {
		try {
			getDriver().findElement(By.id("user_password")).sendKeys(pword);
			reportStep("password enter sucessfully","pass");
		} catch (Exception e) {
			reportStep("password not entered"+e,"fail");
		}
	return this;
	}
	@When("Click on Login button")
	public CreateIncident logIn() throws IOException {
		try {
			getDriver().findElement(By.id("sysverb_login")).click();
			reportStep("Login button clicked sucessfully","pass");
		} catch (Exception e) {
			reportStep("Login button not click"+e,"fail");
		}
	return new CreateIncident();
	}
}
