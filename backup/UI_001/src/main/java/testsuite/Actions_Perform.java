package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class Actions_Perform extends Environment {

	
	@Test
	public void Actions() throws IOException, InterruptedException, AWTException {
		BasicConfigurator.configure();
		Testcasename = "Actions_Perform";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.KeywordsOperations();
	}
}
