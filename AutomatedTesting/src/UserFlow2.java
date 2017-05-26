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

public class UserFlow2 {  //Login Test//

	/*TestUseCase2 Load homepage: NOTE: an account must already be registered to use this sign-in test//
	1. Navigate to signin page
	2. enter signin details
	4. sign in and check for success
	*/
	ExtentReports report;
	ExtentTest test;
	static WebDriver driver;
	WebElement element;
	Homepage homepage;
	SignInPage signInPage;
	
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
	public void testUseCase2() {
		report = new ExtentReports("C:\\Users\\ewomack\\workspace\\AutomatedTesting\\Userflow2.html", true);
		
		//start the test//
		test = report.startTest("Test navigating to signin page");
		//test navigation//
		test.log(LogStatus.INFO, "Navigation Test Started");
		homepage = new Homepage(driver);
		homepage.navigateToSignInPage();
		assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", driver.getCurrentUrl().toString());
		test.log(LogStatus.PASS, "Navigation Test successful!");
		
		//test signin process//
		test.log(LogStatus.INFO, "Signin Test Started");
		signInPage = new SignInPage(driver);
		signInPage.enterDetails();
		signInPage.signIn();
		assertEquals("http://automationpractice.com/index.php?controller=my-account", signInPage.driver.getCurrentUrl().toString());
		test.log(LogStatus.PASS, "Signin Test successful!");
		
		//report test final status//
		test.log(LogStatus.PASS, "Site navigation and signin test successful!");
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
