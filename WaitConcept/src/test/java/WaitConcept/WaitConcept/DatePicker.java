package WaitConcept.WaitConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		String month="Sept";
		String year="2022";
		String date="28";
		driver.findElement(By.xpath("/html/body/section/div[2]/main/section/div/div[2]/section/div/div[3]/span\r\n"
				+ "")).click();
		while(true)// this loop decides month and year
		{
			
		String monthyear=driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[2]\r\n"
				+ "")).getText();
		String[] arr=monthyear.split(" ");
		String mon=arr[0];
		String yr=arr[1];
		if(month.equalsIgnoreCase(mon) && year.equalsIgnoreCase(yr))
			break;
		else
			driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[3]/button\r\n"
					+ "")).click();	
		}
		// decide date now
	List <WebElement> alldates=driver.findElements(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td"));
		for(WebElement currentdate:alldates)
		{
			String dt=currentdate.getText();
			if(date.equals(dt))
					{
				currentdate.click();	
				break;
					}
		}
		
	}

}
