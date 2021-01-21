package org.task4;

import java.util.concurrent.TimeUnit;

import org.baseMethods.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Task4 extends Base {
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
	launchUrl("https://www.flipkart.com/account/login");
	maxWindow();
	PojoTask4 p=new PojoTask4();
	fill(p.getTxtemail(), "sowmimca9297@gmail.com");
	String actualValue = attribute(p.getTxtemail());
	Assert.assertEquals("check the email", "sowmimca9297@gmail.com", actualValue);
	fill(p.getTxtpass(), "sowmi*9297");
	btnClick(p.getBtnlog());
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Thread.sleep(5000);
	String title = driver.getTitle();
	System.out.println(title);
	if (title.contains("Online Shopping Site")) {
		System.out.println("input data is correct");
	} else {
		System.out.println("input data is not correct");
	}

}
}