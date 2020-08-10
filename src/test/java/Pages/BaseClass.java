package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	protected WebDriver driver = null;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\A_CHITTARANJAN_DOMAIN\\Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ixigo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}

