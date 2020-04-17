package Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;
	private String keyword;
	
	@BeforeTest	
	public void setUpDriver() throws MalformedURLException {
		// BROWSER => chrome/ firefox
		// HUB_HOST => localhost / 10.11.12.13/ host name
		
		String host="localhost";
		DesiredCapabilities dc;
		
		if(System.getProperty("BROWSER")!= null && 
				System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			dc=DesiredCapabilities.firefox();
		}
		else
		{
			dc=DesiredCapabilities.chrome();
		}
		
		if(System.getProperty("HUB_HOST")!= null) {
			host = System.getProperty("HUB_HOST");
		}
		
		String compleateUrl= "http://"+ host +":4444/wd/hub";
		this.driver=new RemoteWebDriver(new URL(compleateUrl), dc);
		
//		System.setProperty("webdriver.chrome.driver","./chromedriver_win32/chromedriver.exe");
//		   this.driver=new ChromeDriver();
	}
	
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
		System.out.println("Closed the browser");
	}
}
