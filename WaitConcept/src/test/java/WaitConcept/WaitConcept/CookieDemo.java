package WaitConcept.WaitConcept;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieDemo {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		Set<Cookie> cookies= driver.manage().getCookies();
		System.out.println("Before Adding"+cookies.size());

	
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName()+"   "+cookie.getValue());
		}

		// adding cookies
		Cookie cookieobj=new Cookie("Syednaseer","123456");
		driver.manage().addCookie(cookieobj);












	}


}
