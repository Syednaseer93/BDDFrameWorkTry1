package WaitConcept.WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebtable {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//Navigating to the Webtable inside webpage
		driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[3]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div[1]/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/a")).click();
		driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/ul/li[1]/a")).click();


		//Taking text from right bottom and extract page no value	
		String text=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div[2]/form/div[2]/div[2]")).getText();
		//System.out.println(text);
		text.indexOf("(");
		text.indexOf("Pages");

		//converting String text pageno to integer		
		int totalpages=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println("Total number of pages are: "+totalpages);

		//checking for active page and printing active page number
		for(int p=1;p<=totalpages;p++)
		{	
			WebElement activePage=driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
			System.out.println("Active Page is: "+activePage.getText());
			//activePage.click();
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", activePage); 

			//Printing the total number of rows in active page
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
			System.out.println("Total number of Rows are" +rows);

			//Retreiving orderid,custname and status from every page
			for(int r=1;r<=rows;r++)
			{
				String orderId=	driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[2]")).getText();
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[4]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[5]")).getText();
				//printing only pending records data filtered more
				if(status.equalsIgnoreCase("Pending"))
				{
					System.out.println(orderId+"  "+customerName+"  "+"  "+status);
				}
			}  
			String pageno=Integer.toString(p+1);
			WebElement next=driver.findElement(By.xpath("//ul[@class='pagination']/li/a[text()='"+pageno+"']"));
			//next.click();
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("arguments[0].click();", next); 
		}
		driver.close();
	}
}
