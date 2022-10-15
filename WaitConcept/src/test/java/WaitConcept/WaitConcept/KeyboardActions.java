package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		
	WebElement input1=driver.findElement(By.xpath("//textarea[@id='inputText1']"));
	WebElement input2=driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		Actions act=new Actions(driver);
		input1.sendKeys("Naseer");
		//control+A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//Control+C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//shift to other box
		act.sendKeys(Keys.TAB);
		act.perform();
		
		//control+V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//compare
		
		if(input1.getAttribute("value").equals(input2.getAttribute("value")))
				{
			System.out.println("Text is copied and pasted && test is passed");
				}
		else
		{
			System.out.println("There is some problem with ur code.. please check with action methods");
		}
	
		
		
		

	}

}
