package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntelExcelPractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://intelexel.in/?page_id=1268");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions act = new Actions(driver);
		WebElement products=driver.findElement(By.linkText("Products"));
		WebElement addOns=driver.findElement(By.linkText("Add-ons"));
		act.moveToElement(products).moveToElement(addOns).click().build().perform();

		//div[@class='tg-column-4 footer-block']/section[@id='nav_menu-3']
		WebElement footer = driver.findElement(By.xpath("//div[@class='tg-column-4 footer-block']/section[@id='nav_menu-3']"));
		List<WebElement> list = footer.findElements(By.tagName("a"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(footer));
		for(WebElement link:list) {
			String keys=Keys.chord(Keys.CONTROL,Keys.RETURN);
			link.sendKeys(keys);
		}
		Thread.sleep(10000);
		Set<String> WIDs= driver.getWindowHandles();
		Iterator<String> it = WIDs.iterator();
		String title = driver.switchTo().window(it.next()).getTitle();
		System.out.println(title);
	}
}
