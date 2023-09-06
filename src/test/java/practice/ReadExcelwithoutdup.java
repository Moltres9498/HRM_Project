package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashSet;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelwithoutdup {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("./data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=1;i<wb.getSheet("Sheet1").getLastRowNum();i++) {
			 String data=wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			 set.add(data);
			 System.out.println(data);
		}
		System.out.println("after removing dups-->"+set);
	}

}
