package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class Drag_Drop extends Environment {

	
	@Test
	public void DragAndDrop() throws IOException, InterruptedException, AWTException {
		Testcasename = "Drag_Drop";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.Operations();
	}
}
