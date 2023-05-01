package pack1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keywords extends Environment {

	public void openbrowser() {
		// Only Bowser Launch
		// WebDriverManager.chromedriver().setup();

		// Browser along with WebDriver
		d = WebDriverManager.chromedriver().create();

		//d.quit();
	}

	public void navigateURL() {
		d.get("https://opensource-demo.orangehrmlive.com/");
	}

	public void getTitle() {
		System.out.println(d.getTitle());

	}

	public void getCurrentURL() {
		System.out.println(d.getCurrentUrl());

	}

	public void quit() {
		d.quit();
		
	}

	public void Input() {
		
		
	}

}
