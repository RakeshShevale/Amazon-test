package assignment_utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Factory {


	static WebDriver driver=null;

	public WebDriver startUp(String browserName,String url){
		if(browserName.equalsIgnoreCase("ch")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "./Drivers/msedgedriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("ie")) {
			//System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new InternetExplorerDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.ie.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser doesn't exists");
		}
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void closure() {
		driver.close();
	}


}
