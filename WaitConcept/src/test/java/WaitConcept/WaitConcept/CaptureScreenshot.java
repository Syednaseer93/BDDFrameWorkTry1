package WaitConcept.WaitConcept;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		//to capture Screenshot of a complete page
		/*	TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);//this will save a screenshot in default memory
		File trgt=new File(".\\Screenshots\\homepage.png");// creating a memory in desired location
		FileUtils.copyFile(src, trgt);// this method will copy file from src to dest */

		// to capture section of a page
		/*	WebElement section=	driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src=section.getScreenshotAs(OutputType.FILE);//this will save a screenshot in default memory
		File trgt=new File(".\\Screenshots\\features.png");// creating a memory in desired location
		FileUtils.copyFile(src, trgt);// this method will copy file from src to dest */

		//to capture single webelement screenshot
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src=logo.getScreenshotAs(OutputType.FILE);
		File trgt=new File(".//Screenshots//logo.png");
		FileUtils.copyFile(src, trgt);

	}

}
