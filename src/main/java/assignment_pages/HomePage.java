package assignment_pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {	

	WebDriver driver=null;

	@FindBy(xpath="//div[@id='nav-cart-count-container']")
	private  WebElement  cart;

	@FindBy(xpath="//select[contains(@class,'search-dropdown')]")
	private  WebElement  selectionDropdown;


	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private  WebElement  searchField;

	@FindBy(xpath="//input[contains(@id,'search-submit')]")
	private  WebElement  searchbutton;



	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public int getCardItem() {
		String cardItem=cart.getText();
		int carditem=Integer.parseInt(cardItem);
		return carditem;
	}

	public void selectBytext(String text) {
		Select select=new Select(selectionDropdown);
		select.selectByVisibleText(text);
	}
	public void searchProduct(String searchproduct) {
		searchField.sendKeys(searchproduct);
	}

	public void clickOnSearchButton() {
		searchbutton.click();
	}
	public void clickonCart() {
		cart.click();
	}



}
