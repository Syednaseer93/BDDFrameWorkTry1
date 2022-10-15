package WaitConcept.WaitConcept;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTestNg2 {
	WebDriver driver;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@Test(dataProvider="LoginData")
	public void loginData(String user,String pwd, String check)
	{
        driver.get("https://demo.opencart.com/admin/");
		driver.findElement(By.xpath("//*[@id='input-username']")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[3]/button")).click();

		String actual_title=driver.getTitle();
		String exp_title="DFGHJKLKJHGFDFGH";
		if(check.equals("Valid"))
		{
			if(actual_title.equals(exp_title))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(check.equals("Invalid"))
		{
			if(actual_title.equals(exp_title))
			{
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true)	;	
			}
		}

	}

	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
	/*	String loginData[][]= {{"User","pwd","Invalid"}
		,{"Usr","pdw","Invalid"},
		{"srt","ksdbf","Invalid"}
		};*/
		String path=".\\Datafiles\\Book3.xlsx";
		XLUtility xlutil=new XLUtility(path);
		int rows=xlutil.getRowCount("Sheet1");
		int cols=xlutil.getCellCount("Sheet1",1);
		String loginData[][]=new String[rows][cols];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				 loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}

		return loginData;
	}





}
