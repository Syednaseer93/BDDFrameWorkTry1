package WaitConcept.WaitConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulShettyAcademyEndtoEnd {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahhul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
			
		Thread.sleep(2000);
		String actMsg=driver.findElement(By.tagName("p")).getText();
		System.out.println(actMsg);
		String expMsg="You are successfully logged in.";
		
		if(actMsg.equals(expMsg)) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed");
		}
		
	}

}
