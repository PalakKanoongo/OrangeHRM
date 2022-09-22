package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 


import java.util.List;
import java.util.concurrent.TimeUnit;
public class LocationPage {
  
	WebDriver driver;
	By addBtn= By.xpath("//i[@class=\"material-icons\"][text()=\"add\"]");
	By name= By.cssSelector("#name");
	By city=By.cssSelector("#city");
	By phone=By.cssSelector("#phone");
	By zip=By.cssSelector("#zipCode");
	By country= By.xpath("//ul[@id=\"select-options-844b3be1-6133-f984-6765-7371cc517eca\"]");
	By save= By.xpath("//*[@id=\"locationAddModal\"]/form/div[2]/a[1]");
	public LocationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void Details() throws InterruptedException {
		driver.findElement(addBtn).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(name).sendKeys("Germany Office");
		driver.findElement(city).sendKeys("Berlin");
		driver.findElement(phone).sendKeys("3452341120");
		driver.findElement(zip).sendKeys("001221");
		System.out.println("waiting for country");
		Thread.sleep(4000);
		
		dropDown("Germany");
		Thread.sleep(3000);;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(save).click();
		System.out.println("end");

	}
	
	public void dropDown( String chosen ) {
		List<WebElement> opt = driver.findElements(By.xpath("//ul[@id=\"select-options-844b3be1-6133-f984-6765-7371cc517eca\"]").tagName("li") );
		
		System.out.println(opt.size());
		//List<WebElement> opt = driver.findElements( element);
		System.out.println("entered");
		System.out.println(opt.size());
		driver.findElement(By.xpath("//*[@id=\"countryCode_inputfileddiv\"]/div/input")).click();
	      // Iterating through the list selecting the desired option
	      for( int j = 0; j< opt.size();j++){
	    	  System.out.println(opt.get(j).getText());
	         // if the option is By Subject click that option
	         if( opt.get(j).getText().equals(chosen)){
	            opt.get(j).click();
	            break;
	         }
	      }
	}
}
	


