/**
 * 
 */
package com.Amazon.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObjects.IndexPage;
import com.Amazon.PageObjects.SearchResultPage;

/**
 * @author harik
 *
 */
public class SearchResultPageTest  extends BaseClass{
	IndexPage indexpage;
	SearchResultPage searchresultapge;
	
	@BeforeMethod(groups = {"Smoke", "Regression"})
	public void setup() throws InterruptedException {
		launch();
	}
	
	@Test(groups =  "Regression")
	public void verifyopenitem() {
		indexpage = new IndexPage();
		searchresultapge = indexpage.searchitem("tshirts");
		searchresultapge.openitem();
	}
	
	@AfterMethod(groups = {"Smoke", "Regression"})
	public void close() {
		getdriver().close();
	}

}
