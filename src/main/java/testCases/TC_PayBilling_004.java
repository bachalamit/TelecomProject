package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.PayBilling;

public class TC_PayBilling_004 extends BaseClass{

	PayBilling payBilling = new PayBilling(driver);
	
	@Test
	public void PayBillingStatus() throws InterruptedException
	{
		payBilling = new PayBilling(driver);
		log.info("Check Customer Billing Status");
		payBilling.clickPayBilling();
		Thread.sleep(3000);
		log.info("Enter Customer ID");
		payBilling.customerID("726844");
		payBilling.clickSubmit();
		Thread.sleep(3000);
		
		String expectedTitle = driver.getTitle();
		String actutalTitle = "Guru99 Telecom Billing";
		
		if(expectedTitle.equals(actutalTitle))
		{
		Assert.assertTrue(true);
		log.info("Test Case 004 is passed...");
	} else {
		Assert.assertTrue(false);
		log.info("Test Case 004 is failed...");
	}	
		
		
		
		
	}
	
}
