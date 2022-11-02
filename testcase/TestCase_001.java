package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import io.github.sukgu.Shadow;
import pages.CreateIncident;
import pages.LoginPage;

public class TestCase_001 extends ProjectSpecificMethod{
	@BeforeTest
	public void setFile() {
		filename="CreateIncident";
		testName="Create New Incident";
		testDescription="ServiceNow Application";
		testCategory="smoke";
		testAuthor="Princila";	
		
	}
	@Test(dataProvider="fetchData")
	public  void runCreateIncent(String uname,String pword,String shortDes,String number) throws IOException {
		LoginPage lp=new LoginPage();
			
		lp.userName(uname).passWord(pword).logIn().allPage().clickIncident()
		.newbutton().incidentNum()
		.shortDescription(shortDes).submitButton().dropNumber(number).textValue().verifyIncident();		
		
		
	}

}
