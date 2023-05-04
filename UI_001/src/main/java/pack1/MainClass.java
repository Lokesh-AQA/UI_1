package pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public static void browserOptions(String data) {
		if (data.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
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

	public static void captureScreen() throws IOException {
		Shot = ((TakesScreenshot) d);
		SrcFile = Shot.getScreenshotAs(OutputType.FILE);
		DestFile = new File(
				System.getProperty("user.dir") + "\\Screenshots\\Passed Testcases\\Evident_" + timestamp() + ".jpeg");
		FileUtils.copyFile(SrcFile, DestFile);
		// log.debug("Screenshots Taken");

	}

	private static String timestamp() {
		SimpleDateFormat f = new SimpleDateFormat("HH.mm.ss");
		return f.format(new Date());
	}

	public static void navigateURL(String data) {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		// d.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		long starttime = System.currentTimeMillis();
		d.get(data);
		long endtime = System.currentTimeMillis();
		long totaltime = endtime - starttime;
		log.debug("TimeTaken for URL Launched--" + totaltime + " milliseconds");
		log.debug("Navigate URL: " + data);

	}

	public static void loadPropertyFile() throws IOException {
		file = new FileInputStream(System.getProperty("user.dir") + "\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		
	}

	public static void passInput(String data, String Objectname) throws InterruptedException {
		d.findElement(By.xpath(pro.getProperty(Objectname))).sendKeys(data);
		log.debug("Input value given for: " + Objectname);
		Thread.sleep(1500);
	}

	public static void clickElement(String objectname) throws InterruptedException {
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		log.debug("Clicked the element: " + objectname);
		Thread.sleep(1500);
		
	}

	public static void robotClass() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    log.debug("File Uploaded");
		
	}

	public static void mouseClick(String objectname) {
		action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.moveToElement(element).click().build().perform();
		log.debug("Mouse Over on the partcular element i.e." + objectname);

	}

	public static void newTab() {
		((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(1));
		log.debug("Shifted to Next Tab");
		
	}

	public static void copydata(String data) {
		// TODO Auto-generated method stub
		toolkit = Toolkit.getDefaultToolkit();
		clipboard = toolkit.getSystemClipboard();
		strStore = new StringSelection(data);
		clipboard.setContents(strStore, null);
		log.debug("Copied the Data in Clipboard i.e." + data);
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

	public static void selectDropdown(String data, String objectname) {
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		Select select = new Select(element);
		select.selectByVisibleText(data);
		
	}

	public static void getTitle() {
		String getTile = d.getTitle();
		log.debug("Get Title of the page:" + getTile );
		
	}

	public static void getCurrentURL() {
		String getCurrentURL = d.getCurrentUrl();
		log.debug("Get Current URL of the page:" + getCurrentURL);
		
	}
}
