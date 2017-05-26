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

public class UserFlow3 {			//Logout Test//

	/*TestUseCase3 Load homepage:/
	1. Navigate to signin page
	2. login
	4. logout
	*/
	ExtentReports report;
	ExtentTest test;
	static WebDriver driver;
	WebElement element;
	Homepage homepage;
	SignInPage signInPage;
	LoggedInPage loggedInPage;
	
	@BeforeClass
	public static void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\Selenium\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com");

	}
	
	@Test
	public void testUseCase3() {
		report = new ExtentReports("C:\\Users\\ewomack\\workspace\\AutomatedTesting\\Userflow3.html", true);
		
		//start the test//
		test = report.startTest("Test logout process");
		//test navigation//
		test.log(LogStatus.INFO, "Navigation Test Started");
		homepage = new Homepage(driver);
		homepage.navigateToSignInPage();
		signInPage = new SignInPage(driver);
		test.log(LogStatus.PASS, "Navigation Test successful!");
		Boolean result = true;
		try 
		{
			assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl().toString());
		}
		catch(AssertionError e) 
		{
			result = false;
		}
		
		if(result == true)
		{
			test.log(LogStatus.PASS, "Navigation test successful!");
			assertEquals("1","1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Navigation Test failed!");
			fail();
		}

		//signin test//
		test.log(LogStatus.INFO, "Signin Test Started");
		signInPage.enterDetails();
		signInPage.signIn();
		assertEquals("http://automationpractice.com/index.php?controller=my-account", signInPage.driver.getCurrentUrl().toString());
		test.log(LogStatus.PASS, "Signin Test successful!");

		
		//signout test//
		test.log(LogStatus.INFO, "Signout Test Started!");
		loggedInPage = new LoggedInPage(driver);
		loggedInPage.logout();
		test.log(LogStatus.PASS, "Signout Test successful!");
		
		//report test final status//
		test.log(LogStatus.PASS, "Site signin and signout test successful!");
		report.endTest(test);
		report.flush();

	}

	public void waitLoadTime()	{
		try
		{
			WebElement myWaitTime = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='columns']/div[1]")));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
