package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DateDecider {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(option);
		driver.get("file:///C:/Users/SYED%20SAMEER/Desktop/SELENIUM%20B45/webpages/Demo5.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> headers = driver.findElements(By.xpath("//th"));
		for(WebElement header:headers) {
			String text=header.getText();
			if(text.equals("Select")) {
				break;
			}
		}
		
	
		driver.findElement(By.xpath("//td[.='API']/..//input")).click();

		
	}

}
