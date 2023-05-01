package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords extends Environment {

	public void openbrowser() {
		// Only Bowser Launch
		d = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		// Browser along with WebDriver
		// d = WebDriverManager.chromedriver().create();
		// d.manage().window().maximize();

	}

	public void navigateURL() {
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		// d.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		d.get("https://opensource-demo.orangehrmlive.com/");
	}

	public void getTitle() {
		System.out.println("Title of the page is " + d.getTitle());

	}

	public void getCurrentURL() {
		System.out.println("Current URL is " + d.getCurrentUrl());

	}

	public void Input(String data, String Objectname) throws IOException, InterruptedException {

		file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		d.findElement(By.xpath(pro.getProperty(Objectname))).sendKeys(data);
		Thread.sleep(2000);
	}

	public void click(String objectname) throws IOException, InterruptedException {
		file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Properties\\OrangeHRM.properties");
		pro = new Properties();
		pro.load(file);
		System.out.println(objectname);
		System.out.println(pro.getProperty(objectname));
		d.findElement(By.xpath(pro.getProperty(objectname))).click();
		Thread.sleep(2000);
	}

	public void close() throws InterruptedException {
		Thread.sleep(2000);
		d.close();

	}

	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		d.quit();
		

	}

}
