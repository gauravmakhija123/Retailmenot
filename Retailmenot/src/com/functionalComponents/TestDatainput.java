package com.functionalComponents;

import java.io.File;

 import java.io.IOException;
 import java.util.Hashtable;

 import jxl.Sheet;
 import jxl.Workbook;

public class TestDatainput{
	
  static Sheet wrksheet;
  static Workbook wrkbook = null;
  static Hashtable<String, Integer> dictCol = new Hashtable<String, Integer>();
  static Hashtable<String, Integer> dictRow = new Hashtable<String, Integer>();
 
  public void customizedTestDataDriver(String excelSheetPath, String sheetName)
		   throws jxl.read.biff.BiffException, IOException
		      {
		        wrkbook = Workbook.getWorkbook(new File(excelSheetPath));
		  
		    wrksheet = wrkbook.getSheet(sheetName);
		  }
		  
		  public static int RowCount()
		 {
		    return wrksheet.getRows();
		  }
		  
		   public String ReadCell(int column, int row)
		  {
		     return wrksheet.getCell(column, row).getContents();
		 }

		  public void ColumnDictionary()
		  {
		   for (int col = 0; col < wrksheet.getColumns(); col++) {
		       dictCol.put(ReadCell(col, 0), Integer.valueOf(col));
	  }
		  }
		  
              public int GetCol(String colName)
		  {
		     try
		    {
	      return dictCol.get(colName).intValue();
		    }
		     catch (NullPointerException e) {}
	    return 0;
	   }
		
		
	  public void RowDictionary()
	 {
	    for (int row = 0; row < wrksheet.getRows(); row++) {
                dictRow.put(ReadCell(0, row), Integer.valueOf(row));
		   }
           }
	 
	  public int GetRow(String rowName)
		 {
		   try
		    {
		      return dictRow.get(rowName).intValue();
		    }
	    catch (NullPointerException e) {}
		    return 0;
		  }
		 }