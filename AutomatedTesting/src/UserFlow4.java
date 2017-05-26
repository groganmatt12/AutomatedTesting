import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


	public class UserFlow4 {  //Submit a Complaint//

		/*TestUseCase4 Load homepage: NOTE: an account must already be registered to use this sign-in test//
		1.navigate to contactus page
		2.fill out the details
		3.add a message of complaint
		4.submit
		*/
		
		ExtentReports report;
		ExtentTest test;
	    static WebDriver driver;
		WebElement element;
		Homepage homepage;
		ContactUsPage contactUsPage;
		
		@BeforeClass
		public static void setup()
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\Selenium\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		Boolean result = true;
		Actions builder = new Actions(driver);
		}
		
		@Test
		public void testUseCase4() {
			report = new ExtentReports("C:\\Users\\ewomack\\workspace\\AutomatedTesting\\Userflow4.html", true);
			
			//start the test//
			test = report.startTest("Test logout process");
			//test navigation//
			test.log(LogStatus.INFO, "Navigation Test Started");
			homepage = new Homepage(driver);
			homepage.navigateToContactUsPage();
			contactUsPage = new ContactUsPage(driver);
			Boolean result = true;
			try 
			{
				assertEquals("http://automationpractice.com/index.php?controller=contact", contactUsPage.driver.getCurrentUrl().toString());
			}
			catch(AssertionError e) 
			{
				result = false;
			}
			
			if(result == true)
			{
				test.log(LogStatus.PASS, "Navigation Test successful!");
				assertEquals("1","1");
			}
			else
			{
				test.log(LogStatus.FAIL, "Navigation Test failed!");
				fail();
			}

			
			//test submit query//
			test.log(LogStatus.INFO, "Query submission test started");
			contactUsPage.clickContactUs();
			Boolean result1 = true;
			try 
			{
				assertEquals("http://automationpractice.com/index.php?controller=contact", contactUsPage.driver.getCurrentUrl().toString());
			}
			catch(AssertionError e) 
			{
				result1 = false;
			}
			
			if(result1 == true)
			{
				test.log(LogStatus.PASS, "Query submission test successful!");
				assertEquals("1","1");
			}
			else
			{
				test.log(LogStatus.FAIL, "Query submission Test failed!");
				fail();
			}

			
			//report test final status//
			test.log(LogStatus.PASS, "Contact us and submit a query test successful!");
			report.endTest(test);
			report.flush();
		}


}
