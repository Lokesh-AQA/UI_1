package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class Handle_MultiTab extends Environment {

	
	@Test
	public void HandleMultiTab() throws IOException, InterruptedException, AWTException {
		Testcasename = "Handle_MultiTab";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.Operations();
	}
}
