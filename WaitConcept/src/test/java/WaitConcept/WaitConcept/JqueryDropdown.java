package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.xpath("//*[@id=\"justAnInputBox\"]\r\n"
				+ "")).click();
		List<WebElement> allelements=driver.findElements(By.xpath("//li//span"));
	//	selectChoice(driver,"all");
		selectChoice(driver,"choice 2 1","choice 2 2","choice 6 2 1");
		//selectChoice(driver,"choice 6 2 3");

		
		}
	public static void selectChoice(WebDriver driver,String ...value)
	{
		List<WebElement> allelements= driver.findElements(By.xpath("//li//span"));
		if(!value[0].equalsIgnoreCase("all"))
		{
			for(WebElement element:allelements) {
				String text=element.getText();
				for(String val:value) {
					if(text.equalsIgnoreCase(val))
					{
						element.click(); 
						break;
					}
				}
			}
		}
		while(value[0].equalsIgnoreCase("all"))
		{
			for(WebElement element:allelements)
			{
				element.click();
				
			}
		}
		


	}

}
