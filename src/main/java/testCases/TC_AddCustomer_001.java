/**
 * 
 */
package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.AddCustomerPage;

/**
 * @author AMIT123
 *
 */
public class TC_AddCustomer_001 extends BaseClass {

	AddCustomerPage addcust = new AddCustomerPage(driver);

	@Test
	public void addNewCustomer() throws InterruptedException {
	addcust = new AddCustomerPage(driver);
	
		
	log.info("Click on Add Customer Link");
		addcust.clickAddCustomer();
		Thread.sleep(3000);
		log.info("Providing the customer details");
		addcust.clickBackgroundCheck();
		addcust.setFirstName("Amit");
		addcust.setLastName("Bachal");
		addcust.setAddress("Pune");
		addcust.setMobile("8978989789");
		String email = randomString() + "@gmail.com";
		addcust.setEmail(email);
		
		addcust.clickOnSubmit();
		log.info("Customer details submitted successfully...");
		
		boolean result = driver.getPageSource().contains("Please Note Down Your CustomerID");

		if (result == true) {
			Assert.assertTrue(true);
			log.info("Test Case 001 is passed...");
			driver.findElement(By.xpath("//a[@class='button']")).click();
			log.info("Click on Home button");
		} else {
			Assert.assertTrue(false);
			log.info("Test Case 001 is failed...");
		}
		
		
		
	}
}
