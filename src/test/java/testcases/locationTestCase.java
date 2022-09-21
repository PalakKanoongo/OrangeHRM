package testcases;

import org.testng.annotations.Test;
import pages.LocationPage;
import pages.dashboardPage;
import pages.loginPage;


public class locationTestCase extends baseTest {
	loginPage objLogin;
	LocationPage objLocation;
	dashboardPage objDashboard;
	@Test
  public void location() throws InterruptedException {
	  
//		objLogin=new loginPage(driver);
//		System.out.println("Opening the browser");
//		objLogin.login("Admin", "XwFwrZ28@Y");
//		Thread.sleep(3000);
		objDashboard=new dashboardPage(driver);
		objDashboard.searchAndClick();
		
		objLocation=new LocationPage(driver);
		objLocation.Details();
	}	
  
  
}
