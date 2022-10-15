package WaitConcept.WaitConcept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement logo=driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img\r\n"
				+ ""));
		JavascriptUtils jsutil=new JavascriptUtils();
	
		//	jsutil.drawBorder(driver, logo); //To draw a Border
		
		
/*		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trgt=new File(".//Screenshots//logonopcommerce.png");
		FileUtils.copyFile(src, trgt);   */ 
		
	//	String title=jsutil.getTitle(driver);System.out.println(title);// to get title
	//	jsutil.generateAlert(driver,"Hi guys");// to generate alert
		
		jsutil.flash(logo, driver);
		
	}

}
