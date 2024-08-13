package TraditionalWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ViewExchangeRate {

	 
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
	public void testLogin() throws InterruptedException {
		//Launch view exchange site
		driver.get("https://foservices.icegate.gov.in/#/services/viewExchangeRate");

		//select Currency Code dropdown
		driver.findElement(By.xpath("//mat-select[@formcontrolname='currencyCode']")).click();
		Thread.sleep(1000);

		//select dropdown option as 'ALL'
		WebElement currencyCodeOption =  driver.findElement(By.xpath("//mat-option/span[@class='mat-option-text' and text()='ALL']"));
		currencyCodeOption.click();

		//Waiting 30 seconds for entering CAPCHA 
		Thread.sleep(30 * 1000);

		//Click on button 'View Currency Exchange Rate'
		driver.findElement(By.xpath("//button[contains(text(), 'View Currency Exchange Rate')]")).click();
		Thread.sleep(3000);

		//get import rate
		String importRateStr = getImportRate("USD");
		System.out.println("Import Rate for USD : "+ importRateStr);

		//get export rate
		String exportRateStr = getExportRate("USD");
		System.out.println("Export Rate for USD : "+ exportRateStr);


	}

	public String getImportRate(String currencyCode) {
		WebElement importRate =  driver.findElement(By.xpath("//table[@class='resultTable table']//tr[contains(., '"+currencyCode+"')]/td[5]"));
		String importRateStr = importRate.getText().trim();
		return importRateStr;
	}

	public String getExportRate(String currencyCode) {
		WebElement importRate =  driver.findElement(By.xpath("//table[@class='resultTable table']//tr[contains(., '"+currencyCode+"')]/td[6]"));
		String importRateStr = importRate.getText().trim();
		return importRateStr;
	}
}
