package WaitConcept.WaitConcept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		List <WebElement> links= driver.findElements(By.tagName("a"));
		int brokenlink=0;
		for(WebElement ele:links)
		{		
			String url=ele.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is empty");
				continue;
			}
			URL link= new URL(url);
			try { 

				HttpURLConnection httpcon=(HttpURLConnection)link.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400)
				{
					System.out.println(httpcon.getResponseCode()+ "is a Broken link");
					brokenlink++;
				}
				else
				{
					System.out.println(httpcon.getResponseCode()+ "Link is Valid");
				}
			}
			catch (Exception e) {
			}
		}
		System.out.println("Total number of Broken links are "+brokenlink);
		driver.quit();
	}


}

