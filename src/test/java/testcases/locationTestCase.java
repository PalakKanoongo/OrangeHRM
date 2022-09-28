package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.LocationPage;
import pages.dashboardPage;
import pages.loginPage;


public class locationTestCase extends baseTest {
	//loginPage objLogin;
	LocationPage objLocation;
	dashboardPage objDashboard;
	@Test(dataProvider="testData")
  public void location(String office, String City, String Phone, String Zip, String Country,String Province) throws InterruptedException {
	    test.log(Status.INFO, "Create Location with "+ City+" , "+Country+" ");
		objDashboard=new dashboardPage(driver);
		objDashboard.searchAndClick();
		
		super.verifyCurrentUrl(prop.getProperty("LocationUrl"));
	 
		objLocation=new LocationPage(driver);
		try {
		objLocation.Details(office,City,Phone,Zip,Country,Province);
		test.log(Status.PASS , "New Office: "+ office+ "added successfully. ");
		}catch(Exception e) {
			test.log(Status.FAIL , "Adding new office FAILED with error : " + e);
            Assert.fail("Adding New office failed");
		}
		
	}	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] { 
			    { "New York111","New York","8464876121","100001","United States","Alaska"},
			    {"Alaska Office","Alaska","8464876121","100001","United States","Alaska"}
				 };
	}
  
  
}
