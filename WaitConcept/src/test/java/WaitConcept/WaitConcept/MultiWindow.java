package WaitConcept.WaitConcept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement search = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = search.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\screenshots\\feelinglucky.png");
		FileUtils.copyFile(src, trg);
		
		
	
	}

}
