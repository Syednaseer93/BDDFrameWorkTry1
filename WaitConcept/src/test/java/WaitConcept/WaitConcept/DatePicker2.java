package WaitConcept.WaitConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		String date="24";
		driver.findElement(By.xpath("//*[@id=\"departon\"]\r\n"
				+ "")).click();
		
		Select month=new Select(driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/select[1]\r\n"
				+ "")));
		month.selectByVisibleText("Nov");
		Select year=new Select(driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/select[2]\r\n"
				+ "")));
		year.selectByVisibleText("2023");
		//Select date
		List <WebElement>alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
		for(WebElement currentdate:alldates)
		{
			String dt=currentdate.getText();
			if(dt.equalsIgnoreCase(date))
			{
				currentdate.click();
				break;
			}
		}
		
	}

}
