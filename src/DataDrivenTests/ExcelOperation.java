package DataDrivenTests;

import com.excel.utility.Xls_Reader;

public class ExcelOperation {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\com\\testdata\\eBayRegData.xlsx");
		reader.addSheet("HomePage");
		
		if(!reader.isSheetExist("HomePage"))
		{
			reader.addSheet("HomePage");
		}
		
		int row =reader.getRowCount("RegTestData");
		System.out.println(row);

		
		int col =reader.getColumnCount("RegTestData");
		System.out.println(col);
		
		int cellnum = reader.getCellRowNum("RegTestData", "Firstname", "Tom3");
		System.out.println(cellnum);
		
		reader.removeColumn("RegTestData", 4);
	}

}
