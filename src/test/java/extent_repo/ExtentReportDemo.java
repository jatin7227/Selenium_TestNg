package extent_repo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	
	@Test
	public void logintest()
	{
		System.out.println("login to amazon");
		
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Screenshots/lear.html");
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest logger=extent.createTest("logintest");
		logger.log(Status.INFO, "login");
		logger.log(Status.PASS, "title");
		extent.flush();
		
	}

}
