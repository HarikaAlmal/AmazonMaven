/**
 * 
 */
package com.Amazon.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;

/**
 * @author harik
 *
 */
public class IndexPage extends BaseClass {
	
//elements	
	@FindBy(id = "twotabsearchtextbox")
	WebElement Searchbox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement Searchbutton;
	
	@FindBy(id = "nav-link-accountList")
	WebElement Signintab;
	
//initialize	
	public IndexPage() {
		PageFactory.initElements(getdriver(), this);
		
	}
	
//actions
	public SearchResultPage searchitem(String itemtosearch) {
		Searchbox.sendKeys(itemtosearch);
		Searchbutton.click();
		return new SearchResultPage();
	}
	
	public SigninPage signin() {
		Signintab.click();
		return new SigninPage();
	}
	
	

}
