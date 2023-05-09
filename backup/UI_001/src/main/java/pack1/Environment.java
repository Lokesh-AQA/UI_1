package pack1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Environment {
	
	public static WebDriver d;
	public static FileInputStream file;
	public static String keyword;
	public static String data;
	public static String Objectname;
	public static String runmode;
	@SuppressWarnings("rawtypes")
	public static ArrayList a;
	public static Properties pro;
	public static Logger log=Logger.getLogger(Keywords.class.getName());
	public static ChromeOptions options;
	public static TakesScreenshot Shot ;
	public static File SrcFile;
	public static File DestFile;
	public static Robot robot;
	public static Toolkit toolkit;
	public static Clipboard clipboard;
	public static StringSelection strStore;
	public static  Actions action;
	
	

}
