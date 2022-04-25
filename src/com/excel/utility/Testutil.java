package com.excel.utility;

import java.util.ArrayList;

public class Testutil {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel() {

          ArrayList<Object[]> mydata = new ArrayList<Object[]>();
          
          try {
			reader = new Xls_Reader("C:\\Users\\Pd\\eclipse-workspace\\SeleniumSessions\\src\\com\\testdata\\eBayRegData.xlsx");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
          
        int row=reader.getRowCount("RegTestData");
        
  		for(int rownum=2;rownum<=5;rownum++)
  		{
  			String fname = reader.getCellData("RegTestData", "Firstname", rownum);
  			
  			String lname = reader.getCellData("RegTestData", "Lastname", rownum);
  			
  			String email = reader.getCellData("RegTestData", "Email", rownum);

  			String pwd = reader.getCellData("RegTestData", "Password", rownum);
  			
  			Object ob[]= {fname,lname,email,pwd};
  			
  			mydata.add(ob);     
  		}
  		
  		return mydata;
		  

	}

}
