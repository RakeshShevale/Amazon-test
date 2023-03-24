package assignment_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {


	WebDriver driver=null;


	public SearchResultPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[contains(@class,'a-size-medium a-color-base a-text-normal')]")
	private  List <WebElement>  allMobiles;


	public ArrayList<String> getListOfMobile() {
		ArrayList <String> list=new ArrayList <String> ();
		for(int i=0;i<allMobiles.size();i++) {
			String str=allMobiles.get(i).getText();
			list.add(str);
		}
		return list;
	}

	public boolean verifyFreeDeliveryAvailableOnMobile(String mobileName) {
		String xpath="//*[text()='"+mobileName+"']/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//following-sibling::div[@class='sg-row']//child::*[@class='a-color-base']";
		System.out.println(xpath);


		boolean b=driver.findElement(By.xpath(xpath)).isDisplayed();
		// mobile name =Apple iPhone 13 Mini (512 GB) - Green
		return b ;	
	}
	public int getPriceOfSelectedMobile(String mobileName) {
		//String xpath="//*[contains(text(),'"+mobileName+"')]/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']//child::*[@class='a-price']/*[@class]";
		String xpath="//*[contains(text(),'"+mobileName+"')]/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']//child::*[@class='a-price-whole']";
		String price=driver.findElement(By.xpath(xpath)).getText();
		price=price.replace(",","");
		return Integer.parseInt(price);

	}

	public void selectMobile(String mobileName) {
		for(int i=0;i<allMobiles.size();i++) {
			String str=allMobiles.get(i).getText();
			if(str.equals(mobileName)) {
				allMobiles.get(i).click();
				break;
			}
		}

	}


}
