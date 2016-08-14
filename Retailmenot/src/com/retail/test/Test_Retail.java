package com.retail.test;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Retailmenot.pageobjects.TestCaseFunctions;

import com.functionalComponents.TestDatainput;
import com.functionalComponents.TestSetup;

public class Test_Retail extends TestSetup {
	
	
	TestCaseFunctions Testcaseretail=new TestCaseFunctions(driver);
	TestDatainput Readvalue = new TestDatainput();
	
	@Test(description="")
	 public void testRetailmenot(ITestContext ctx) throws Exception
		{
		
				
		
		for(int rowvalue =1 ; rowvalue<=6; rowvalue++)
		{
		String Testcase_value = Readvalue.ReadCell(0, rowvalue);
		
		System.out.println(Testcase_value);
		ctx.getCurrentXmlTest().addParameter("TestCaseName",Testcase_value);
		
		
       Testcaseretail.Browsecoupons(Testcase_value);
	   Testcaseretail.ProductDeals(Testcase_value);
		
		Testcaseretail.HomepageClick();
		if(Testcase_value.toLowerCase().contains("squad")) {}
		else {
		Testcaseretail.GetCodeCount(Testcase_value);
		
		Testcaseretail.ShopSaleCount(Testcase_value);
		
		Testcaseretail.GetCodetextValues(Testcase_value);
		}
		}
	//	Testcaseretail.Browsecoupons("GIftCardDeals");
		//Testcaseretail.ProductDeals("GIftCardDeals");
		
		}

}
