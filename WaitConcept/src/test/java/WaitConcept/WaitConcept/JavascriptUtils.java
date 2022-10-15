package WaitConcept.WaitConcept;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class JavascriptUtils {
	public static void drawBorder(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String getTitle(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}		

	public static void generateAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('" +message+ "')");	
	}
	
	public static void refreshPage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0);");
	}
	
	public static void scrollPagedown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollPageup(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public static void zoomPage(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50'");
	}
	public static void flash(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String bgcolor= element.getCssValue("backGroundColor");
		for(int i=0;i<50;i++)
		{
			changeColor("#FF0000",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='" +color+ "'", element);
		try {
		Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
	}
	public void disabledElementHandle() {
		/*  JavascriptExecutor js=(JavascriptExecutor)driver;
		 * String js="v='Ravi';	e=document.getElementById('A4');e.value=v";
		 * 
		 * 
		 * 
		 * 	


				
		*/
	}
}
