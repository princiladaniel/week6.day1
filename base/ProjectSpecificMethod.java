package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import util.ReadExcel;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests{
private static final ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver(RemoteWebDriver driver) {
		tlDriver.set(driver);
	}
	
	public RemoteWebDriver getDriver() {
		return tlDriver.get();
	}
	
	public  RemoteWebDriver driver;
	public  static Shadow shadow;
	public static String text2;
	public String filename;
	public static ExtentReports extent;
	public  static ExtentTest test,node;
	public  String testName,testDescription,testCategory,testAuthor;
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
	    extent=new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@AfterSuite
	public void stopReport() {
		 extent.flush();
	        
	}
	@BeforeClass
	public void setTestDetail() {
	    test = extent.createTest(testName,testDescription);//ctrl+2+l
        test.assignCategory(testCategory);
        test.assignAuthor(testAuthor);
	}
	public int takeSnap() throws IOException {
		int ranNum=(int)(Math.random()*999999+1000000);//111435
		File source = getDriver().getScreenshotAs(OutputType.FILE);
		File target=new File("./snaps/img"+ranNum+".png");//img11234.png
		FileUtils.copyFile(source, target);
		return ranNum;
	}
		
	public void reportStep(String stepDesc,String status) throws IOException {
	if(status.equalsIgnoreCase("pass")) {
		node.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		
	}
	else if(status.equalsIgnoreCase("fail")) {
		node.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		throw new RuntimeException("Please look your report for failure");	
	}		
	}
	
	@DataProvider(name="fetchData")
	public String[][] testData() throws IOException {
		String[][] readData = ReadExcel.readData(filename);
		return readData;
	}
	@BeforeMethod
	public  void preCondition() {
  node = test.createNode(testName);
	WebDriverManager.chromedriver().setup();
	setDriver(new ChromeDriver()) ;
	shadow = new Shadow(getDriver());
	getDriver().get("https://dev141581.service-now.com"); 
	getDriver().manage().window().maximize();
	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	 
	}
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
}
