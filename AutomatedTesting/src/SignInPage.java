import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
	WebDriver driver;
	By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
	By createAnAccountButton = By.xpath("//*[@id=\"SubmitCreate\"]");
	By enterEmailBox = By.id("email");
	By enterPasswordBox = By.id("passwd");
	By signInButton = By.id("SubmitLogin");

	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	public  void enterDetails() {
		WebElement usernameBox = driver.findElement(enterEmailBox);
		usernameBox.sendKeys(Keys.chord("123@hotmail.com"));
		WebElement passwordBox = driver.findElement(enterPasswordBox);
		passwordBox.sendKeys(Keys.chord("123456"));
	}
	public void signIn() {
		driver.findElement(signInButton).click();
	}
	

	
}
