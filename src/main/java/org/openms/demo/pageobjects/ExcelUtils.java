package org.openms.demo.pageobjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static List<String[]> readDataFromExcel(String excelFilePath, String sheetName) {
		List<String[]> testDataList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(excelFilePath));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet1 = workBook.getSheet(sheetName);

			int rowsCount = sheet1.getLastRowNum();
			int index = 0;

			for (int i = 1; i <= rowsCount; i++) {
				String[] eachRowDataStrinArr = new String[sheet1.getRow(i).getLastCellNum()];

				Iterator<Cell> allCells = sheet1.getRow(i).cellIterator();

				while (allCells.hasNext()) {
					Cell eachCell = allCells.next();

					switch (eachCell.getCellType()) {
					case STRING:
						eachRowDataStrinArr[index] = eachCell.getStringCellValue();
						break;
					case NUMERIC:
						eachRowDataStrinArr[index] = String.valueOf(eachCell.getNumericCellValue());
						break;
					case BOOLEAN:
						eachRowDataStrinArr[index] = String.valueOf(eachCell.getBooleanCellValue());
						break;
					case BLANK:
						eachRowDataStrinArr[index] = "";
						break;
					}
					index++;
				}

				index = 0;
				testDataList.add(eachRowDataStrinArr);
			}
			fis.close();
		} catch (Exception e) {
			System.out.println("Exception Occured while reading the data from Excel: " + e.getMessage());
		}
		return testDataList;
	}

	public static Iterator<Object[]> readHybridDrivenDataFromExcel(String excelFilePath, String sheetName,
			String methodName) {
		List<Map<String, String>> testData = null;
		try {
			FileInputStream fis = new FileInputStream(new File(excelFilePath));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			testData = getTestDataBySheetAndMethodName(sheet, methodName);
		} catch (Exception e) {
			System.out.println("Exception Occured while reading Hybrid datat from excel: " + e.getMessage());
		}
		return getTestDataIteratorObjectArray(testData);
	}

	public static List<Map<String, String>> getTestDataBySheetAndMethodName(XSSFSheet sheetName, String methodName) {
		List<Map<String, String>> testData = new ArrayList<>();
		int startRowNo = getStartRow(sheetName, methodName);
		int endRowNo = getEndRow(startRowNo, sheetName, methodName);
		List<String> allHeaders = getTestDataHeaders(startRowNo, sheetName);
		for (int i = startRowNo + 2; i < endRowNo; i++) {
			Map<String, String> testDataMap = new Hashtable<>();
			Row testDataRow = sheetName.getRow(i);
			Cell cellData;
			for (int j = 0; j < allHeaders.size(); j++) {
				if (!allHeaders.get(j).equalsIgnoreCase("CELL NOT FOUND")
						&& !allHeaders.get(j).equalsIgnoreCase("CELL DAA NOT FOUND")) {
					cellData = testDataRow.getCell(j, MissingCellPolicy.RETURN_NULL_AND_BLANK);
					if (cellData != null) {
						cellData.setCellType(CellType.STRING);
					}
					if (cellData != null && !cellData.getStringCellValue().trim().equals("")) {
						testDataMap.put(allHeaders.get(j), cellData.getStringCellValue());
					}
				}
			}
			testData.add(testDataMap);
		}
		return testData;
	}

	public static int getStartRow(XSSFSheet sheetName, String methodName) {
		try {
			for (int i = 1; i < sheetName.getLastRowNum(); i++) {
				Cell methodNameCell = sheetName.getRow(i).getCell(0);
				if (sheetName.getRow(i).getCell(0) != null) {
					if (!methodNameCell.getStringCellValue().trim().equals("")) {
						if (methodNameCell.getStringCellValue().trim().equalsIgnoreCase(methodName)) {
							return i;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exeption Occured while fetching Start row number of method: " + methodName + " error: "
					+ e.getMessage());
		}
		return 0;
	}

	public static int getEndRow(int startRowNo, XSSFSheet sheetName, String methodName) {
		try {
			for (int i = startRowNo + 1; i < sheetName.getLastRowNum(); i++) {
				Cell methodNameCell = sheetName.getRow(i).getCell(0);
				if (sheetName.getRow(i).getCell(0) != null) {
					if (!methodNameCell.getStringCellValue().trim().equals("")) {
						if (methodNameCell.getStringCellValue().trim().equalsIgnoreCase(methodName)) {
							return i;
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exeption Occured while fetching End row number of method: " + methodName + " error: "
					+ e.getMessage());
		}
		return startRowNo;
	}

	public static List<String> getTestDataHeaders(int startRowNo, XSSFSheet sheetName) {
		List<String> headersList = new ArrayList<>();
		Row colunNamesRow = sheetName.getRow(startRowNo + 1);
		for (int i = 0; i < colunNamesRow.getLastCellNum(); i++) {
			Cell dataCell = colunNamesRow.getCell(i, MissingCellPolicy.RETURN_NULL_AND_BLANK);
			if (dataCell == null) {
				headersList.add("CELL NOT FOUND");
			} else if (dataCell.getStringCellValue().trim().equals("")) {
				headersList.add("CELL DAA NOT FOUND");
			} else {
				dataCell.setCellType(CellType.STRING);
				headersList.add(dataCell.getStringCellValue().trim());
			}
		}
		return headersList;
	}

	public static Iterator<Object[]> getTestDataIteratorObjectArray(List<Map<String, String>> testData) {
		List<Object[]> ObjectArrayList = new ArrayList<>();
		for (Map<String, String> eachMap : testData) {
			ObjectArrayList.add(new Object[] { eachMap });
		}
		return ObjectArrayList.iterator();
	}
}
