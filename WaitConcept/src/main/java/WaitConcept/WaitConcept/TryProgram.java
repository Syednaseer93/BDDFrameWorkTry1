package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryProgram {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded = { "Brocolli", "Beetroot", "Tomato" };
		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		String promoCode = driver.findElement(By.xpath("//span[.='Code applied ..!']")).getText();
		driver.findElement(By.xpath("//button[.='Place Order']")).click();

		WebElement country = driver.findElement(By.xpath("//select"));
		Select s = new Select(country);
		s.selectByVisibleText("India");
		driver.findElement(By.xpath("//input[@class='chkAgree']")).click();
		driver.findElement(By.xpath("//button[.='Proceed']")).click();

	}

	static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='product']"));
		for (int i = 0; i < allProducts.size(); i++) {
			String name = allProducts.get(i).getText();
			// Brocolli - 1 Kg

			String arr[] = name.split("-");
			String formattedName = arr[0].trim();
			List<String> items = Arrays.asList(itemsNeeded);

			if (items.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
