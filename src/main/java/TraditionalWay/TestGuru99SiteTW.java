package TraditionalWay;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGuru99SiteTW {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() {

		System.out.println("in inti()");
		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver", ".\\server\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", ".\\server\\geckodriver.exe");

		// Instantiate a ChromeDriver class.     
		driver=new ChromeDriver();  
//		driver=new FirefoxDriver();
	}
	
	@Test
	public void testLogin() {
		
		driver.get("https://foservices.icegate.gov.in/#/services/viewExchangeRate");
	}

}
