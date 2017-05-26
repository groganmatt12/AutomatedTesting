	
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

public class LoggedInPage {

	
	
		WebDriver driver;
		By logoLink = By.xpath("//*[@id=\"header_logo\"]/a");
		By logoutButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
		
		public LoggedInPage(WebDriver driver) {
			this.driver = driver;
		}

		public void logout() {
			driver.get(driver.findElement(logoutButton).getAttribute("href"));
		}
		
	}

