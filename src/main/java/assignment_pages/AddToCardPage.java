package assignment_pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCardPage {

	WebDriver driver;

	@FindBy(xpath="//*[contains(text(),'Sign in to your account')]")
	private WebElement signInButton;

	@FindBy(xpath="//*[contains(text(),'Sign up now')]")
	private WebElement signUpNowButton;

	@FindBy(xpath="//*[contains(text(),'Your Amazon Cart is empty')]")
	private WebElement cardIsEmptyText;


	public AddToCardPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifySigninButtonDisplay(){
		boolean b=signInButton.isDisplayed();
		return b;
	}

	public boolean verifySignupButtonDisplay(){
		boolean b=signUpNowButton.isDisplayed();
		return b;
	}

	public boolean verifyYourAmazonCartisemptyTextDisplay(){
		boolean b=cardIsEmptyText.isDisplayed();
		return b;
	}

}
