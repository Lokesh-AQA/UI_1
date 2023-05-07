package pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MainClass extends Environment {

	public static void dataIndexValue(int i) {
		keyword = (String) a.get(i);
		// System.out.println("Keyword is "+keyword);
		data = (String) a.get(i + 1);
		// System.out.println("Testdata is "+testdata);
		Objectname = (String) a.get(i + 2);
		// System.out.println("ObjectName is "+Objectname);
		runmode = (String) a.get(i + 3);
		// System.out.println("Runmode is "+runmode);
	}

	public static void loadPropertyFile() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
	}
	
	public static void browserOptions(String data) {
		if (data.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			d = new ChromeDriver(options);
			// Browser along with WebDriver
			// d = WebDriverManager.chromedriver().create();
			// d.manage().window().maximize();
		}
		if (data.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			d = new FirefoxDriver(options);
		}
		if (data.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--incognito");
			d = new EdgeDriver(options);
		}
	}
	
	public static void navigateURL(String data) {
		long starttime = System.currentTimeMillis();
		d.get(data);
		long endtime = System.currentTimeMillis();
		long totaltime = endtime - starttime;
		log.debug("Navigate URL: " + data);
		log.debug("TimeTaken for URL Launched: " + totaltime + " milliseconds");
	}
	public static void getTitle() {
		String getTile = d.getTitle();
		log.debug("Get Title of the page: " + getTile);
	}

	public static void getCurrentURL() {
		String getCurrentURL = d.getCurrentUrl();
		log.debug("Get Current URL of the page: " + getCurrentURL);
	}
	
	public static void passInput(String data, String Objectname) {
		d.findElement(By.xpath(pro.getProperty(Objectname))).sendKeys(data);
		log.debug("Input value given for: " + Objectname);
	}
	
	public static void clickElement(String objectname) {
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		log.debug("Clicked the element: " + objectname);
	}
	
	public static void selectDropdown(String data, String objectname) throws InterruptedException {
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}
	
	public static void actionsClick(String objectname) throws InterruptedException {
		Actions action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.moveToElement(element).click().build().perform();
		log.debug("Clicked the element using Actions Techniques i.e.  " + objectname);
	}
	public static void actionsInputPass(String data, String objectname) throws InterruptedException, AWTException {
		Actions action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.sendKeys(element, data).build().perform();
		log.debug("Input value passed using Actions Techniques i.e. "+data);
		Thread.sleep(1000);
		action.moveToElement(element).doubleClick().build().perform();
		log.debug("Double Click performed using Actions Techniques");
		Thread.sleep(1000);
		action.contextClick(element).build().perform();
		log.debug("Context Click or Right Click performed using Actions Techniques");
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(1000);
		element.sendKeys(Keys.DELETE); // Key Delete to delete the selected input value
		Thread.sleep(1000);
		action.keyDown(element,Keys.SHIFT).sendKeys(data).build().perform();
		log.debug("Input value passed along with Keystroke using Actions Techniques i.e. "+data);
		Thread.sleep(2000);
	}
	
	public static void newTab() throws InterruptedException {
		((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(1));
		log.debug("Shifted to Next Tab");
	}
	
	@SuppressWarnings("unused")
	public static void jumpTab(String data) {
		String oldTab = d.getWindowHandle();
		int indexValue = Integer.parseInt(data);
		// ((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(indexValue));
		log.debug("Changed to " + "[" + indexValue + "]" + " Tab");
	}
	
	public static void copydata(String data) throws InterruptedException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strStore = new StringSelection(data);
		clipboard.setContents(strStore, null);
		log.debug("Copied the Data in Clipboard i.e." + data);
		Thread.sleep(1000);
	}
	
	public static void captureScreen() throws IOException {
		TakesScreenshot shot = ((TakesScreenshot) d);
		File SrcFile = shot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + "\\Screenshots\\Passed Testcases\\Evident_" + timestamp() + ".jpeg");
		FileUtils.copyFile(SrcFile, DestFile);
	}

	public static String timestamp() {
		SimpleDateFormat f = new SimpleDateFormat("HH.mm.ss");
		return f.format(new Date());
	}
	
	public static void robotClass() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.debug("File Uploaded");
	}
}
