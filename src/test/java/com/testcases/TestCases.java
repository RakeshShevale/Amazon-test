package com.testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import assignment_pages.AddToCardPage;
import assignment_pages.HomePage;
import assignment_pages.ProductPage;
import assignment_pages.SearchResultPage;
import assignment_utility.Browser_Factory;
import assignment_utility.MultiWindowHandle;
import assignment_utility.ReaderClass;



public class TestCases {
	static WebDriver driver=null;
	ReaderClass read=new ReaderClass ();
	Browser_Factory br=new Browser_Factory ();

	@BeforeClass
	public void startUp() throws Exception {	
		String url=read.get("url");
		System.out.println("url : -"+url);
		String browser=read.get("br");
		System.out.println("Browser Name :-"+browser);
		driver=br.startUp(browser,url);
	}

	@Test
	public void test() throws Exception {	
		//Apply Implicites Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Verify Cart displays 0 items.
		HomePage obj=new HomePage(driver);
		Thread.sleep(6000);
		int actualitemNumber=obj.getCardItem();
		System.out.println("Actual items in card :-"+actualitemNumber);
		int expectedCardItem=0;
		Assert.assertEquals(expectedCardItem, actualitemNumber);

		//click on cart
		obj.clickonCart();

		//go to cart page and check button
		AddToCardPage addtoCart=new AddToCardPage (driver);

/*
 *3) Click on cart and verify Your Amazon Cart is empty is displayed with Sign in
* to your account and Sign up now button
*/			
		//verify signupButton Display or not
		boolean b1 = addtoCart.verifySignupButtonDisplay();
		System.out.println("verifySignupButtonDisplay:-"+b1);
		//verify signinButton Display or not
		boolean b2 =addtoCart.verifySigninButtonDisplay();
		System.out.println("verifySigninButtonDisplay:-"+b2);

		// verify cart empty text display or not
		boolean text =addtoCart.verifyYourAmazonCartisemptyTextDisplay();
		System.out.println("verifyYourAmazonCartisemptyTextDisplay:-"+text);
		/*		
4)Click on Electronics from dropdown menu and Search iPhone 13.
		 *
		 */		
		String searchText=read.get("dropdownSelection");
		System.out.println("Dropdown selection :-"+searchText);
		obj.selectBytext(searchText);


		// Search for Iphone 13
		String mobileSearch=read.get("mobileSearch");
		obj.searchProduct(mobileSearch);
		obj.clickOnSearchButton();




		/*
		 * Verify all results are displaying mobiles related to search.
		 */
		SearchResultPage srp=new SearchResultPage(driver);
		ArrayList<String> listMobile = srp.getListOfMobile();
		System.out.println("Comparing search mobile with actual search");
		System.out.println("Actual search Mobile :-"+mobileSearch);

		for(int i=0;i<listMobile.size();i++) {
			System.out.print(listMobile.get(i)+" ,");
		}


/*
 * * Verify FREE Delivery by Amazon is available for
 * "mobile name =Apple iPhone 13 Mini (512 GB) - Green" and perform click action
 * and verify Amount reflected in Item page is same as Grid.
 */
		String mobileName=read.get("freeDeliveryforMobile");
		System.out.println("checking free delivery option for "+mobileName);

		boolean result = srp.verifyFreeDeliveryAvailableOnMobile(mobileName);
		System.out.println("Free Delivery Option Availbale :-"+result);

		int price = srp.getPriceOfSelectedMobile(mobileName);

		System.out.println("Price of selected Mobile at serach page :-"+price);

		// click on product
		srp.selectMobile(mobileName);
		System.out.println(driver.getTitle());
		//switch to product winodw
		/*
		 * MultiWindowHandle wi=new MultiWindowHandle(); wi.switchToOtherWindow(driver);
		 */
		
		String currentWindowId=driver.getWindowHandle();
		Set <String> set=driver.getWindowHandles();
		for(String id:set) {
			if(!id.equals(currentWindowId)) {
				driver.switchTo().window(id);
				break;
			}
		}
		
		//getPriceOf Product from product Page
		ProductPage pr=new ProductPage(driver);
		Thread.sleep(6000);
		int price2=pr.getPriceOfSelectedMobilefromProductPage();
		
		//comparing both pricess
		Assert.assertEquals(price, price2);

		
/*
* Then Select Variant as Starlight and Click on Select Delivery Location Link
* and enter pin code as 400025 and Apply and verify Deliver to Mumbai 400025‌
* displayed.
*/

		//click on location
		pr.clickOnselectLocation();
		
		Thread.sleep(2000);
		String pincode1=read.get("pincode");
		pr.enterPin(pincode1);	
		pr.clickOnapply();
		
		//verify updated location as per our input or not
		String location=pr.getupdatedLocation();
		System.out.print(location);
		Assert.assertTrue(location.contains(read.get("pincode")));
		
		Assert.assertTrue(location.contains(read.get("cityName")));
		
	}




	@AfterClass
	public void tearDrop() {
		//br.closure();
		
	}

}
