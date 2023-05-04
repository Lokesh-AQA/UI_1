package pack1;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Keywords extends Environment {

	public void invokebrowser(String data) {
		// Only Bowser Launch
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
			Thread.sleep(500);
			MainClass.getTitle();
		} catch (Exception e) {
			log.error("Fail,unable to GetTitle from page");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getCurrentURL() {
		try {
			Thread.sleep(500);
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
			MainClass.clickElement(objectname);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to click the element: " + objectname);
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

	public void dropdown(String data, String objectname) throws InterruptedException, IOException {
		try {
			MainClass.selectDropdown(data, objectname);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to perform Dropdown field: " + objectname);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollDownEnd(String data, String objectname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,10000)");
			log.debug("ScrollDown till End");
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
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Scrollup till HOME");
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

	public void copyContent(String data) throws InterruptedException {
		try {
			Thread.sleep(500);
			MainClass.copydata(data);
		} catch (Exception e) {
			log.error("Fail,unable to Copy data: " + data);
			e.printStackTrace();
		}
	}

	public void fileUpload() throws IOException, AWTException, InterruptedException {
		try {
			MainClass.robotClass();
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to perform RobotClass: Fileupload");
			e.printStackTrace();
		}
	}

	public void mouseClick(String objectname) {
		try {
			Thread.sleep(1000);
			MainClass.mouseClick(objectname);
		} catch (Exception e) {
			log.error("Fail,unable to perform Mouse Click: " + data);
			e.printStackTrace();
		}
	}

	public void Newtab() throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			MainClass.newTab();
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to open New Tab");
			e.printStackTrace();
		}
	}
}
