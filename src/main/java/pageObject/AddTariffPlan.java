/**
 * 
 */
package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author AMIT123
 *
 */
public class AddTariffPlan {
	WebDriver driver;

	public AddTariffPlan(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Add Tariff Plan']")
	WebElement linkaddTariffPlan;
	
	@FindBy(id="rental1")
	WebElement rental;
	
	@FindBy(id="local_minutes")
	WebElement localmin;
	
	@FindBy(id="inter_minutes")
	WebElement intermin;
	
	@FindBy(id="sms_pack")
	WebElement sms;
	
	@FindBy(id="minutes_charges")
	WebElement minutescharges;
	
	@FindBy(id="inter_charges")
	WebElement intercharges;
	
	@FindBy(id="sms_charges")
	WebElement smscharges;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submit;
	
	
	public void clickTarrifPlan()
	{
		linkaddTariffPlan.click();
	}
	
	public void MonthlyRental(String rent)
	{
		rental.sendKeys(rent);
	}
	public void FreeLocalMinutes(String Lmin)
	{
		localmin.sendKeys(Lmin);
	}
	public void FreeInternationalMinutes(String Imin)
	{
		intermin.sendKeys(Imin);
	}
	public void FreeSMSPack(String SMSpack)
	{
		sms.sendKeys(SMSpack);
	}
	public void LocalPerMinutesCharges(String LperMin)
	{
		minutescharges.sendKeys(LperMin);
	}
	public void InternationalPerMinutesCharges(String IperMin)
	{
		intercharges.sendKeys(IperMin);
	}
	public void SMSPerCharges(String SMScharge)
	{
		smscharges.sendKeys(SMScharge);
	}
	public void ClickSubmit()
	{
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
