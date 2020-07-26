package main.java.Core;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static List<HashMap<String, String>> lTestData;
	private static XSSFWorkbook wb;
	public static XSSFSheet sheet ;
	static HashMap<Integer, String> hmColumns;
	static FileInputStream fis;
	
	public static void loadTestData() throws IOException {		
		File file = new File("C:\\Users\\kondu\\OneDrive\\Desktop\\Subscriber\\TestData.xlsx"); 
		 fis = new FileInputStream(file); 															
		 wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("Enterprise");	
		 //sheet = wb.getSheet("Emerging Business");
	}
	
	public static void closeTestData()  throws IOException{
		fis.close();
		Date dt = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MMddyyyyhhmmss");
				
		String filename = "OutputData_"+ df.format(dt)+".xlsx";
		FileOutputStream fo = new FileOutputStream(new File("C:\\Users\\kondu\\OneDrive\\Desktop\\Subscriber\\Reports\\"+filename));
		wb.write(fo);
		fo.close();
		wb.close();
	}
	
	public static void updateResult(int row, boolean result) {
		 Cell cell = sheet.getRow(row).getCell(19);
		if(result) {		
		 cell.setCellValue("PASS");
		}
		else {
			 cell.setCellValue("FAIL");
		}
	}
	
	public static void updateCell(int row, int col, String content) {
		 Cell cell = sheet.getRow(row).getCell(col);			
		 cell.setCellValue(content);

	}
	
	@SuppressWarnings("deprecation")
	public static void prepareteTeastcaseData(String testName) {
		prepareColumns();
		Boolean isTestExist = false;		
		lTestData = new ArrayList<HashMap<String, String>>();
		boolean isFirstRow = true;
		boolean isNewRecord = false;
		
		try {
			for(Row eachRow : sheet) {
				if(isFirstRow) {
					isFirstRow = false;
				} else {
					int lastCellNo = eachRow.getLastCellNum();
					HashMap<String, String> record = new HashMap<String, String>();
					for(int col = 0; col <= lastCellNo; col++) {
						try {	
							//verify the test name
							if(col == 1) {
								if( eachRow.getCell(col) != null && eachRow.getCell(col).getCellType() == HSSFCell.CELL_TYPE_STRING) {								
									String test = eachRow.getCell(col).getStringCellValue();
									if(test.equalsIgnoreCase(testName)) {
										//if studyname is found
										isTestExist = true;
									} else if(isTestExist){								
									
										isTestExist = false;
										return;
									}
									
								}
							}
							
							if(isTestExist) {
								isNewRecord = true;
								//load test data
								if( eachRow.getCell(col) != null && eachRow.getCell(col).getCellType() == HSSFCell.CELL_TYPE_STRING) {
									String cellValue =  eachRow.getCell(col).getStringCellValue().trim();
									if( cellValue.contains("'")) {
										record.put(hmColumns.get(col),cellValue.replace("'",""));
									} else {
										record.put(hmColumns.get(col), eachRow.getCell(col).getStringCellValue());
									}
								}else if( eachRow.getCell(col) != null && eachRow.getCell(col).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									record.put(hmColumns.get(col), String.valueOf(eachRow.getCell(col).getNumericCellValue()));
								} else {
									record.put(hmColumns.get(col), "");
								}
							}
						} catch(Exception ex) {
							System.out.println();
						}
						
					}
//					if( !isTestExist && lTestData != null ) {
//						break;
//					}
					if(isNewRecord) {
						lTestData.add(record);
						isNewRecord = false;
					}
					
				}
			}
			System.out.println();
		} 
		catch(Exception ex) {
			System.out.println();
		}
	}
	
	private static void prepareColumns() {
		int cellNum = 0;
		try {
			Row row = sheet.getRow(0);
			int lastCellNo = row.getLastCellNum();
			hmColumns = new HashMap<Integer, String>();
			for(int index = 0 ; index <= lastCellNo; index++ ) {
				cellNum = index;
				
				Cell cell = row.getCell(index);
				if(!cell.getStringCellValue().contains("") || !cell.getStringCellValue().equals(null)) {
					hmColumns.put(index, cell.getStringCellValue().trim());
				} else {
					break;
				}
			}
		} catch(Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}
	
	public static void updateTestResults(int record) {
		lTestData.get(record).replace("Status", "PASS");
		System.out.println("PASS");
		System.out.println(lTestData.get(record).get("Status"));
	}
	
}
