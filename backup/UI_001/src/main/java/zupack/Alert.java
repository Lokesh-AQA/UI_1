package zupack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pack1.Environment;

public class Alert extends Environment {

	public static void main(String[] args) throws InterruptedException {

		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			d = new ChromeDriver(options);
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			d.manage().window().maximize();
			d.get("https://demo.guru99.com/test/delete_customer.php");
			Thread.sleep(1000);
			d.findElement(By.xpath("//*[@name='cusid']")).sendKeys("Admin");
			d.findElement(By.xpath("//*[@type='submit'][@name='submit']")).click();
			
			d.switchTo().alert().accept();
			d.switchTo().alert().dismiss();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
