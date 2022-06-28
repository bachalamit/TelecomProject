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
public class AddCustomerPage  {
	
	WebDriver driver;

	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"one\"]/div/div[1]/div[1]/h3/a")
	WebElement linkAddCustomer;
	
	@FindBy(xpath="//label[normalize-space()='Done']")
	WebElement backgroundcheck;
	
	@FindBy(id="fname")
	WebElement firstname;
	
	@FindBy(id="lname")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement email;

	@FindBy(xpath="//textarea[@id='message']")
	WebElement address;

	@FindBy(id="telephoneno")
	WebElement mob;

	@FindBy(name="submit")
	WebElement clickSubmit;
	
	
	
	public void clickAddCustomer()
	{
		linkAddCustomer.click();
	}
	
	public void clickBackgroundCheck()
	{
		backgroundcheck.click();
	}
	
	public void setFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
	}
	public void setEmail(String emailID)
	{
		email.sendKeys(emailID);
	}
	
	public void setAddress(String add)
	{
		address.sendKeys(add);
	}
	public void setMobile(String tel)
	{
		mob.sendKeys(tel);
	}
	public void clickOnSubmit()
	{
		clickSubmit.click();
	}
	
}
