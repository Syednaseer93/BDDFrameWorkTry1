package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewwindowNewtab {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
	//	Keys.chord(Keys.CONTROL,Keys.RETURN); to open the link in new tab
		
		
		driver.switchTo().newWindow(WindowType.WINDOW);//to open 2 urls get methods in different windows
	//	driver.switchTo().newWindow(WindowType.TAB);//to open 2 urls get methods in different tabs

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

}
