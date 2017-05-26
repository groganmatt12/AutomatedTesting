	
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

public class ContactUsPage {

	
	
		WebDriver driver;
		By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
		By subjectHeadingOptions = By.id("id_contact");
		By emailEnterBox = By.id("email");
		By orderReference = By.id("id_order");
		By enquiryMessage = By.id("message");
		By sendEnquiry = By.id("submitMessage");
		
		public ContactUsPage(WebDriver driver) {
			this.driver = driver;
		}

		public void clickContactUs() {
			driver.findElement(subjectHeadingOptions).click();
			driver.findElement(subjectHeadingOptions).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(subjectHeadingOptions).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(emailEnterBox).sendKeys("1234@hotmail.com");
			driver.findElement(orderReference).sendKeys("1234");
			driver.findElement(enquiryMessage).sendKeys("My item is broken!");
			driver.findElement(sendEnquiry).click();
		}
		
	}

