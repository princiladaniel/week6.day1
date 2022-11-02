package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.When;
import io.github.sukgu.Shadow;

public class Newbutton extends ProjectSpecificMethod {
	
	@When("Click on new button")
	public IncidentPage  newbutton() throws IOException {
		
		WebElement eleFrame= shadow.findElementByXPath(("//iframe[@title='Main Content']"));
		getDriver().switchTo().frame(eleFrame);
		System.out.println(getDriver().getTitle());
		WebElement newClick = getDriver().findElement(By.xpath("//button[text()='New']"));
		try {
			getDriver().findElement(By.id("sysverb_new")).click();
			 reportStep("new button clicked","pass");
		} catch (Exception e) {
			 reportStep("new button not clicked"+e,"fail");
		}
		 //driver.executeScript("arguments[0].click();", newClick);
		
		return new IncidentPage();
		
}
}
