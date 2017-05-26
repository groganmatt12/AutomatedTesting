import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.BeforeClass;
import org.junit.Test;



public class UserFlow1 {  //Navigate and Purchase Test//

	/*TestUseCase1 Load homepage
	1. Navigate to product page
	2. view multiple products
	3. Load up each product page
	4. Add one product to basket
	5. Proceed to checkout and pay for product
	6. This may require a user account */
	ExtentReports report;
	ExtentTest test;
	static WebDriver driver;
	WebElement element;
	Homepage homepage;
	DressListPage dressListPage;
	DressPage dressPage;
	CheckoutPage checkoutPage;
	SignInBeforeCheckoutPage signInBeforeCheckoutPage;

	@BeforeClass
	public static void setup()
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\Selenium\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com");
	}
	
	@Test
	public void testUseCase1() throws InterruptedException	{
		report = new ExtentReports("C:\\Users\\ewomack\\workspace\\AutomatedTesting\\Userflow1.html", true);
		
		//start the test//
		test = report.startTest("Test navigating between product pages");
		//test navigation//
		test.log(LogStatus.INFO, "Navigation Test Started");
		navigationTest();
		test.log(LogStatus.PASS, "Site navigation, successful!");

		//test adding-to-cart process//
		test.log(LogStatus.INFO, "Add-to-Cart Test Started");
		addToCartTest();
		test.log(LogStatus.PASS, "Add to basket process successful!");
		
		//test checkout process//
		test.log(LogStatus.INFO, "Checkout Test Started");
		checkoutTest();
		test.log(LogStatus.PASS, "Checkout process successful!");
		
		//report test final status//
		test.log(LogStatus.PASS, "Site navigation, add to basket and proceed to checkout successful!");
		report.endTest(test);
		report.flush();
	}
	

	public void navigationTest() {
		homepage = new Homepage(driver);
		homepage.clickDressesLink();
		waitLoadTime();
		assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", driver.getCurrentUrl().toString()); //check page navigated correctly//
		dressListPage = new DressListPage(driver);
		dressListPage.clickDress1();
		waitLoadTime();
		assertEquals("http://automationpractice.com/index.php?id_product=4&controller=product", driver.getCurrentUrl().toString());
		dressListPage.driver.navigate().back();
		waitLoadTime();
		assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", driver.getCurrentUrl().toString());
		dressListPage.clickDress2();
		waitLoadTime();
		assertEquals("http://automationpractice.com/index.php?id_product=3&controller=product", driver.getCurrentUrl().toString());
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
	
	
	public void addToCartTest() throws InterruptedException	{
		dressPage = new DressPage(driver);
		dressPage.increasePurchaseQuantity1();
		dressPage.increasePurchaseQuantity1();
		assertEquals(3, dressPage.getDressesQuantity());
		Thread.sleep(2000);
	}
	
	public void checkoutTest() {
		dressPage.composeCart();
		dressPage.addToBasket();
		homepage.clickCheckout();
		assertEquals("http://automationpractice.com/index.php?controller=order", dressPage.driver.getCurrentUrl().toString());
		checkoutPage = new CheckoutPage(driver);
		assertEquals("http://automationpractice.com/index.php?controller=order", checkoutPage.driver.getCurrentUrl().toString());
		checkoutPage.proceedToCheckout();
		signInBeforeCheckoutPage = new SignInBeforeCheckoutPage(driver);
		assertEquals("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0", signInBeforeCheckoutPage.driver.getCurrentUrl().toString());
	}

}
