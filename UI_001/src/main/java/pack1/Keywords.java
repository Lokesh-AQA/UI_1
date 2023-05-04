package pack1;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;


public class Keywords extends Environment {

	public void invokebrowser(String data) {
		// Only Bowser Launch
		try {
			MainClass.browserOptions(data);
			d.manage().window().maximize();
			d.manage().deleteAllCookies();
			log.debug("Browser Opened");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void navigateURL(String data) throws IOException {

		try {
			MainClass.navigateURL(data);
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTitle() {
		try {
			Thread.sleep(500);
			MainClass.getTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCurrentURL() {
		try {
			Thread.sleep(500);
			MainClass.getCurrentURL();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Input(String data, String Objectname) throws IOException, InterruptedException {

		try {
			MainClass.loadPropertyFile();
			MainClass.passInput(data, Objectname);
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click(String objectname) throws IOException, InterruptedException {
		try {
			MainClass.loadPropertyFile();
			MainClass.clickElement(objectname);
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() throws InterruptedException {
		try {
			Thread.sleep(2000);
			d.close();
			log.debug("Close the browser");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void quit() throws InterruptedException {
		try {
			Thread.sleep(2000);
			d.quit();
			log.debug("Quit all the browser");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dropdown(String data, String objectname) throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			MainClass.selectDropdown(data, objectname);
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollDownEnd(String data, String objectname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,10000)");
			log.debug("ScrollDown till End");
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void scrollUpHome(String data, String objectname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,-10000)");
			log.debug("ScrollUp till Home");
			MainClass.captureScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	public void Jumbtab(String data) throws IOException, InterruptedException {
		try {
			Thread.sleep(2000);
			MainClass.jumpTab(data);
			MainClass.captureScreen();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void copyContent(String data) throws InterruptedException {
		try {
			Thread.sleep(1000);
			MainClass.copydata(data);

		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fileUpload() throws IOException, AWTException, InterruptedException {

		try {
			MainClass.robotClass();
			MainClass.captureScreen();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mouseClick(String objectname) {
		try {
			Thread.sleep(1000);
			MainClass.mouseClick(objectname);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void Newtab() throws InterruptedException, IOException {
		try {
			Thread.sleep(1000);
			MainClass.newTab();
			MainClass.captureScreen();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
