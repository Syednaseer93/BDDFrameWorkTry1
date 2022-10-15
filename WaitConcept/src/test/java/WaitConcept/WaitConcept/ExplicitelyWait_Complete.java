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

public class ExplicitelyWait_Complete {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	    By locator=	By.xpath("/html/body/div[7]/div/div[11]/div[2]/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/div/a/h3[@class='LC20lb MBeuO DKV0Md']");
		
	  waitForElement(driver,locator,10).click();
	   

		driver.quit();
	}
	
	public static WebElement waitForElement(WebDriver driver,By locator,int timeouts)
	{
		WebDriverWait mywait =new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	

}
