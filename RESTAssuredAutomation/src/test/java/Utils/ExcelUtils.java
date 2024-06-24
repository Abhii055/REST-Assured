package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName) {
		try {
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void getCellData(int rownum, int colnum) {
			DataFormatter formatter = new DataFormatter();
			Object obj = formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum));
			System.out.println(obj);
	}
	
	public static void getRowCount() {
			int rownum = sheet.getPhysicalNumberOfRows();
			System.out.println(rownum);
	}
}



//public static  ArrayList<Object[]> getDataFromExcel(){
//ArrayList<Object[]> mydata = new ArrayList<Object[]>();
//try {
//	reader = new Xls_Reader("C:\Users\abhin\eclipse-workspace\REST-Assured\RESTAssuredAutomation\data\TestData.xlsx");
//} catch (Exception e) {
//	e.printStackTrace();
//}
//
//for(int rowcount= 2; rowcount<=reader.getRowCount("Sheet1");rowcount++) {
//	String businessName =reader.getCellData("Sheet1", "businessName", rowcount);
//	String businessEmail  =reader.getCellData("Sheet1", "businessEmail", rowcount);
//	String bizPassword = reader.getCellData("Sheet1", "password", rowcount);
//	String Country =reader.getCellData("Sheet1", "country", rowcount); 
//	
//	Object obj[]= {businessName,businessEmail,bizPassword,Country};
//	mydata.add(obj);
//	
//}
//return mydata;
//}