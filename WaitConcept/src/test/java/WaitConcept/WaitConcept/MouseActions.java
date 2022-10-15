package WaitConcept.WaitConcept;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement rightclick=driver.findElement(By.linkText("Women"));
		WebElement ele= driver.findElement(By.xpath("//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']"));

		Actions act=new Actions(driver);
	//	act.contextClick(rightclick).perform();
	//	act.doubleClick(rightclick).perform();
	//	act.dragAndDrop(rightclick, rightclick).perform();

	//	act.moveToElement(rightclick).moveToElement(ele).click();
WebElement target1=driver.findElement(By.xpath("//a[@title='Women']"));
//WebElement target2=driver.findElement(By.xpath("//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']"));
		act.moveToElement(target1).perform();
		
		
	}

}
