package pack1;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main extends Environment {

	public static void main(String[] args) {
		// Only Bowser Launch
		d = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();

		// Browser along with WebDriver
		// d = WebDriverManager.chromedriver().create();
		// d.manage().window().maximize();
	}

}
