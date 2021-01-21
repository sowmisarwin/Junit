package org.task7and8;

import org.baseMethods.Base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoBookingConfirm extends Base{
	public PojoBookingConfirm() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_hotel")
	private WebElement pageDown;

	@FindBy(id="order_no")
	private WebElement orderNo;
	
	@FindBy(id="logout")
	private WebElement logout;

	

	public WebElement getPageDown() {
		return pageDown;
	}

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getLogout() {
		return logout;
	}
	
}
