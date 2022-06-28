package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObject.AddTariffPlan;

public class TC_AddTariffPlan_002 extends BaseClass{
	
	AddTariffPlan TariffPlan = new AddTariffPlan(driver);
	
	@Test
	public void addTariffPlanInfo() throws InterruptedException
	{
		TariffPlan = new AddTariffPlan(driver);
		log.info("Add Tariff Plans info");
		TariffPlan.clickTarrifPlan();
		Thread.sleep(3000);
		TariffPlan.MonthlyRental("251");
		TariffPlan.FreeLocalMinutes("1000");
		TariffPlan.FreeInternationalMinutes("600");
		TariffPlan.FreeSMSPack("250");
		TariffPlan.LocalPerMinutesCharges("1");
		TariffPlan.InternationalPerMinutesCharges("2");
		TariffPlan.SMSPerCharges("2");
		TariffPlan.ClickSubmit();
		log.info("Tariff Plans info is added");
		
		Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Congratulation you add Tariff Plan");
		
		if (result == true) {
			Assert.assertTrue(true);
			log.info("Test Case 002 is passed...");
			driver.findElement(By.xpath("//a[@class='button']")).click();
			log.info("Click on Home button");
		} else {
			Assert.assertTrue(false);
			log.info("Test Case 002 is failed...");
		}

		
		
	}

}
