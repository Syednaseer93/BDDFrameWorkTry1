package WaitConcept.WaitConcept;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicatesListbox {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/SYED%20SAMEER/Desktop/SELENIUM%20B45/webpages/webpages/Demo8.html");
		WebElement allselected = driver.findElement(By.id("A1"));
		Select select=new Select(allselected);
		List<WebElement>allChoices=select.getOptions();
		LinkedHashMap<String,Integer>items=new LinkedHashMap<String,Integer>();
		for(WebElement choice:allChoices) {
			String city=choice.getText();
			boolean citypresent =items.containsKey(city);
			if(citypresent) {
				int count=items.get(city);
				count++;
				items.put(city, count);
			}
			else {
				items.put(city,1);
			}
		}
		Set<String> allKeys = items.keySet();
		for(String city:allKeys) {
			int count=items.get(city);
			if(count>1) {
				System.out.println(city);
			}
			else if(count==1) {
				System.out.println(city);
			}
		}
	}
}
