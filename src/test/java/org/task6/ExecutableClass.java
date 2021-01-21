package org.task6;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.baseMethods.Base;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutableClass extends Base {
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
	public void adactin() throws AWTException {
		launchUrl("http://www.adactin.com/HotelApp/");
		maxWindow();
		PojoAdactinLogin p1=new PojoAdactinLogin();
		fill(p1.getTxtUser(), "sowntharya");
		fill(p1.getPassword(), "sss*123");
		btnClick(p1.getLogin());
		impicitWait();

		PojoSearchHotel p2=new PojoSearchHotel();
		selectByVisibleTextPom(p2.getLocation(),"Sydney");
		selectByVisibleTextPom(p2.getHotel(), "Hotel Sunshine");
		selectByVisibleTextPom(p2.getRoomType(), "Super Deluxe");
		selectByVisibleTextPom(p2.getRoomNo(), "1 - One");
		
		selectByVisibleTextPom(p2.getAdultRoom(), "2 - Two");
		selectByVisibleTextPom(p2.getChildroom(), "1 - One");
		findAndClickPom(p2.getSubmit());
		impicitWait();
		
		PojoSelectHotel p3=new PojoSelectHotel();
		findAndClickPom(p3.getRadio());
		findAndClickPom(p3.getClick());
		impicitWait();
		
		PojoBookHotel p4=new PojoBookHotel();
		fill(p4.getFirstName(), "Sowmi");
		fill(p4.getLastName(), "sarwin");
		fill(p4.getAddress(), "chennai");
		fill(p4.getCcNum(),"1234567890123456");
		selectByVisibleTextPom(p4.getCcType(), "VISA");
		selectByVisibleTextPom(p4.getExpMonth(), "February");
		selectByVisibleTextPom(p4.getExpYear(), "2021");
		fill(p4.getCvv(), "123");
		findAndClickPom(p4.getBooknw());
		impicitWait();
		
		PojoBookingConfirm pb=new PojoBookingConfirm();
		scrollIntoView(pb.getPageDown());
		impicitWait();
		String attribute = attribute(pb.getOrderNo());
		System.out.println("order no."+attribute);
		

	}
	
	
}
