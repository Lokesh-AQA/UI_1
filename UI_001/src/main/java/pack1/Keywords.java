package pack1;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Keywords extends Environment {

	public void invokebrowser(String data) {
		try {
			MainClass.browserOptions(data);
			d.manage().window().maximize();
			d.manage().deleteAllCookies();
			log.debug("Browser Opened");
		} catch (Exception e) {
			log.error("Fail,unable to launch browser: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void navigateURL(String data) throws IOException {
		try {
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			// d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			// d.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
			MainClass.navigateURL(data);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to navigate URL: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getTitle() {
		try {
			Thread.sleep(100);
			MainClass.getTitle();
		} catch (Exception e) {
			log.error("Fail,unable to GetTitle from page");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getCurrentURL() {
		try {
			Thread.sleep(100);
			MainClass.getCurrentURL();
		} catch (Exception e) {
			log.error("Fail,unable to GetCurrentURL from page");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void Input(String data, String Objectname) throws IOException, InterruptedException {
		try {
			MainClass.loadPropertyFile();
			Thread.sleep(1000);
			MainClass.passInput(data, Objectname);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to pass input value: " + Objectname);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void click(String objectname) throws IOException, InterruptedException {
		try {
			MainClass.loadPropertyFile();
			Thread.sleep(1000);
			MainClass.clickElement(objectname);
			Thread.sleep(1000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to click the element: " + objectname);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void dropdown(String data, String objectname) throws InterruptedException, IOException {
		try {
			MainClass.loadPropertyFile();
			Thread.sleep(1000);
			MainClass.selectDropdown(data, objectname);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to perform Dropdown field: " + objectname);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void actionsClick(String objectname) {
		try {
			MainClass.loadPropertyFile();
			Thread.sleep(500);
			MainClass.actionsClick(objectname);
			Thread.sleep(500);
		} catch (Exception e) {
			log.error("Fail,unable to perform Mouse Click: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void actionsInputPass(String data, String objectname)
			throws IOException, InterruptedException, AWTException {
		Thread.sleep(500);
		MainClass.loadPropertyFile();
		MainClass.actionsInputPass(data, objectname);
	}

	public void Newtab() throws InterruptedException, IOException {
		try {
			Thread.sleep(500);
			MainClass.newTab();
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to open New Tab");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void Jumbtab(String data) throws IOException, InterruptedException {
		try {
			Thread.sleep(2000);
			MainClass.jumpTab(data);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Jump Tab: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollDownEnd(String data, String objectname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,10000)");
			log.debug("ScrollDown till End");
			Thread.sleep(1000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Scrolldown till END");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollUpHome(String data, String objectname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,-10000)");
			log.debug("ScrollUp till Home");
			Thread.sleep(1000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Scrollup till HOME");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void copyContent(String data) throws InterruptedException {
		try {
			Thread.sleep(1000);
			MainClass.copydata(data);
		} catch (Exception e) {
			log.error("Fail,unable to Copy data: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void fileUpload() throws IOException, AWTException, InterruptedException {
		try {
			Thread.sleep(1000);
			MainClass.robotClass();
			Thread.sleep(2000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to perform RobotClass: Fileupload");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void close() throws InterruptedException {
		try {
			Thread.sleep(2000);
			d.close();
			log.debug("Close the browser");
		} catch (Exception e) {
			log.error("Fail,unable to Close windows");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void quit() throws InterruptedException {
		try {
			Thread.sleep(2000);
			d.quit();
			log.debug("Quit all the browser");
		} catch (Exception e) {
			log.error("Fail,unable to Quit windows");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
