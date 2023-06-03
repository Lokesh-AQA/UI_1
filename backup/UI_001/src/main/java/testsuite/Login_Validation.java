package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class Login_Validation extends Environment {

	
	@Test
	public void LoginValidation() throws IOException, InterruptedException, AWTException {
		Testcasename = "Login_Validation";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.KeywordsOperations();
	}
}
