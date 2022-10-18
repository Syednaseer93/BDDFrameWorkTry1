package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSugessions {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("selenium");

		// to print all auto suggest list
		List<WebElement> allchoices=driver.findElements(By.xpath("//ul[@role='listbox']//ul[@role='listbox']//li//span"));		
		for(WebElement choice:allchoices) {
			System.out.println(choice.getText());
		}
		//to select a specific element from list
		for(WebElement choice:allchoices) {
			String text=choice.getText();
			if(text.equalsIgnoreCase("selenium rich foods")) {
				choice.click();
			} 
		}
	}
}
