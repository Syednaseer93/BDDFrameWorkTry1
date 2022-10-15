package WaitConcept.WaitConcept;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class DataDrivenTestNg {
	WebDriver driver;

	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd, String exp)
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		WebElement emailid=driver.findElement(By.name("Email"));
		emailid.clear();
		emailid.sendKeys(user);
        WebElement password=driver.findElement(By.id("Password"));
		password.clear();
		password.sendKeys(pwd);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
		String act_title=driver.getTitle();
		String exp_title="Dashboard / nopCommerce administration";
		if(exp.equals("Valid"))
		{
			if(act_title.equalsIgnoreCase(exp_title))
			{
				driver.findElement(By.xpath("/html/body/div[3]/nav/div/ul/li[3]/a")).click();
				Assert.assertTrue(true);
			}
			else
			{  
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("Invalid"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.xpath("/html/body/div[3]/nav/div/ul/li[3]/a")).click();

				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);	
			}		
		}
	}	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
				{"admin@yourstore.com","admin","Valid"},
				{"adm@yourstore.com","admin","Invalid"},
				{"admin@yourstore.com","adm","Invalid"},
				{"yourstore@admin.com","admin","Invalid"},
				{"youystore@admin.com","admin","Invalid"},
				{"yourstore@admin.com","addmin","Invalid"},
				{"yourstgore@admin.com","adtmin","Invalid"}
		};  */

		String path=".\\Datafiles\\Book2.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalRows=xlutil.getRowCount("Sheet1");
		int totalCols=xlutil.getCellCount("Sheet1",1);

		String loginData[][]=new String[totalRows][totalCols];
			//First Step:Take the data from EXCEL and store in 2d array
		for(int i=1;i<=totalRows;i++)	
		{
			for(int j=0;j<totalCols;j++)
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1",i,j);
			}
		}
		return loginData;
	}	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
}
