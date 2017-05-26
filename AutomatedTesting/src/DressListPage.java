import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressListPage {
	WebDriver driver;
	By title = By.className("My Store");
	By logoLink = By.className("logo img-responsive");
	By dress1 = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]");
	By dress2 = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]");

	
	public DressListPage(WebDriver driver)
	{
		this.driver = driver; 
	}
	
	public void clickDress1() {
		driver.get(driver.findElement(dress1).getAttribute("href"));
	}
	
	public void clickDress2() {
		driver.get(driver.findElement(dress2).getAttribute("href"));
	}
}
