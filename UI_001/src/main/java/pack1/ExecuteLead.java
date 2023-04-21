package pack1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecuteLead {

	public static void main(String[] args) throws IOException {
		ArrayList a = new ArrayList();
		Keywords key = new Keywords();
		FileInputStream file = new FileInputStream("D:\\Sketch_1\\Git\\UI_1\\UI_001\\XL\\Page_1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		Sheet sh = book.getSheet("Sheet2");
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
			if (a.get(i).equals("OpenBrowser")) {
				String keyword = (String) a.get(i);
				// System.out.println("Keyword is "+keyword);
				String testdata = (String) a.get(i + 1);
				// System.out.println("Testdata is "+testdata);
				String Objectname = (String) a.get(i + 2);
				// System.out.println("ObjectName is "+Objectname);
				String runmode = (String) a.get(i + 3);
				// System.out.println("Runmode is "+runmode);
				if (runmode.equals("Yes")) {
					key.openbrowser();
				}
			}
			if (a.get(i).equals("NavigateURL")) {
				String keyword = (String) a.get(i);
				// System.out.println("Keyword is "+keyword);
				String testdata = (String) a.get(i + 1);
				// System.out.println("Testdata is "+testdata);
				String Objectname = (String) a.get(i + 2);
				// System.out.println("ObjectName is "+Objectname);
				String runmode = (String) a.get(i + 3);
				// System.out.println("Runmode is "+runmode);
				if (runmode.equals("Yes")) {
					key.navigateURL();
				}
			}
			if (a.get(i).equals("GetTitle")) {
				String keyword = (String) a.get(i);
				// System.out.println("Keyword is "+keyword);
				String testdata = (String) a.get(i + 1);
				// System.out.println("Testdata is "+testdata);
				String Objectname = (String) a.get(i + 2);
				// System.out.println("ObjectName is "+Objectname);
				String runmode = (String) a.get(i + 3);
				// System.out.println("Runmode is "+runmode);
				if (runmode.equals("Yes")) {
					key.getTitle();
				}
			}
			if (a.get(i).equals("GetCurrentURL")) {
				String keyword = (String) a.get(i);
				// System.out.println("Keyword is "+keyword);
				String testdata = (String) a.get(i + 1);
				// System.out.println("Testdata is "+testdata);
				String Objectname = (String) a.get(i + 2);
				// System.out.println("ObjectName is "+Objectname);
				String runmode = (String) a.get(i + 3);
				// System.out.println("Runmode is "+runmode);
				if (runmode.equals("Yes")) {
					key.getCurrentURL();
				}
			}

		}

	}
}
