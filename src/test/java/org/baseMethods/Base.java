package org.baseMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert al;
	
	//1. CONFIGURE Chrome BROWSER 
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
//	//2. CONFIGURE firefox BROWSER 
//		public static void firefox() {
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
//			driver=new FirefoxDriver();
//		}
//		
//	//3. CONFIGURE ie BROWSER 
//		public static void ie() {
//			System.setProperty("webdriver.ie.driver", "C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\driver\\chromedriver.exe");
//			driver=new InternetExplorerDriver();
//		}
		
	//4. Launch url
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	//5. MaxWindow
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	//6. clear
	public static void clear(WebElement element) {
		element.clear();
	}
	
	//7. close the browser
	public static void closeBrowser() {
		driver.close();
	}
	
	//8. close entire browser
	public static void close() {
		driver.quit();
	}
	
	
	//9. print current url
	public static String pageUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	//10. print the title
	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	//11. sendkeys
	public static void fill(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	//11. by id
	public static void findAndSendUsingId(String webElement,String text) {
		WebElement ref = driver.findElement(By.id(webElement));
		ref.sendKeys(text);
	}
	
	//11. by name
		public static void findAndSendUsingName(String name,String text) {
			WebElement ref = driver.findElement(By.name(name));
			ref.sendKeys(text);
		}
		
	//11. by classname
		public static void findAndSendUsingClass(String className,String text) {
			WebElement ref = driver.findElement(By.className(className));
			ref.sendKeys(text);
		}
	
		//11. by tagname
		public static void findAndSendUsingTag(String tagName,String text) {
			WebElement ref = driver.findElement(By.tagName(tagName));
			ref.sendKeys(text);
		}
		
		//11. by xpath
		public static void findAndSendUsingxparh(String path,String text) {
			WebElement ref = driver.findElement(By.xpath(path));
			ref.sendKeys(text);
		}
	
	//12. click the button
	public static void btnClick(WebElement element) {
		element.click();
	}
	
	//find and click button
		public static void findAndClickUsingXpath(String path) {
			WebElement element = driver.findElement(By.xpath(path));
			element.click();
		}
		
	
				
	
	//find and click button
	public static void findAndClick(String id) {
		WebElement element = driver.findElement(By.id(id));
		element.click();
	}
	
	//find and click using pom
		public static void findAndClickPom(WebElement element) {
			element.click();
		}
	
	
	//13. submit button
	public static void submitBtn(WebElement element) {
		element.submit();
	}
	
	//14. print the text
	public static String printText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	//15. print the attribute values
	public static String attribute(WebElement element) {
		String attValue = element.getAttribute("value");
		return attValue;
	}
	//15. print the attribute values
		public static String printAttribute(String id) {
			WebElement element = driver.findElement(By.id(id));
			String attValue = element.getAttribute("value");
			return attValue;
		}
	
	
	
	
	//16. sleep
	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	//17. Actions move to element
	public static void move(WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	//18. Actions drag and drop
	public static void dragDrop(WebElement src,WebElement des) {
		a=new Actions(driver);
		a.dragAndDrop(src, des).build().perform();
		
	}
	
	//19. Actions double click
	public static void doubClick(WebElement element) {
		a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	//20. Actions context click
	public static void rightClick(WebElement element) {
		a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	//21. keysup & keysdown
	public static void UpDown(WebElement element, String text) {
		a=new Actions(driver);
		a.keyDown(element, Keys.SHIFT).sendKeys(text).keyUp(element, Keys.SHIFT).build().perform();
	}
	
	//select by visible text
	public static void selectByVisibleTextPom(WebElement Element,String text) {
			Select s=new Select(Element);
			s.selectByVisibleText(text);
	}	
	//select by visible text
		public static void selectByVisibleText(String id,String text) {
				WebElement loc = driver.findElement(By.id(id));
				Select s=new Select(loc);
				s.selectByVisibleText(text);
		}	
	
	
	//22. ExecuteScript scrollup&down
	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	//23. javascript setAttribute
	public static void setAttributescript(WebElement element, String text) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',text)", element);
	}
	
	//24. javaScript Click
	public static void ClickScript(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	//25. javaScript getAttribute
	public static void getAttributeScript(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", element);
	}
	
	//26. screenshot
	public static void screenshot(String imgName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\screen"+imgName+".png");
		FileUtils.copyFile(src, des);
	}
	
	//27. Alert accept
	public static void alertAccept() {
		al=driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.accept();
	}
	
	//28. alert dismiss
	public static void alertDissmiss() {
		al=driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.dismiss();
	}
	
	//29. alert Sendkeys
	public static void alertSendkeys(String value) {
		al=driver.switchTo().alert();
		al.sendKeys(value);
		String text = al.getText();
		System.out.println(text);
		al.accept();
	}
	
	//frame
	public static void switchToFrame(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		driver.switchTo().frame(element);
	}
//===============================DATA-DRIVEN============================================================	
	//file open
	
		public static Sheet openFile(String name, String sheet) throws IOException {
			File fname=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+name+".xlsx");
			FileInputStream fin=new FileInputStream(fname);
			Workbook w=new XSSFWorkbook(fin);
			Sheet sName = w.getSheet(sheet);
			return sName;
		}
//=================================================================================================		
	//to read all from excel
		public static void readFileAll(String name, String sheet) throws IOException {
			File fname=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+name+".xlsx");
			FileInputStream fin=new FileInputStream(fname);
			Workbook w=new XSSFWorkbook(fin);
			Sheet s = w.getSheet(sheet);
			String value = " ";

			for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {

				Row row2 = s.getRow(i);

				for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {

					Cell allCel = row2.getCell(j);

					int cellType = allCel.getCellType();

					if (cellType == 1) {

						value = allCel.getStringCellValue();

					} else if (DateUtil.isCellDateFormatted(allCel)) {

						Date dateCellValue = allCel.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
						value = sdf.format(dateCellValue);
					} else {
						double numericCellValue = allCel.getNumericCellValue();
						long l = (long) numericCellValue;
						value = String.valueOf(l);
					}

					System.out.println(value);

				}
			}System.out.println("done!!!!!!!!!!!!!");
		}
//============================================================================================			
	//to read single cell value from excel 
	public static String readExcel(String filename,String sheet,int rowNo,int cellNo) throws IOException {
		File fname=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+filename+ ".xlsx");
		FileInputStream fin=new FileInputStream(fname);
		Workbook w=new XSSFWorkbook(fin);
		Sheet sName = w.getSheet(sheet);
		Row row = sName.getRow(rowNo);		
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String value="";
		if (cellType==1) {
			value=cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)){
			Date d = cell.getDateCellValue();
			SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
			value=s.format(d);
			}else {
			double dd = cell.getNumericCellValue();
			long l=(long)dd;
			value=String.valueOf(l);
			}	
		return value;
	}
	
	//implicit waits
	public static void impicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
//====================================================================================
	//New row creation then write
	public static void writeDataNewRow(String fname, String sheet, int createRow, int rowNo, int cellNo, String insertvalue) throws IOException {
		File f=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+fname+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet(sheet);
		s.createRow(createRow);
		s.getRow(rowNo).createCell(cellNo).setCellValue(insertvalue);
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		System.out.println("Done succesfully!!!!!!!");
	}
//=====================================================================================	
	//write in already created row
	public static void writeDataInRow(String fname, String sheet, int rowNo, int cellNo, String insertvalue) throws IOException {
		File f=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+fname+".xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s=w.getSheet(sheet);
		s.getRow(rowNo).createCell(cellNo).setCellValue(insertvalue);
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		System.out.println("Done succesfully!!!!!!!");
	}
//=========================================================================================
	//update particular cell value in excel
	public static void updatevalue(String fname,String sheet, int rowNo,int cellNo,String oldData,String newData) throws IOException {
		File f=new File("C:\\Users\\Hi\\eclipse-workspace\\MavenProject\\Excelnote\\"+fname+".xlsx");
		FileInputStream fin=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fin);
		Sheet s=w.getSheet(sheet);
		Row row = s.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String Value = cell.getStringCellValue();
		if (Value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fout=new FileOutputStream(f);
		w.write(fout);
		System.out.println("updated");
}
	
//start time and end time
	public static void time() {
		Date d=new Date();
		System.out.println(d);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
