package pack1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends Environment {

	public static void capture() throws IOException {
		Shot = ((TakesScreenshot) d);
		SrcFile = Shot.getScreenshotAs(OutputType.FILE);
		DestFile = new File("D:\\Sketch_1\\Git\\UI_1\\UI_001\\Screenshots\\Passed Testcases\\Evident_" + timestamp() + ".jpeg");
		FileUtils.copyFile(SrcFile, DestFile);
		// log.debug("Screenshots Taken");

	}

	private static String timestamp() {
		SimpleDateFormat f = new SimpleDateFormat("HH.mm.ss");
		return f.format(new Date());
	}
}
