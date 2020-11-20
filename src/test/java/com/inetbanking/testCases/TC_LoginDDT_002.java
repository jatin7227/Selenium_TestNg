package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user ,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("passwd provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		if(isAlertPresent())
		{
			//driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
			logger.warn("login failed");
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("login passed");
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			logger.info(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			logger.info("no popup");
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/Login_Data.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String LoginData[][]=new String[rownum][colcount];
		
		for ( int i =1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				LoginData[i-1][j]=XLUtils.getCellData(path, "Sheet1",i, j);
			}
		}
		return LoginData;
	
	}

}
