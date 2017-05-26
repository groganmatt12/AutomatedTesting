import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
	WebDriver driver;
	By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
	By dressesLink = By.linkText("DRESSES");
	By proceedToCheckoutButton = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
	By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
	By createAnAccountButton = By.xpath("//*[@id=\"SubmitCreate\"]");
	By contactUsPageButton = By.xpath("//*[@id=\"contact-link\"]/a");
	

	public Homepage(WebDriver driver)
	{
		this.driver = driver; 
	}
	
	public void clickLogoLink() {
		driver.get(driver.findElement(logoLink).getAttribute("href"));
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickDressesLink()
	{
		driver.get(driver.findElement(dressesLink).getAttribute("href"));
	}
	 
	public void clickCheckout()
	{
		driver.findElement(proceedToCheckoutButton).click();
	}
	
	public void navigateToSignInPage() {
		driver.get(driver.findElement(signInButton).getAttribute("href"));
	}
	public void createAnAccount() {
		driver.get(driver.findElement(createAnAccountButton).getAttribute("href"));
	}
	public void navigateToContactUsPage() {
		driver.get(driver.findElement(contactUsPageButton).getAttribute("href"));
	}
}
