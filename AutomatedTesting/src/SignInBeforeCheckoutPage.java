import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInBeforeCheckoutPage {
	WebDriver driver;
	By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
	
	public SignInBeforeCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
}
