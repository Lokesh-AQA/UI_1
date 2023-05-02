package pack1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords extends Environment {

	public void invokebrowser() {
		// Only Bowser Launch
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--incognito");
		d = new ChromeDriver(options);
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		log.debug("Browser Opened");
		// Browser along with WebDriver
		// d = WebDriverManager.chromedriver().create();
		// d.manage().window().maximize();

	}

	public void navigateURL(String data) throws IOException {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		// d.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		long starttime = System.currentTimeMillis();
		d.get(data);
		long endtime = System.currentTimeMillis();
		long totaltime = endtime - starttime;
		log.debug("Navigate URL: " + data);
		log.debug("TimeTaken for URL Launched--" + totaltime + " milliseconds");
		Screenshot.capture();
	}

	public void getTitle() {
		log.debug("Get Title of the page:" + d.getTitle());

	}

	public void getCurrentURL() {
		log.debug("Get Current URL of the page:" + d.getCurrentUrl());

	}

	public void Input(String data, String Objectname) throws IOException, InterruptedException {

		file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		d.findElement(By.xpath(pro.getProperty(Objectname))).sendKeys(data);
		log.debug("Input value given for: " + Objectname);
		Thread.sleep(1500);
		Screenshot.capture();
	}

	public void click(String objectname) throws IOException, InterruptedException {
		file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		log.debug("Clicked the element: " + objectname);
		Thread.sleep(1500);
		Screenshot.capture();
	}

	public void close() throws InterruptedException {
		Thread.sleep(2000);
		d.close();
		log.debug("Close the browser");

	}

	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		d.quit();
		log.debug("Quit all the browser");

	}

	public void dropdown(String data, String objectname) throws InterruptedException, IOException {
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		// Thread.sleep(1000);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		Select select = new Select(element);
		select.selectByVisibleText(data);
		Screenshot.capture();
	}

	public void scrollDownEnd(String data, String objectname) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,10000)");
		log.debug("ScrollDown till End");
		Screenshot.capture();

	}

	public void scrollUpHome(String data, String objectname) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,-10000)");
		log.debug("ScrollUp till Home");
		Screenshot.capture();

	}

	public void Jumbtab(String data) throws IOException, InterruptedException {
		Thread.sleep(1000);
		String oldTab = d.getWindowHandle();
		int indexValue=Integer.parseInt(data);  
		//((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(indexValue));
		Screenshot.capture();
		log.debug("Shifted to Next Tab");

	}

	public void copyContent(String data) throws InterruptedException {
		toolkit = Toolkit.getDefaultToolkit();
		clipboard = toolkit.getSystemClipboard();
		strStore = new StringSelection(data);
		clipboard.setContents(strStore, null);
		log.debug("Copied the Data in Clipboard i.e." + data);
		Thread.sleep(1000);

	}

	public void fileUpload() throws IOException, AWTException, InterruptedException {
		robot = new Robot();
		Thread.sleep(3000);
		//robot.keyPress(KeyEvent.VK_TAB);
		//robot.keyRelease(KeyEvent.VK_TAB);
		//robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		log.debug("Windows Application Closed");
		Screenshot.capture();
		log.debug("File Uploaded");

	}

	public void mouseClick(String objectname) {
		action = new Actions(d);
		WebElement element = d.findElement(By.xpath(pro.getProperty(objectname)));
		action.moveToElement(element).click().build().perform();
		log.debug("Mouse Over on the partcular element i.e."+objectname);
		
	}

	public void Newtab() throws InterruptedException, IOException {
		Thread.sleep(1000);
		((JavascriptExecutor) d).executeScript("window.open();");
		ArrayList<String> allTab = new ArrayList<String>(d.getWindowHandles());
		d.switchTo().window((String) allTab.get(1));
		Screenshot.capture();
		log.debug("Shifted to Next Tab");
		
	}

}
