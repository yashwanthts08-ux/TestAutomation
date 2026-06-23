package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlsData {

	@DataProvider(name="bvtdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String sheetname = m.getName();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
		Workbook w = WorkbookFactory.create(fis);
		Sheet s = w.getSheet(sheetname);
		int totalrows = s.getLastRowNum();
		System.out.println(totalrows);
	Row c = s.getRow(0);
	short totalcell = c.getLastCellNum();
	System.out.println(totalcell);
	String[][] testdata=new String[totalrows][totalcell];
	DataFormatter d=new DataFormatter();
	for(int i=1;i<=totalrows;i++) {
		for(int j=0;j<totalcell;j++) {
			testdata[i-1][j]=d.formatCellValue(s.getRow(i).getCell(j));
		}
	}
	
	return testdata;
		
	}

}
