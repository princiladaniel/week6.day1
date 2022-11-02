package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.ProjectSpecificMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.sukgu.Shadow;

public class DropPage extends ProjectSpecificMethod {

	@And("choose {string} from dropDown")
	public DropPage dropNumber(String number) {
		getDriver().switchTo().defaultContent();

		WebElement eleFrame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		getDriver().switchTo().frame(eleFrame2);
		WebElement numberDropDown = getDriver().findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select numberDD=new Select(numberDropDown);
		numberDD.selectByVisibleText(number);
		return this;
	}
	@And ("Get New Incident Number")
		public DropPage textValue() {	
		getDriver().findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys(text2,Keys.ENTER);
		getDriver().switchTo().defaultContent();
		return this;
		}
		//// Confirm incident exists !
	@Then("verify Incident created")
		public DropPage  verifyIncident() {
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		getDriver().switchTo().frame(frame);
		String text = getDriver().findElement(By.xpath("//a[text()='Number']/following::a[@class='linked formlink']")).getText();
		System.out.println(text); 
		assertEquals(text, text2);
		System.out.println("Incident existing");
		return this;
}
}
