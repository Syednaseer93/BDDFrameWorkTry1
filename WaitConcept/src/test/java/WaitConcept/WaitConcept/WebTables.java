package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		Thread.sleep(7000);
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Number of rows
		int noOfRows=driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[2]/table/tbody/tr")).size();
		int noOfCols=driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[2]/table/tbody/tr/th")).size();
	//	System.out.println(noOfRows+"  "+noOfCols);
		
		for(int r=1;r<=noOfRows;r++) 
		{
			for(int c=1;c<=noOfCols;c++)
			{
				String fullTable=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/main/div/div[1]/div/article/div/div/div[3]/div[1]/div[2]/table/tbody/tr["+r+"]/td["+c+"]")).getText();
				System.out.print(fullTable);
			}
			System.out.println();
		}
		
	}

}
