package Retailmenot.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import com.functionalComponents.Lib;

import com.functionalComponents.TestSetup;

public class TestCaseFunctions extends TestSetup {

	public TestCaseFunctions(WebDriver driver) {
		TestSetup.driver = driver;

	}

	Lib lib = new Lib(driver);

	public void Browsecoupons(String InputtestcaseName) throws Exception {
		Thread.sleep(2000);
		System.out.println(InputtestcaseName);
		String Link_Value = getExcelTestData("BrowseCoupon", InputtestcaseName,
				"DataInput", "TestData");
		System.out.println(Link_Value);
		String Title_Value = getExcelTestData("ExpectedTitle",
				InputtestcaseName, "DataInput", "TestData");

		lib.objectClick(POMObjects.Browse_coupons, "Browse Coupons");
		if (Link_Value.equals("ProductDeals")) {
			lib.objectClick(POMObjects.Product_deals, "Product Deals");

			Assert.assertEquals(Title_Value, driver.getTitle(),
					"Page title of Product Deals is not matching");

		} else if (Link_Value.equals("GiftCards")) {
			lib.objectClick(POMObjects.Gift_Card_deals, "Gift Card Deals");

			Assert.assertEquals(Title_Value , driver.getTitle(),
			"Page title of Gift Card Deals is not matching");

		} else if (Link_Value.equals("DealSquad")) {
			lib.objectClick(POMObjects.DealSquad, "Deal Squad");
			Assert.assertEquals(Title_Value, driver.getTitle(),
					"Page title of Dealsquad is not matching");
		}

		Thread.sleep(2000);

	}

	public void ProductDeals(String InputtestcaseName) throws Exception {
		Thread.sleep(2000);
		String Product_Value = getExcelTestData("Product Deals",
				InputtestcaseName, "DataInput", "TestData");


		if (Product_Value.equals("Electronics")) {
			lib.objectClick(POMObjects.Electronics, "Electronics");
			Thread.sleep(1000);

			int Count_Items = lib.getElementCount(POMObjects.Count_Electronics,
					"Count of Electronics Items");
			writeRunTimeData(Integer.toString(Count_Items),
					"No.of Search result", InputtestcaseName);
		} else if (Product_Value.equals("Travel")) {
			lib.objectClick(POMObjects.Travel, "Travel");
			int Count_Items = lib.getElementCount(POMObjects.Count_Travel,
					"Count of Travel Items");
			writeRunTimeData(Integer.toString(Count_Items),
					"No.of Search result", InputtestcaseName);
		} else if (Product_Value.equals("Accessories")) {
			lib.objectClick(POMObjects.Accessories, "Accessories");
			int Count_Items = lib.getElementCount(POMObjects.Count_Accessories,
					"Count of Accessories Items");
			writeRunTimeData(Integer.toString(Count_Items),
					"No.of Search result", InputtestcaseName);

		}

		else if (Product_Value.equals("Giftcards")) {
			int Count_Items = lib.getElementCount(POMObjects.Count_giftcards,
					"Count of Giftcards Items");
			writeRunTimeData(Integer.toString(Count_Items),
					"No.of Search result", InputtestcaseName);
		}

		else if (Product_Value.equals("Deals")) {
			int Count_Items = lib.getElementCount(POMObjects.Count_Deals,
					"Count of Deals Items");
			writeRunTimeData(Integer.toString(Count_Items),
					"No.of Search result", InputtestcaseName);
		}

		Thread.sleep(2000);

	}

	public void HomepageClick() throws InterruptedException {
		lib.objectClick(POMObjects.HomePage, "Home Page");
		Thread.sleep(2000);

	}

	public void GetCodeCount(String testcaseName) throws Exception {

		int Count_GC = lib.getElementCount(POMObjects.Count_GetCode,
				"Count of Get Code");
		writeRunTimeData(Integer.toString(Count_GC), "No.Of Get Code",
				testcaseName);

	}

	public void ShopSaleCount(String testcaseName) throws Exception {

		int Count_SC = lib.getElementCount(POMObjects.Count_ShopSale,
				"Count of Shop Sale");
		writeRunTimeData(Integer.toString(Count_SC), "No. of Shop Sale",
				testcaseName);

	}

	
	public void GetCodetextValues(String testcaseName) throws Exception {

		
		
		String winHandleBefore = driver.getWindowHandle();

		lib.objectClick(POMObjects.Getcodeclick, "Get Code");
		// get new window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);

		}
		// To get the Coupon code
		WebElement GetcodeText = driver.findElement(POMObjects.Getcodeoffer);
		String GTxt = GetcodeText.getText();
		System.out.println(GTxt);
		writeRunTimeData(GTxt, "Offer", testcaseName);

		// / To get the Coupon Value//////
		WebElement CouponText = driver.findElement(POMObjects.GetCodecoupon);
		String CTxt = CouponText.getText();
		System.out.println(CTxt);
		writeRunTimeData(CTxt, "Couponcode", testcaseName);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		

	}

}
