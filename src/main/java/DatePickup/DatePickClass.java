package DatePickup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DatePickClass {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new EdgeDriver();
	driver.get("https://www.cleartrip.com/do/search/flights?title=Book%20Air%20Tickets&coupon=CTFLY&utm_source=google&utm_medium=cpc&utm_campaign=Gen:High-Conv_Exact-DeskTab&dxid=Cj0KCQjw2cWgBhDYARIsALggUhozf2ot8BMpokq2Zlv7WNmgDwWVm6u8PB-P4TRooR0UbpVAP3Wx6twaAhkwEALw_wcB&gclid=Cj0KCQjw2cWgBhDYARIsALggUhozf2ot8BMpokq2Zlv7WNmgDwWVm6u8PB-P4TRooR0UbpVAP3Wx6twaAhkwEALw_wcB");
	driver.manage().window().maximize();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@name ='depart_date']")).click();
	
	String yearMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
	String year = yearMonth.split(" ")[0].trim();
	String month = yearMonth.split(" ")[1].trim();
	
	Thread.sleep(5000);
	System.out.println(yearMonth);
	System.out.println(year);
	System.out.println(month);
	
	while(!(month.equalsIgnoreCase("March")&&(year.equalsIgnoreCase("2023")))) {
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e")).click();
		Thread.sleep(5000);
		 year = yearMonth.split(" ")[0].trim();
		 month = yearMonth.split(" ")[1].trim();

		System.out.println(yearMonth);
	}
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[text()='17']")).click();
	
	
	
	
	
}
}
