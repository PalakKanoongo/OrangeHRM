package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;
import pages.loginPage;

public class baseTest {
	public static WebDriver driver;
	loginPage obj;
	@BeforeClass
	public void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://sanjay29-trials76.orangehrmlive.com/");
		Thread.sleep(5000);
		System.out.println("opened");
		
		obj=new loginPage(driver);
		System.out.println("Opening the browser");
		//System.out.println(info);
		obj.login("Admin", "XwFwrZ28@Y");
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}

}
