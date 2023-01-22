package WaitConcept.WaitConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("syednaseer93@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rahulshettyacademy@123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card']")));
		
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card']"));
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("WebDriverWait")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("ng-animating"))));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']")));
		WebElement cart = driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;",cart);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']/i[@class='fa fa-shopping-cart']")).click();
	
	}

}
