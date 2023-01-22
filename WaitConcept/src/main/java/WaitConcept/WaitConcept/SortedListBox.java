package WaitConcept.WaitConcept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortedListBox {
static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("file:///C:/Users/SYED%20SAMEER/Desktop/SELENIUM%20B45/webpages/webpages/Demo7.html");
		WebElement allChoices = driver.findElement(By.id("A2"));
		Select s=new Select(allChoices);
		ArrayList<String>list=new ArrayList<String>();
		
		List<WebElement>lists=s.getOptions();
		for(WebElement l:lists) {
			String choice=l.getText();
			list.add(choice);
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		 
		
		
		
	}

}
