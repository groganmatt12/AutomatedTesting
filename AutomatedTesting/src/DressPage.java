import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressPage {
	WebDriver driver;
	By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
	By increaseQuantityButton = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]");
	By composeCartButton = By.xpath("//*[@id=\"add_to_cart\"]/button");
	By exitButton = By.linkText("Continue shopping");
	By dressesQuantityBox = By.id("quantity_wanted");
	
	public DressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void increasePurchaseQuantity1()	{
		driver.findElement(increaseQuantityButton).click();
	}
	
	public void composeCart() {
		driver.findElement(composeCartButton).click();
	}
	
	public int getDressesQuantity() {
		int dressesQuantity = Integer.parseInt(driver.findElement(dressesQuantityBox).getAttribute("value"));
		return dressesQuantity;
	}
	public void addToBasket() {
		driver.get(driver.findElement(logoLink).getAttribute("href"));
	}
}
