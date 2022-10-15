package WaitConcept.WaitConcept;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenFinal {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");


		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		FileInputStream fis=new FileInputStream("C://SeleniumPractice//Sheet1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet2");
		int rows=sheet.getLastRowNum();
		for(int i=1;i<=rows;i++)
		{
			XSSFRow currentrow= sheet.getRow(i);

			int princ=	(int)currentrow.getCell(0).getNumericCellValue();

			int rateofinterest=(int)currentrow.getCell(1).getNumericCellValue();

			int per=(int)currentrow.getCell(2).getNumericCellValue();

			String freq=currentrow.getCell(3).getStringCellValue();

			int exp_mvalue=(int)currentrow.getCell(4).getNumericCellValue();

			driver.findElement(By.id("principle")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.xpath("tenure")).sendKeys(String.valueOf(per));

			Select periodcombo=new Select(driver.findElement(By.id("tenurePeriod")));
			periodcombo.selectByVisibleText("year(s)");

			Select frequency=new Select(driver.findElement(By.xpath("frequency")));
			frequency.selectByVisibleText(freq);


			driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[5]/div/div[1]/div[3]/form/div[2]/a[1]/img\r\n"
					+ "")).click();
			String actual_mvalue=driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[5]/div/div[1]/div[4]/div/div[2]/span[2]/strong\r\n"
					+ "")).getText();

			if((Double.parseDouble(actual_mvalue))==exp_mvalue)
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
			driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div[5]/div/div[1]/div[3]/form/div[2]/a[2]/img\r\n"
					+ "")).click();



		}

	}
}
