package testsuite;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.ExecuteLead;
import global.Environment;

public class File_Uploads extends Environment {

	
	@Test
	public void FileUploads() throws IOException, InterruptedException, AWTException {
		Testcasename = "File_Uploads";
		ExecuteLead.fileStream(Testcasename);
		ExecuteLead.KeywordsOperations();
	}
}
