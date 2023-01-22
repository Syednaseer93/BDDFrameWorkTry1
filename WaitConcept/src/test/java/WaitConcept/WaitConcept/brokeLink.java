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

public class brokeLink {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int brokenLink=0;
		int validLink=0;
		for(WebElement tempLink:allLinks)
		{
			String url=tempLink.getAttribute("href");

			if(url==null || url.isEmpty()) {
				System.out.println("URL is empty");
				continue;
			}
			
				URL link =new URL(url);
				HttpURLConnection httpCon=(HttpURLConnection) link.openConnection();
				httpCon.connect();

				if(httpCon.getResponseCode()>=400) {
					System.out.println("Broken link is"+link+" with response code "+httpCon.getResponseCode());
					brokenLink++;
				}
				else {
					System.out.println("This is a Valid Link: "+link);
					validLink++;
				}


				System.out.println("Total number of broken links"+brokenLink+" /nTotal number of valid links are"+validLink);

		}
		


	}

}
