package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass{
	
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("Submitted data");
		Thread.sleep(5000);
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue("true one", true);
			logger.info("tc pass");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue("false one", false);
			logger.info("tc fail");
		}
	}

}
