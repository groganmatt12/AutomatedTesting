import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;
	By finalCheckoutButton = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	
	public CheckoutPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void proceedToCheckout() {
		driver.get(driver.findElement(finalCheckoutButton).getAttribute("href"));
	}
}
