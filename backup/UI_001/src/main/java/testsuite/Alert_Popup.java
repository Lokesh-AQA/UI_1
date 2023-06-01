package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class Alert_Popup extends Environment {

	
	@Test
	public void AlertPopup() throws IOException, InterruptedException, AWTException {
		Testcasename = "Alert_Popup";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.Operations();
	}
}
