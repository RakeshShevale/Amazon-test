package assignment_utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class MultiWindowHandle {

	


	/*
	 * Its Applicable for TWO window only
	 */
	public void switchToOtherWindow(WebDriver driver) {
		String currentWindowId=driver.getWindowHandle();
		Set <String> set=driver.getWindowHandles();
		for(String id:set) {
			if(id!=currentWindowId) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	
}
