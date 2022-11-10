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
public class SearchResultPage extends BaseClass {
	
	@FindBy(linkText = "Women's Classic-Fit Short-Sleeve Crewneck T-Shirt, Multipacks")
	WebElement item;
	
	public SearchResultPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public AddToCartPage openitem() {
		item.click();
		return new AddToCartPage();
	}
	
	
	
	
	

}
