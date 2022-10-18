package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JqueryDDpractice {
	
	
	
	public void selectChoiceValues(WebDriver driver,String ...values){
		if(!values.equals("all")) {
			
		}
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://text-compare.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("justAnInputBox")).click();
		
	}

}
