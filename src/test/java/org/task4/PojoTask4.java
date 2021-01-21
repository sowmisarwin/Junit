package org.task4;

import org.baseMethods.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoTask4 extends Base {
	public PojoTask4() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement txtemail;

	@FindBy(xpath="//input[@type='password']")
	private WebElement txtpass;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement btnlog;

	public WebElement getBtnlog() {
		return btnlog;
	}

	public WebElement getTxtemail() {
		return txtemail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}
	
}
