package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		d.get(data);
		log.debug("Navigate URL: " + data);
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
		Thread.sleep(2000);
		Screenshot.capture();
	}

	public void click(String objectname) throws IOException, InterruptedException {
		file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		log.debug("Clicked the element: " + objectname);
		Thread.sleep(2000);
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
	   //d.findElement(By.xpath(pro.getProperty(objectname))).click();
	   //Thread.sleep(1000);
	   WebElement element =d.findElement(By.xpath(pro.getProperty(objectname)));
       Select select= new Select(element);
       select.selectByVisibleText(data);
       Screenshot.capture();
	}

}
