package WaitConcept.WaitConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jquery {
	static WebDriver driver;

	public static void selectChoicesFromList(WebDriver driver,String ...values) {

		List<WebElement> allChoices = driver.findElements(By.xpath("//li//span"));
		if(!values[0].equalsIgnoreCase("all")) 
		{
			for(WebElement choice:allChoices) 
			{
				String text=choice.getText();
				for(String val:values) {
					if(text.equalsIgnoreCase(val)) {
						choice.click();
						break;
					}
				}
			}	

		}
		else 
		{

			for(WebElement choice:allChoices) {
				choice.click();
			
			}
		}

	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();
		
		//selectChoicesFromList(driver,"choice 2 2","choice 2 3","choice 6 2 1");
		selectChoicesFromList(driver,"ALL");


	}
}
