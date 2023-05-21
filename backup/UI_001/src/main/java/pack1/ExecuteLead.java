package pack1;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExecuteLead extends Environment {

	@SuppressWarnings({ "rawtypes", "incomplete-switch", "unchecked", "resource" })
	@Test
	public static void main() throws IOException, InterruptedException, AWTException {
		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\config\\log4j.properties");
		a = new ArrayList();
		Keywords key = new Keywords();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\XL\\Page_1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		Sheet sh = book.getSheet("Orange");
		Iterator itr = sh.iterator();
		while (itr.hasNext()) {
			Row rowitr = (Row) itr.next();
			Iterator cellitr = rowitr.cellIterator();
			while (cellitr.hasNext()) {
				Cell celldata = (Cell) cellitr.next();
				switch (celldata.getCellType()) {
				case STRING:
					a.add(celldata.getStringCellValue());
					// System.out.println(celldata.getStringCellValue());
					break;
				case NUMERIC:
					a.add(celldata.getNumericCellValue());
					// System.out.println(celldata.getNumericCellValue());
					break;
				case BOOLEAN:
					a.add(celldata.getBooleanCellValue());
					// System.out.println(celldata.getBooleanCellValue());
					break;
				}
			}
		}
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i).equals("InvokeBrowser")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.invokebrowser(data);
				}
			}
			if (a.get(i).equals("NavigateURL")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.navigateURL(data);
				}
			}
			if (a.get(i).equals("GetTitle")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.getTitle();
				}
			}
			if (a.get(i).equals("GetCurrentURL")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.getCurrentURL();
				}
			}
			if (a.get(i).equals("Input")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.Input(data, Objectname);
				}
			}
			if (a.get(i).equals("Click")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.click(Objectname);
				}
			}
			if (a.get(i).equals("ActionsClick")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.actionsClick(Objectname);
				}
			}
			if (a.get(i).equals("ActionsInputPass")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.actionsInputPass(data, Objectname);
				}
			}
			if (a.get(i).equals("DragAndDrop")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.actionsdragAnddrop(data, Objectname);
				}
			}
			if (a.get(i).equals("Dropdown")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.dropdown(data, Objectname);
				}
			}
			if (a.get(i).equals("ScrollDownEND")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.scrollDownEnd();
				}
			}
			if (a.get(i).equals("ScrollUpHOME")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.scrollUpHome();
				}
			}
			if (a.get(i).equals("ScrollDownElement")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.scrollUpElement(Objectname);
				}
			}
			if (a.get(i).equals("NewTab")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.Newtab();
				}
			}
			if (a.get(i).equals("JumbTab")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.Jumbtab(data);
				}
			}
			if (a.get(i).equals("CopyContent")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.copyContent(data);
				}
			}
			if (a.get(i).equals("Close")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.close();
				}
			}
			if (a.get(i).equals("Quit")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.quit();
				}
			}
			if (a.get(i).equals("UploadFile")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.uploadfile();
				}
			}
			if (a.get(i).equals("SubmitButton")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.SubmitButton(Objectname);
				}
			}
			if (a.get(i).equals("AlertAccept")) {
				MainClass.dataIndexValue(i);
				if (runmode.equals("Yes")) {
					key.alertaccept();
				}
			}
		}
	}
}
