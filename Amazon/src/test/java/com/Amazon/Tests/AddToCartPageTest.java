/**
 * 
 */
package com.Amazon.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObjects.AddToCartPage;
import com.Amazon.PageObjects.IndexPage;
import com.Amazon.PageObjects.SearchResultPage;
import com.Amazon.utility.Log;

/**
 * @author harik
 *
 */
public class AddToCartPageTest extends BaseClass{

	
	IndexPage indexpage;
	SearchResultPage searchresultpage;
	AddToCartPage addtocartpage;
	
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void setup() throws InterruptedException {
		launch();
	}
	@Test(groups = "Smoke")
	public void VerifyAddItemToCart() throws InterruptedException {
		indexpage = new IndexPage();
		Log.startTestCase("VerifyAddItemToCart");
		Log.info("searching for t-shirts");
		searchresultpage = indexpage.searchitem("tshirts");
		Log.info("opening item");
		addtocartpage = searchresultpage.openitem();
		Log.info("selecting size");
		//addtocartpage.selectsize(" Medium ");
		addtocartpage.selectsize(" M ");
		Log.info("selecting quantity");
		addtocartpage.selectquantity();
		Log.info("adding to cart");
		addtocartpage.addToCart();
		Log.endTestCase("VerifyAddItemToCart");
		 
	}
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void close() {
		getdriver().close();
	}
	
	
}
