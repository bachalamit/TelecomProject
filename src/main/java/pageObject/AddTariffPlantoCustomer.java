package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTariffPlantoCustomer {
	
	
	WebDriver driver;

	public AddTariffPlantoCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Add Tariff Plan to Customer'])[1]")
	WebElement linktoaddplan;
	
	@FindBy(id="customer_id")
	WebElement CustomerID;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//label[@for='sele']")
	WebElement selectplan;
	
	@FindBy(xpath = "//input[@name='submit']")
	WebElement clickonaddplan;
	
	
	public void clickonAddTariffPlantoCustomer()
	{
		linktoaddplan.click();
	}
	public void enterCustomerId(String id)
	{
		CustomerID.sendKeys(id);
	}
	public void clickonSubmit()
	{
		submit.click();
	}
	public void CheckSelectPlan()
	{
		selectplan.click();
	}
	public void clickonaddplantocustomer()
	{
		clickonaddplan.click();
	}

}
