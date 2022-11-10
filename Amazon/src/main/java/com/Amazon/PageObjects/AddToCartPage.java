/**
 * 
 */
package com.Amazon.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Amazon.Base.BaseClass;

/**
 * @author harik
 *
 */
public class AddToCartPage extends BaseClass {
	
	@FindBy(xpath = "//span[@id='a-autoid-54-announce']")
	WebElement quantity;
	
	@FindAll({@FindBy(xpath = "//div[@class='a-popover-wrapper']//ul//li")})
	List<WebElement> Quantitylist;
	
	
	@FindBy(xpath = "//select[@id='native_dropdown_selected_size_name']")
	WebElement Size;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addtocartbutton;
	
	public AddToCartPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public void addToCart() {
		addtocartbutton.click();
	}
	
	public void selectsize(String itemsize) throws InterruptedException {
		//Size.click();
		Select s = new Select(Size);
		Thread.sleep(2000);
		s.selectByVisibleText(itemsize);
		Thread.sleep(2000);
	}
	
	public void selectquantity() throws InterruptedException {
		System.out.println("in quantity");
		Thread.sleep(4000);
		for(WebElement x:Quantitylist) {
			System.out.println(x);
			System.out.println("x");
		}
		System.out.println("111");
		
	}
	
	

}
