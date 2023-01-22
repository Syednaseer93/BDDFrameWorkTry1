package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepick {

	public static void main(String[] args) throws InterruptedException {
		String month = "Jan";
		String year = "2023";
		String day = "15";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("onward_cal")).click();
		WebElement monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']"));

		while (true) {
			String monyr = monthYear.getText();
			String arr[] = monyr.split(" ");
			String mon = arr[0];
			String yr = arr[1];

			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
				break;
			} 
			else {
				driver.findElement(By.xpath("//td[@class='next']/button")).click();
			}	
			List<WebElement> allDates = driver.findElements(By.xpath("//tr//td"));
			for (WebElement date : allDates) {
				String tempDate = date.getText();
				if (tempDate.equals(day)) {
					date.click();
					break;
				}
			}
		}

	}
}
