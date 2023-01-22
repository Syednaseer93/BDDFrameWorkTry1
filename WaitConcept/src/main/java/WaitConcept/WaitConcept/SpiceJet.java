package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@data-testid='application-id']/div/div/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle']")).click();
		
	/*	if(roundTrip.isSelected()==false) {
			roundTrip.click();
		}*/


	}

}
