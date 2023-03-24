package pageIgnition;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class PAGEIG2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get(
				"https://www.flipkart.com/search?q=aaple+mobile&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&page=1");
		driver.manage().window().maximize();
	
		List<WebElement> mobilelist = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='ge-49M']"));

		for(int i=0;i<list.size();i++) {
			
			for(int j =0;j<mobilelist.size();j++) {
				mobilelist.get(i).getText();
			System.err.print("error");
		}
			
			
		list.get(i).click();
		Thread.sleep(5000);
			
		list = driver.findElements(By.xpath("//a[@class='ge-49M']"));
			
			
				}
		System.out.println("Completed");

	}

}
