package org.task1;

import org.baseMethods.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.IOP.ExceptionDetailMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task1 extends Base {
@BeforeClass
public static void launchBrowser() {
	chrome();
}
@AfterClass
public static void closeBrowser() {
	close();
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
	launchUrl("https://www.facebook.com/");
	maxWindow();
	findAndSendUsingId("email", "java");
	String Attribute = printAttribute("email");
	Assert.assertEquals("valid username", "java", Attribute);
	findAndSendUsingId("pass", "java@123");
	String attr = printAttribute("pass");
	Assert.assertTrue("valid password", attr.contentEquals("java@123"));
	findAndClick("u_0_b");
	sleep();

}







}
