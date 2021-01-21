package org.task6;

import org.baseMethods.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoSelectHotel extends Base {
	public PojoSelectHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement radio;
	
	@FindBy(id="continue")
	private WebElement click;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getClick() {
		return click;
	}
	
}
