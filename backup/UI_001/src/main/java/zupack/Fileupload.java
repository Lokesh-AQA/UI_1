package zupack;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import baseClass.Environment;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileupload extends Environment {

	public static void main(String[] args) throws InterruptedException {
		
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			d = new ChromeDriver(options);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			d.manage().window().maximize();
			d.get("https://the-internet.herokuapp.com/upload");
			Thread.sleep(1000);
			//d.findElement(By.xpath("//*[@id='file-upload'][@type='file'][@name='file']")).submit();
			Actions action = new Actions(d);
			WebElement element = d.findElement(By.xpath("//*[@id='file-upload'][@type='file'][@name='file']"));
			action.moveToElement(element).click().build().perform();
			Thread.sleep(1000);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Clipboard clipboard = toolkit.getSystemClipboard();
			StringSelection strStore = new StringSelection("STUB");
			clipboard.setContents(strStore, null);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
