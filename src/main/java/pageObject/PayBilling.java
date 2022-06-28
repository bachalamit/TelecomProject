package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBilling {
	
	WebDriver driver;

	public PayBilling(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Pay Billing'])[1]")
	WebElement linkPayBilling;
	
	@FindBy(id="customer_id")
	WebElement cid;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submit;
	
	
	public void clickPayBilling()
	{
		linkPayBilling.click();
	}
	public void customerID(String cID)
	{
		cid.sendKeys(cID);
	}
	public void clickSubmit()
	{
		submit.click();
	}
	
}
