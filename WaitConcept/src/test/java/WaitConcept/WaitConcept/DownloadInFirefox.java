package WaitConcept.WaitConcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadInFirefox {

	public static void main(String[] args) {
		String location=System.getProperty("user.dir")+"\\Downloads\\";
		FirefoxProfile profile=new FirefoxProfile();
	//	profile.setPreference("pdfjs.disabled", true);// add this only thing to download pdf. and add mime
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/word"); //value is a mime type , for word it is mentioned
		profile.setPreference("browser.download.folderList", 2); //0=desktop, 1=downloads,2=desired location
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options =new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

}
