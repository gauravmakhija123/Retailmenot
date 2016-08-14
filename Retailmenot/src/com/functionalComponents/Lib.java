package com.functionalComponents;


	import com.functionalComponents.Report;

	import com.google.common.base.Function;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;

	public class Lib extends TestSetup {
	    public Lib(WebDriver driver) {
	        TestSetup.driver = driver;
	    }

	    public void navigateToURL(String url, String referenceName) throws Exception {
	        driver.navigate().to(url);
	        Assert.assertEquals((String)driver.getCurrentUrl(), (String)url, (String)("user not navigated to " + referenceName + ": " + url));
	    }



	    public void waitForElementPresent(WebDriver driver, By by) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until((Function)ExpectedConditions.presenceOfElementLocated((By)by));
	    }

	    public void waitForElementVisible(WebDriver driver, By by) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, 60);
	        wait.until((Function)ExpectedConditions.visibilityOfElementLocated((By)by));
	    }

	    public int getElementCount(By by, String objLogicalName) throws Exception {
	        int size = 0;
	        size = driver.findElements(by).size();
	        	        return size;
	    }

	    public void objectClick(By by, String objLogicalName) {
	        WebElement webElement = driver.findElement(by);
	        webElement.click();
	        Report.getMessage(String.valueOf(objLogicalName) + " is clicked ");
	    }

	   

	    public String getText(By by, String objlogicalname) throws Exception {
	        String txt = driver.findElement(by).getText();
	        return txt;
	    }
	}
	