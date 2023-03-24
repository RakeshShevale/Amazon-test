package assignment_pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {


	WebDriver driver=null;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-none aok-align-center']//*[@class='a-price-whole']")
	private  WebElement  mobilePrice;

	public ProductPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getPriceOfSelectedMobilefromProductPage() {	
		String price=mobilePrice.getText();
		price=price.replace(",","");
		return Integer.parseInt(price);
		
	}
	
	
	@FindBy(xpath="//div[text()='Select delivery location']")
	private  WebElement  selectLocation;
	
	@FindBy(xpath="//input[contains(@aria-label,' Indian pincode')]")
	private  WebElement  pincode;
	
	public void clickOnselectLocation() {
		selectLocation.click();
	}
	
	public void enterPin(String pin) {
		pincode.sendKeys(pin);
	}
	
	@FindBy(xpath="//*[text()='Apply']/parent::*[@class]/input")
	private  WebElement  applyButton;
	
	public void clickOnapply() {
		applyButton.click();
	}
	
	@FindBy(xpath="//div[@id='contextualIngressPtLabel_deliveryShortLine']//*[contains(text(),'Mumbai')]")
	private  WebElement updatedLocation;
	
	 public String getupdatedLocation() {
		 return updatedLocation.getText();
	 }

		



}
