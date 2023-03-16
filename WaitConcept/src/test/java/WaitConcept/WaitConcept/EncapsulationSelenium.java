package WaitConcept.WaitConcept;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

 class Demo {
	private WebElement unTB;
	private WebElement upTB;
	private WebElement loginBTN;
	
	public Demo(WebDriver driver){
		unTB=driver.findElement(By.name("username"));
		upTB=driver.findElement(By.name("password"));
		loginBTN=driver.findElement(By.xpath("//button[normalize-space()='Login']"));
	}
	
	public void setUsername(String uname) {
		unTB.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		upTB.sendKeys(pwd);
	}
	public void clickLogin() {
		loginBTN.click();
	}	
}
 class EncapsulationSelenium {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Demo es=new Demo(driver);
		es.setUsername("demo");
		es.setPassword("demo");
		es.clickLogin();
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		
		String exp_title="Dashboard";
		String act_title=driver.getTitle();
		if(exp_title.equals(act_title)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test is failed");
		}
		
		driver.quit();
	}
}
