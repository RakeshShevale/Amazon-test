package pageIgnition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import assignment_utility.Browser_Factory;
import assignment_utility.ReaderClass;

public class PageIgnitionClass {
	
	static WebDriver driver = null;
	ReaderClass read = new ReaderClass();
	Browser_Factory br = new Browser_Factory();

	@BeforeClass
	public void startUp() throws Exception {
		String url = read.get("url");
		System.out.println("url : -" + url);
		String browser = read.get("br");
		System.out.println("Browser Name :-" + browser);
		driver = br.startUp(browser, url);
	}
	@Test
	
	public void test() throws InterruptedException {
	//String nextbutton =	driver.findElement(By.xpath("//*[text()='Next']")).getAttribute("Next");
	//WebElement next =	driver.findElement(By.xpath("//*[text()='Next']"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	
	
//	 List<WebElement> ele = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	

	
	List<WebElement> list = driver.findElements(By.xpath("//a[@class='ge-49M']"));
	for(int i=0;i<list.size();i++) {		
		list.get(i).click();
		Thread.sleep(3000);
		//list = driver.findElements(By.xpath("//a[@class='ge-49M']"));
		
	
			}

	}
	
}
