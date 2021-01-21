package org.task2;

import java.util.Scanner;

import org.baseMethods.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 extends Base {
@BeforeClass
public static void launchBrowser() {
	chrome();
}
@AfterClass
public static void closeBrowser() {
	//close();
}
@Before
public  void startTime() {
	time();
}
@After
public  void endTime() {
	time();
}
@Test
public void login() throws InterruptedException {
	launchUrl("https://www.redbus.in/");
	maxWindow();
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	findAndClick("sign-in-icon-down");
	findAndClick("signInLink");
	switchToFrame("//iframe[@class='modalIframe']");
	findAndClick("mobileNoInp");
	WebElement mobno = driver.findElement(By.id("mobileNoInp"));
	fill(mobno, "9894803890");
	switchToFrame("//iframe[@name='a-fmw2dcgw4gr0']");
	findAndClickUsingXpath("(//div[@class='recaptcha-checkbox-border'])[2]");
	findAndClickUsingXpath("//span[@class='f-w-b']");
	
}
}
