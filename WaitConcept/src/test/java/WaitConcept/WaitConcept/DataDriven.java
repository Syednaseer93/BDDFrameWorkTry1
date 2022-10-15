package WaitConcept.WaitConcept;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C://SeleniumPractice//Sheet1.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(1).getLastCellNum();
		for(int i=0;i<rows;i++)
		{
			XSSFRow currentrow= sheet.getRow(i);
			for(int j=0;j<columns;j++) 
			{
				String value=currentrow.getCell(j).toString();
				System.out.print(" "+value);
			}
			System.out.println();
		}

	}

}
