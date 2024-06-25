package Utils;

public class ExcelUtilsTest {
 public static void main(String[] args) {
	 
	 String excelPath="C:/Users/abhin/eclipse-workspace/REST-Assured/RESTAssuredAutomation/data/TestData.xlsx";
	 String sheetName="Sheet1";
	 
	ExcelUtils ex = new ExcelUtils(excelPath,sheetName);
	
	ex.getCellData(0, 0);
	ex.getCellData(0, 1);
	ex.getCellData(1, 0);
	ex.getCellData(1, 1);
	ex.getCellData(2,0);
	ex.getCellData(2,1);
	ex.getRowCount();
}
}
