package pack1;

import static org.testng.Assert.assertEquals;

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
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

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
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\Config\\OrangeHRM.properties");
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

	public static void getTitle(String data) {
		String getTile = d.getTitle();
		log.debug("Actual Title of the page: " + getTile);
		assertEquals(getTile, data);
	}

	public static void getCurrentURL(String data) {
		String getCurrentURL = d.getCurrentUrl();
		log.debug("Actual Current URL of the page: " + getCurrentURL);
		assertEquals(getCurrentURL, data);
	}

	public static void passInput(String data, String Objectname) {
		d.findElement(By.xpath(pro.getProperty(Objectname))).sendKeys(data);
		log.debug("Input value given for: " + data);
	}

	public static void clickElement(String objectname) {
		
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		log.debug("Clicked the element: " + objectname);
	}

	public static void Dropdown(String data, String objectname) throws InterruptedException {
		
		element = d.findElement(By.xpath(pro.getProperty(objectname)));
		element.click();
		log.debug("DropDown button clicked i.e. "+objectname);
		// Select select = new Select(element);
		// select.selectByVisibleText(data);
		Actions keyDown = new Actions(d);
		keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.ENTER)).build().perform();
		log.debug("Select the DropDown Value from List "+data);

	}

	public static void actionsClick(String objectname) throws InterruptedException {
		Actions action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.moveToElement(element).click().build().perform();
		log.debug("Clicked the element using Actions Techniques i.e.  " + objectname);
		// action.release(element).build().perform();
	}

	public static void actionsInputPass(String data, String objectname) throws InterruptedException, AWTException {
		Actions action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.sendKeys(element, data).build().perform();
		log.debug("Input value passed using Actions Techniques i.e. " + data);
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
		action.keyDown(element, Keys.SHIFT).sendKeys(data).build().perform();
		log.debug("Input value passed along with Keystroke using Actions Techniques i.e. " + data);
		Thread.sleep(2000);
	}

	public static void actionsDragAndDrop(String data, String objectname) {
		Actions action = new Actions(d);
		WebElement source = d.findElement(By.xpath(pro.getProperty(data)));
		WebElement target = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.dragAndDrop(source, target).build().perform();
		log.debug("Element drag and dropped !");
	}

	public static void scrollUpHome() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,-10000)");
		log.debug("ScrollUp till Home");
	}

	public static void scrollDownEnd() {
		JavascriptExecutor js = (JavascriptExecutor) d;
		// js.executeScript("window.scrollBy(0,10000)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		log.debug("ScrollDown till End");
	}

	public static void scrollElement(String objectname) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		js.executeScript("arguments[0].scrollIntoView();", element);
		log.debug("Page Srolled till element");
	}

	public static void newTab() throws InterruptedException {
		((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(1));
		log.debug("Shifted to Next Tab");

		//String MainWindow = d.getWindowHandle();
		//Set<String> s1 = d.getWindowHandles();
		//Iterator<String> i1 = s1.iterator();
		//while (i1.hasNext()) {
			//String ChildWindow = i1.next();
		//if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
			//	d.switchTo().window(ChildWindow);
		//	}
		//}
	}

	@SuppressWarnings("unused")
	public static void jumpTab(String data) {
		try {
			String currentTab = d.getWindowHandle();
			Set<String> verify = d.getWindowHandles();
			int indexValue = Integer.parseInt(data);
			// ((JavascriptExecutor) d).executeScript("window.open();");
			ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
			d.switchTo().window((String) allTab.get(indexValue));
			log.debug("Changed to " + "[" + indexValue + "]" + " Tab");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
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
		try {
			TakesScreenshot shot = ((TakesScreenshot) d);
			File SrcFile = shot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(
					System.getProperty("user.dir") + "\\Screenshots\\Passed Testcases\\Evident_" + timestamp() + ".jpeg");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String timestamp() {
		SimpleDateFormat f = new SimpleDateFormat("HH.mm.ss");
		return f.format(new Date());
	}

	public static void uploadFile() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.debug("File Uploaded");

	}

	public static void submit() {
		d.findElement(By.xpath(pro.getProperty(Objectname))).submit();
		log.debug("Submited the element " + Objectname);

	}
}
