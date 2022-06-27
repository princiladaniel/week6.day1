package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	public ChromeDriver driver;
	@Given ("Launch the browser")
	public void loadTheBrowser() {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();	
	}
	@And ("Load the {string}")
	public void includeTheURL(String url) {
		driver.get(url);
	}
	@And ("maximize the browser")
	public void maxBrowser() {
		driver.manage().window().maximize();
	}
	@And("Enter the username as {string}")
	public void enterUsername(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}
	@And("Enter the password as {string}")
	public void enterPassword(String pword) {
		driver.findElement(By.id("password")).sendKeys(pword);	
	}
	@When ("click the login button")
	public void loginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@Then ("open home screen")
	public void verifyHomePage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if(displayed) {
			System.out.println("Home Page loaded successfully");
		}
		else {
			 System.out.println("Page Not Loaded");
		}
		
			
		
		
	}
}


