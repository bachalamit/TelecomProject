package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class Report extends BaseClass implements ITestListener{

	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-"+timeStamp+".html";
		htmlReporter =  new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/" + reportName);
		htmlReporter.loadXMLConfig("extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//extent.setSystemInfo("Name", "Amit123");
		//extent.setSystemInfo("Host Name", "Amit");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("QA Name", "Amit Bachal");
		
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Telecom Project");
		htmlReporter.config().setReportName("Automation Report on Telecom Project");
		//htmlReporter.config().setTimeStampFormat(timeStamp);
		
		
		
	}
	public void onTestSuccess(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	public void onTestFailure(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		try {
			capturescreen(tr.getMethod().getMethodName()+timeStamp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}	
	public void onTestSkipped(ITestResult tr)
	{
		test=extent.createTest(tr.getName()); // create new entry in th report
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}	
	
}
