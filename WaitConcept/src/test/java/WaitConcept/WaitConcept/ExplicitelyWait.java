package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitelyWait {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		By elelocator=By.xpath("//h3[text()='Selenium WebDriver']");
		
		waitForElementPresent(driver, elelocator, 10).click();
	}
	
	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeouts)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
		return driver.findElement(locator);
		
	}

}
