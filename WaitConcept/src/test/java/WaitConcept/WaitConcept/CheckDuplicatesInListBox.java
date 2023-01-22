package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDuplicatesInListBox {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/SYED%20SAMEER/Desktop/SELENIUM%20B45/webpages/Demo8.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> allList = driver.findElements(By.id("A1"));

		LinkedHashMap<String, Integer> items=new LinkedHashMap<String, Integer>();

		for(WebElement listElement:allList) {
			String city=listElement.getText();
			boolean cityPresent=items.containsKey(city);
			if(cityPresent==true) {
				Integer count=items.get(city);
				count++;
				items.put(city, count);
			}
			items.put(city,1);
			
		}

	}

}
