package Retailmenot.pageobjects;
import org.openqa.selenium.By;

public class POMObjects {
	

	
	 //------------------Browse Coupon--------------------------
		
	  public static	By Browse_coupons=By.xpath(".//*[@id='menu']/li[1]/a");
	  public static	By Product_deals=By.xpath(".//*[@id='menu']/li[1]/ul/li[2]/a");
	  public static	By Gift_Card_deals=By.xpath(".//*[@id='menu']/li[1]/ul/li[3]/a");
	  public static	By DealSquad=By.xpath(".//*[@id='menu']/li[1]/ul/li[4]/a");
	  
	  
	  //------------------Jump to Product Deals--------------------------
		
	  public static	By Electronics=By.xpath(".//*[@id='site-main']/header/div/nav/a[7]");
	  public static	By Travel=By.xpath(".//*[@id='site-main']/header/div/nav/a[2]");
	  public static	By Accessories=By.xpath(".//*[@id='site-main']/header/div/nav/a[5]");
	  public static	By Count_Electronics=By.xpath("//section[contains(@id,'Electronics')]//div[starts-with(@id,'P')]");
	  public static	By Count_Travel=By.xpath("//section[contains(@id,'Travel')]//div[starts-with(@id,'P')]");
	  public static	By Count_Accessories=By.xpath("//section[contains(@id,'Accessories')]//div[starts-with(@id,'P')]");
	  public static	By Count_Deals=By.xpath("//section[contains(@id,'deals')]//div[starts-with(@id,'P')]");
	  public static	By Count_giftcards=By.xpath("//section[contains(@id,'giftcards')]//div[starts-with(@id,'P')]");
	  
	//------------------ Home Page--------------------------
	  public static	By HomePage=By.xpath(".//*[@id='logo']/picture");
	  public static	By Count_GetCode=By.xpath("//div[contains(@class,'js-coupon-square-cta js-triggers')][contains(text(),'Get Code')]");
	  public static	By Count_ShopSale=By.xpath("//div[contains(@class,'js-coupon-square-cta js-triggers')][contains(text(),'Shop Sale')]");
	  
	  
	  //...................Get Code......................................
	  public static	By Getcodeclick=By.xpath("//div[contains(@class,'js-coupon-square-cta js-triggers')][contains(text(),'Get Code')]");
	  public static	By Productinfo=By.xpath(".//*[@id='_pages/home']/div[5]/div/div/div[1]/div[1]/div/div[1]/p/img')]");
	  public static	By Getcodeoffer=By.xpath(".//*[@id='_pages/home']/div[1]/div/div/div[1]/p[2]");
	  public static	By GetCodecoupon=By.xpath(".//*[@id='_pages/home']/div[1]/div/div/div[2]/div[2]/div[3]");
	  
}
