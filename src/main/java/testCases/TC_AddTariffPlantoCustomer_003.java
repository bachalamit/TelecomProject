package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.AddTariffPlantoCustomer;

public class TC_AddTariffPlantoCustomer_003 extends BaseClass{

	AddTariffPlantoCustomer addplan = new AddTariffPlantoCustomer(driver);
	
	@Test
	public void addTariffPlantoCustomer() throws InterruptedException
	{
		addplan = new AddTariffPlantoCustomer(driver);
		log.info("Click on Add Tariff Plan to Customer");
		addplan.clickonAddTariffPlantoCustomer();
		Thread.sleep(3000);
		addplan.enterCustomerId("726844");
		addplan.clickonSubmit();
		log.info("Customer ID is entered");
		
		Thread.sleep(3000);
		//boolean result = driver.getPageSource().contains("Welcome to add customer tariff plan XYZ");
		//String actutalTitle = "Guru99 Add Tariff Plan to Customer";
		//Assert.assertEquals(actutalTitle, "Guru99 Add Tariff Plan to Customer");
		
		log.info("Select Plan and click on add plan to customer");
		//addplan.CheckSelectPlan();
		addplan.clickonaddplantocustomer();
		
		Thread.sleep(3000);
		boolean result1 = driver.getPageSource().contains("Congratulation Tariff Plan assigned");
		
		if (result1 == true) {
			Assert.assertTrue(true);
			log.info("Test Case 003 is passed...");
			driver.findElement(By.xpath("//a[@class='button']")).click();
			log.info("Click on Home button");
		} else {
			Assert.assertTrue(false);
			log.info("Test Case 003 is failed...");
		}
		
	}
	
}
