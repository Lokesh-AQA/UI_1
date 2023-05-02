package pack1;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Environment {
	
	public static WebDriver d;
	public static FileInputStream file;
	public static Properties pro;
	public static Logger log=Logger.getLogger(Keywords.class.getName());
	public static ChromeOptions options;
	public static TakesScreenshot Shot ;
	public static File SrcFile;
	public static File DestFile;
	
	

}
