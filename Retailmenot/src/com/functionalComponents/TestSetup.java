package com.functionalComponents;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.seleniumhq.jetty7.util.log.Log;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class TestSetup {

	public static WebDriver driver;
	public String root = System.getProperty("user.dir");

	TestDatainput testEnableDisable = new TestDatainput();
	TestDatainput testData = new TestDatainput();
	TestDatainput testDataCommon = new TestDatainput();

	String BROWSER_NAME = getCommonTestData("Value", "Browser");
	String BROWSER_PATH = getCommonTestData("Value", "Browser Path");
	String APP_URL1 = getCommonTestData("Value", "Application URL");

	@BeforeTest
	public void launchURL() throws Exception {
		if (BROWSER_NAME.equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", BROWSER_PATH);
			driver = new ChromeDriver();

		} else if (BROWSER_NAME.equals("Firefox")) {
			System.setProperty("webdriver.firefox.bin", BROWSER_PATH);
			driver = new FirefoxDriver();
		} else if (BROWSER_NAME.equals("IE")) {
			// System.setProperty("webdriver.IE.driver", BROWSER_PATH);
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
			// true);
			capabilities.setCapability("nativeEvents", false);
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			capabilities.setCapability("ignoreProtectedModeSettings", true);
			capabilities.setCapability("disable-popup-blocking", true);
			capabilities.setCapability("enablePersistentHover", true);
			System.setProperty("webdriver.ie.driver", BROWSER_PATH);
			driver = new InternetExplorerDriver(capabilities);
		}
		driver.manage().deleteAllCookies();
		driver.get(APP_URL1);
		driver.manage().window().maximize();

	}

	

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	public String getCommonTestData(String colName, String rowName) {
		try {
			testDataCommon.customizedTestDataDriver(root
					+ "//test-data//DataInput.xls", "TestDataCommon");

			testDataCommon.ColumnDictionary();

			testDataCommon.RowDictionary();
		} catch (Exception localException) {
		}

		String testDataCommonValue = testDataCommon.ReadCell(
				testDataCommon.GetCol(colName), testDataCommon.GetRow(rowName));
		return testDataCommonValue;
	}

	// ------------------------------**************--------------------------------

	@SuppressWarnings({ "resource", "deprecation" })
	public void writeRunTimeData(String Data1, String colName, String rowName)
			throws Exception {

		try {

			FileInputStream file = new FileInputStream(new File(
					"test-data//TestResults.xls"));
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			testData.customizedTestDataDriver(root
					+ "//test-data//TestResults.xls", "TestStatus");
			testData.ColumnDictionary();
			testData.RowDictionary();

			HSSFSheet sheet = workbook.getSheet("TestStatus");
			HSSFRow row = sheet.getRow(testData.GetRow(rowName));
			Cell cell = (Cell) row.createCell((short) testData.GetCol(colName));

			if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				cell.setCellType(Cell.CELL_TYPE_STRING);
				cell.setCellValue((String) Data1);
			} else {
				cell.setCellValue((String) Data1);
			}

			file.close();
			FileOutputStream outFile = new FileOutputStream(new File(
					"test-data//TestResults.xls"));

			workbook.write(outFile);

			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (HeadlessException e) {
			e.printStackTrace();
		}

	}

	public String getTestData(String colName, String rowName, String Sheet) {
		try {
			this.testDataCommon.customizedTestDataDriver(this.root
					+ "//test-data//DataInput.xls", Sheet);

			this.testDataCommon.ColumnDictionary();

			this.testDataCommon.RowDictionary();
		} catch (Exception localException) {
		}
		String testDataCommonValue = this.testDataCommon.ReadCell(
				this.testDataCommon.GetCol(colName),
				this.testDataCommon.GetRow(rowName));
		return testDataCommonValue;
	}

	public String getExcelTestData(String colName, String rowName,
			String excelFileName, String Sheet) {
		try {
			this.testDataCommon.customizedTestDataDriver(this.root
					+ "//test-data//" + excelFileName + ".xls", Sheet); // --"//test-data//DataInput.xls"

			this.testDataCommon.ColumnDictionary();

			this.testDataCommon.RowDictionary();
		} catch (Exception localException) {
		}
		String testDataCommonValue = this.testDataCommon.ReadCell(
				this.testDataCommon.GetCol(colName),
				this.testDataCommon.GetRow(rowName));
		return testDataCommonValue;
	}

}
