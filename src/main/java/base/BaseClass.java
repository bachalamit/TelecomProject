/**
 * 
 */
package base;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;

/**
 * @author AMIT123
 *
 */
public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public static WebDriver driver;
	public static Logger log;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		log = Logger.getLogger("Telecom");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			ChromeOptions opt = new ChromeOptions();
			opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking", "enable-automation"));
			driver = new ChromeDriver(opt);
			driver.manage().window().maximize();
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readConfig.getEdgepath());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxpath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
		
	
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
		
	}
	public void capturescreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(src, target);
		System.out.println("Screenshot of Failed testcase is taken");
	}
	

}
