package salesinventory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	BaseTest(){
		WebDriver driver= new ChromeDriver();
		PageFactory.initElements(driver, this);		
	}
	

}