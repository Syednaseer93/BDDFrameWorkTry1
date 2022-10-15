package WaitConcept.WaitConcept;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	public static void main(String[] args) {//THIS IS FOR CHROME
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		//Chrome
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		//preferences.put("plugins.always_open_pdf_externally", true);// add this only thing to download pdf file and change mime
		
		
		ChromeOptions options =new ChromeOptions();	
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div[1]/a\r\n"
				+ "")).click();
	
	}

}
