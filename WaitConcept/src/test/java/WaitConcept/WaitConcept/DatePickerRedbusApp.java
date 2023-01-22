package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerRedbusApp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("onward_cal")).click();
		String year= "2023";
		String month="Dec";
		String day="15";


		while(true)
		{
			String monthyear=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String arr[]=monthyear.split(" ");
			String mon= arr[0];
			String yr= arr[1];

			if(mon.equals(month) && yr.equals(year))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr[1]/td[3]/button\r\n"
						+ "")).click();
			}	
		}
	List<WebElement> alldays=driver.findElements(By.xpath("//tbody//tr//td"));
	for(WebElement daynum:alldays)
	{
		String daynumfinal=daynum.getText();
		if(daynumfinal.equalsIgnoreCase(day))
		{
			daynum.click();
			break;
		}
	}
	}
	
}
