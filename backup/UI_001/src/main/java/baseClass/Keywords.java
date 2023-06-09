package baseClass;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;

import global.Environment;

public class Keywords extends Environment {

	public void invokebrowser(String data) {
		try {
			MainClass.browserOptions(data);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			// d.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
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
			MainClass.getTitle(data);
		} catch (Exception e) {
			log.error("Fail,unable to GetTitle from page");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void getCurrentURL() {
		try {
			Thread.sleep(100);
			MainClass.getCurrentURL(data);
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
			//MainClass.captureScreen();
			
			
		
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
			MainClass.Dropdown(data, objectname);
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
			Thread.sleep(1000);
			MainClass.actionsClick(objectname);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to perform Mouse Click: " + objectname);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void actionsInputPass(String data, String objectname)
			throws IOException, InterruptedException, AWTException {
		MainClass.loadPropertyFile();
		Thread.sleep(500);
		MainClass.actionsInputPass(data, objectname);
		Thread.sleep(1000);
		MainClass.captureScreen();
	}

	public void actionsdragAnddrop(String data, String objectname) throws IOException, InterruptedException {
		MainClass.loadPropertyFile();
		Thread.sleep(1000);
		MainClass.actionsDragAndDrop(data, objectname);
		Thread.sleep(1000);
		MainClass.captureScreen();
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
			Thread.sleep(1000);
			MainClass.jumpTab(data);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Jump Tab: " + data);
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollDownEnd() throws IOException {
		try {
			MainClass.scrollDownEnd();
			Thread.sleep(1000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Scrolldown till END");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollUpHome() throws IOException {
		try {
			MainClass.scrollUpHome();
			Thread.sleep(1000);
			MainClass.captureScreen();
		} catch (Exception e) {
			log.error("Fail,unable to Scrollup till HOME");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void scrollUpElement(String objectname) {
		try {
			MainClass.loadPropertyFile();
			MainClass.scrollElement(objectname);
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

	public void uploadfile() throws AWTException, InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			MainClass.uploadFile();
			MainClass.captureScreen();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SubmitButton(String Objectname) throws InterruptedException, IOException {
		Thread.sleep(1000);
		MainClass.submit();
		MainClass.captureScreen();
	}

	public void alertFunction(String data) throws InterruptedException, IOException {
		Thread.sleep(2000);
		MainClass.alertfunction(data);
	}
}
