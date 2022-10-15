package WaitConcept.WaitConcept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	WebDriver driver;
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement>brokenLinks=driver.findElements(By.tagName("a"));
		int brokenLink=0;
		int ValidLink=0;
		for(WebElement element:brokenLinks)
		{
			String url=element.getAttribute("href");
			if(url.isEmpty())
			{
				System.out.println("Url is Empty");
				continue;
			}
			URL link=new URL(url);
			HttpURLConnection httpcon=(HttpURLConnection) link.openConnection();
			httpcon.connect();
			if(httpcon.getResponseCode()>=400) 
			{
				System.out.println(httpcon.getResponseCode()+" "+url+" "+ " is a Broken Link");
				brokenLink++;
			}
			else 
			{
				System.out.println(httpcon.getResponseCode()+" "+url+" "+"its a Valid Link");
				ValidLink++;
			}
			System.out.println("Total number of broken Links are :"+brokenLink);
			System.out.println("Total number of Valid Links are :"+ValidLink);
		}
	}
}
