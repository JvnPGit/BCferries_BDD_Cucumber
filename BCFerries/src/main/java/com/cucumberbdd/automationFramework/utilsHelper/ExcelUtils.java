package com.cucumberbdd.automationFramework.utilsHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cucumberbdd.automationFramework.base.Base;

/**
 *	This class handles all Excel related operations
 */
public class ExcelUtils extends Base {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell cell;
	public static XSSFRow Row;

	/**
	 * This method is used to set the File path and to open the Excel file
	 * Pass Excel Path and Sheetname as Arguments to this method
	 * @param Path
	 * @param SheetName
	 * @
	 */
	public static void setExcelFile(String Path, String SheetName)  {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to instantiate Excel file");
		}
	}

	/**
	 * This method is used to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	 * @param RowNum
	 * @param ColNum
	 * @return
	 * @
	 */
	public static String getCellData(int RowNum, int ColNum)  {
		try {
			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get cell data from Excel file");
			return "";
		}
	}
	
	/**
	 * This method is used to delete multiple rows of test data from the Excel sheet
	 * @param excelPath
	 * @param sheetName
	 * @param startRowNumber - starting row number to delete
	 * @param endRowNumber - ending row number to delete
	 * @param totalRowCount
	 * @return void
	 * @ 
	 */
	public static void deleteMultipleRowsInExcelSheet(String excelPath, String sheetName, int startRowNumber, int endRowNumber, int totalRowCount)  {
		try {
			for (int counter = startRowNumber; counter <= endRowNumber; counter++) {
				Row row = ExcelUtils.getSpecificRowData(sheetName, excelPath, counter, 4);
				ExcelWSheet.removeRow(row);
			}
			ExcelWSheet.shiftRows(endRowNumber + 1, totalRowCount, -endRowNumber);
			FileOutputStream out = new FileOutputStream(excelPath);
			ExcelWBook.write(out);
            out.close();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete rows data from Excel file");
		}
	}
	
	/**
	 * This method is used to delete single row of test data from the Excel sheet
	 * @param excelPath
	 * @param sheetName
	 * @param Row - Row data from excel
	 * @param rowNumber - row number to delete
	 * @param totalRowCount
	 * @return void
	 * @ 
	 */
	public static void deleteSingleRowInExcelSheet(String excelPath, String sheetName, Row row, int rowNumber, int totalRowCount)  {
		try {
			ExcelWSheet.removeRow(row);
			ExcelWSheet.shiftRows(rowNumber + 1, totalRowCount, -1);
			FileOutputStream out = new FileOutputStream(excelPath);
			ExcelWBook.write(out);
            out.close();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to delete row data from Excel file");
		}
	}

	/**
	 * This method is used to write in the Excel cell, Row num and Col num are the parameters
	 * @param path
	 * @param Result
	 * @param RowNum
	 * @param ColNum
	 * @param sheetName
	 * @
	 */
	@SuppressWarnings({ "deprecation", "static-access" })
	public static void setCellData(String path, String Result, int RowNum, int ColNum, String sheetName)  {
		try {
			FileInputStream excelFile = new FileInputStream(path);
			ZipSecureFile.setMinInflateRatio(-1.0d);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			CellStyle style = ExcelWBook.createCellStyle();
			
			Row = ExcelWSheet.getRow(RowNum);
			if (null == Row) {
				Row = ExcelWSheet.createRow(RowNum);
			}

			cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (cell == null) {
				cell = Row.createCell(ColNum);

				// Set borders to the cell
				style.setBorderBottom(CellStyle.BORDER_THICK);
				style.setBorderTop(CellStyle.BORDER_THICK);
				style.setBorderRight(CellStyle.BORDER_THICK);
				style.setBorderLeft(CellStyle.BORDER_THICK);

				style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				style.setTopBorderColor(IndexedColors.BLACK.getIndex());
				style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
				
				style.setAlignment(CellStyle.ALIGN_CENTER);
				cell.setCellType(CellType.STRING);
				cell.setCellValue(Result);

			} else {
				cell.setCellType(CellType.STRING);
				cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);

			fileOut.flush();
			fileOut.close();

		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to set cell data in Excel file");
		}
	}

	/**
	 * This method is used to:
	 * Get the effective value of a cell, formatted according to the formatting of the cell. 
	 * If the cell contains a formula, it is evaluated first, then the result is formatted.
	 * 
	 * @param row - the row
	 * @param columnIndex - the cell's column index
	 * @return the cell's value
	 */
	public static String getCellValue(Row row, int columnIndex) {
		String cellValue = "";
		try {
			Cell cell = row.getCell(columnIndex);
			if (cell == null) {
				// no data in this cell
				cellValue = "";
			}
			
			if (cell != null) {
				cellValue = cell.toString();
			}
			
			return cellValue;
			
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get cell value from Excel file");
			return cellValue;
		}
	}
	
	/**
	 * This method returns one row of data with all column values for specific rowIndex 
	 * @param sheetName
	 * @param filePath
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @
	 */
	public static Row getSpecificRowData(String sheetName, String filePath, int rowIndex, int colIndex)  {
		try {
			FileInputStream excelFile = new FileInputStream(filePath);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			
			return CellUtil.getRow(rowIndex, ExcelWSheet);	
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get specific row data from Excel file");
			return CellUtil.getRow(rowIndex, ExcelWSheet);
		}
	}
	
	/**
	 * This method returns the column value based on the search key value and column index
	 * @param key
	 * @param columnIndex
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @
	 */
	public static String getColumnValue(String key, int columnIndex, String filePath, String sheetName) {
		String methodNameCellValue = null, cellValue = null;
		try {
			int totalRowCount = getTotalRowCount(sheetName, filePath);
			Row row;
			
			for (int rowIndex = 1; rowIndex <= totalRowCount; rowIndex++ ) {
				row = getSpecificRowData(sheetName, filePath, rowIndex, columnIndex);
				methodNameCellValue = getCellValue(row, columnIndex);
				
				if (methodNameCellValue.equalsIgnoreCase(key)) {
					cellValue = getCellValue(row, columnIndex);
					break;
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the column value from Excel file");
		}
		return cellValue;
	}
	
	/**
	 * This method returns the column value based on the search key value and column index
	 * @param key
	 * @param columnIndex
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @
	 */
	public static int getRowNumberWhenColumnValueMatches(String key, int startingRowNumber, int columnIndex, String filePath, String sheetName) {
		String methodNameCellValue = null;
		int rowIndex = 0; int finalRowIndex = 0;
		try {
			int totalRowCount = getTotalRowCount(sheetName, filePath);
			Row row;
			
			for (rowIndex = startingRowNumber; rowIndex < totalRowCount; rowIndex++ ) {
				row = getSpecificRowData(sheetName, filePath, rowIndex, columnIndex);
				methodNameCellValue = getCellValue(row, columnIndex);
				
				if (methodNameCellValue.equalsIgnoreCase(key)) {
					finalRowIndex = rowIndex;
					break;
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get the column value from Excel file");
		}
		return finalRowIndex;
	}
	
	/**
	 * This method returns the total number of rows in an Excel sheet
	 * @param sheetName
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static int getTotalRowCount(String sheetName, String filePath) throws IOException {
		try {
			FileInputStream excelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(excelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			return ExcelWSheet.getPhysicalNumberOfRows();
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get total row count from Excel file");
			return ExcelWSheet.getPhysicalNumberOfRows();
		}
	}
	
	/**
	 * This method returns a specific cell value from a column in an Excel sheet
	 * @param cellValue
	 * @param columnIndexToSearch
	 * @param columnIndexToGet
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @
	 */
	public static String getSpecificCellValueFromColumn(String cellValue, int columnIndexToSearch, int columnIndexToGet, String filePath, String sheetName)  {
		String ExcelCellValue = null;
		try {
			int totalRowCount = getTotalRowCount(sheetName, filePath);
			Row row;
			
			for (int rowIndex = 1; rowIndex <= totalRowCount; rowIndex++ ) {
				row = getSpecificRowData(sheetName, filePath, rowIndex, columnIndexToSearch);
				ExcelCellValue = getCellValue(row, columnIndexToSearch);
				
				if (ExcelCellValue.trim().equalsIgnoreCase(cellValue.trim())) {
					return getCellValue(row, columnIndexToGet);
				}
			}
		} catch (Exception e) {
			Log4j.info(e.getMessage());
			Log4j.info("Failed to get specific cell value from column from Excel file");
		}
		return ExcelCellValue;
	}
	
	/**
	 * This method is used to get the list of Excel file's sheet names
	 * @param filePath
	 * @return
	 * @
	 */
	public static ArrayList<String> getSheetNamesList(String filePath)  {
		FileInputStream fileInputStream = null;
		ArrayList<String> sheetNamesList = new ArrayList<String>();
		
		try {
            fileInputStream = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // for each sheet in the workbook
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            	sheetNamesList.add(workbook.getSheetName(i));
            }
            
            workbook.close();

        } catch (Exception e) {
            Log4j.info(e.getMessage());
            Log4j.info("Failed to get the Excel sheet names list");
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return sheetNamesList;
	}
	
	@SuppressWarnings("resource")
	public static void mergeExcelFiles(File file, String directoryName) {
		try {
			XSSFWorkbook book = new XSSFWorkbook();
			System.out.println(file.getName());
			File directory = new File(directoryName);
			// get all the files from a directory
			File[] fList = directory.listFiles();

			for (File file1 : fList) {
				if (file1.isFile() && !(file1.toString().contains(".DS_Store"))) {
					String excelFile = file1.getName();
					FileInputStream fin = new FileInputStream(new File(directoryName + File.separator + excelFile));
					XSSFWorkbook b = new XSSFWorkbook(fin);
					for (int i = 0; i < b.getNumberOfSheets(); i++) {
						XSSFSheet sheet = book.createSheet(b.getSheetName(i));
						copySheets(book, sheet, b.getSheetAt(i));
						Log4j.info ("Copying sheet '" + b.getSheetName(i) + "'");
					}
				}
				try {
					writeFile(book, file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			Log4j.info("Failed to merge excel files");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to write to excel workbook and close the OutputStream
	 * 
	 * @param book
	 * @param file
	 */
	protected static void writeFile(XSSFWorkbook book, File file) {
		try {
			FileOutputStream out = new FileOutputStream(file);
			book.write(out);
			out.close();
		} catch (Exception e) {
			Log4j.info("Failed to write to excel workbook");
			Log4j.info(e.getMessage());
		}
	}
	  
	private static void copySheets(XSSFWorkbook newWorkbook, XSSFSheet newSheet, XSSFSheet sheet) {
		copySheets(newWorkbook, newSheet, sheet, true);
	}

	/**
	 * This method is used to copy sheets in the excel workbook
	 * 
	 * @param newWorkbook
	 * @param newSheet
	 * @param sheet
	 * @param copyStyle
	 */
	private static void copySheets(XSSFWorkbook newWorkbook, XSSFSheet newSheet, XSSFSheet oldSheet, boolean copyStyle) {
		try {
			int newRownumber = newSheet.getLastRowNum();
			int maxColumnNum = 0;
			Map<Integer, XSSFCellStyle> styleMap = (copyStyle) ? new HashMap<Integer, XSSFCellStyle>() : null;

			for (int i = oldSheet.getFirstRowNum(); i <= oldSheet.getLastRowNum(); i++) {
				XSSFRow srcRow = oldSheet.getRow(i);
				XSSFRow destRow = newSheet.createRow(i + newRownumber);

				if (srcRow != null) {
					copyRowData (newWorkbook, srcRow, destRow, styleMap);
					if (srcRow.getLastCellNum() > maxColumnNum) {
						maxColumnNum = srcRow.getLastCellNum();
					}
				}
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy sheets in the excel workbok");
			Log4j.info(e.getMessage());
		}
	}     

	/**
	 * This method is used to copy row in the excel worksheet
	 * 
	 * @param newWorkbook
	 * @param srcSheet
	 * @param destSheet
	 * @param srcRow
	 * @param destRow
	 * @param styleMap
	 */
	public static void copyRowData (XSSFWorkbook newWorkbook, XSSFRow srcRow, XSSFRow destRow, Map<Integer, XSSFCellStyle> styleMap) {
		try {
			destRow.setHeight(srcRow.getHeight());
			for (int j = srcRow.getFirstCellNum(); j <= srcRow.getLastCellNum(); j++) {
				XSSFCell oldCell = srcRow.getCell(j);
				XSSFCell newCell = destRow.getCell(j);
				if (oldCell != null) {
					if (newCell == null) {
						newCell = destRow.createCell(j);
					}
					copyCell(newWorkbook, oldCell, newCell, styleMap);
				}
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy row in the excel worksheet");
			Log4j.info(e.getMessage());
		}
	}

	/**
	 * This method is used to copy cell in the excel worksheet
	 * 
	 * @param newWorkbook
	 * @param oldCell
	 * @param newCell
	 * @param styleMap
	 */
	@SuppressWarnings("deprecation")
	public static void copyCell(XSSFWorkbook newWorkbook, XSSFCell oldCell, XSSFCell newCell, Map<Integer, XSSFCellStyle> styleMap) {
		try {
			if (styleMap != null) {
				int stHashCode = oldCell.getCellStyle().hashCode();
				XSSFCellStyle newCellStyle = styleMap.get(stHashCode);
				if (newCellStyle == null) {
					newCellStyle = newWorkbook.createCellStyle();
					newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
					styleMap.put(stHashCode, newCellStyle);
				}
				newCell.setCellStyle(newCellStyle);
			}
			switch (oldCell.getCellType()) {
			case XSSFCell.CELL_TYPE_STRING:
				newCell.setCellValue(oldCell.getRichStringCellValue());
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				newCell.setCellValue(oldCell.getNumericCellValue());
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				newCell.setCellType(XSSFCell.CELL_TYPE_BLANK);
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN:
				newCell.setCellValue(oldCell.getBooleanCellValue());
				break;
			case XSSFCell.CELL_TYPE_ERROR:
				newCell.setCellErrorValue(oldCell.getErrorCellValue());
				break;
			case XSSFCell.CELL_TYPE_FORMULA:
				newCell.setCellFormula(oldCell.getCellFormula());
				break;
			default:
				break;
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy cell in the excel worksheet");
			Log4j.info(e.getMessage());
		}
	}
	  
	/**
	 * This method is used to copy row from source excel sheet into destination excel sheet
	 * 
	 * @param sourceWorksheet
	 * @param destWorkbook
	 * @param destWorksheet
	 * @param sourceRowNum
	 * @param destinationRowNum
	 */
	@SuppressWarnings("deprecation")
	public static void copyRow(XSSFSheet sourceWorksheet, XSSFWorkbook destWorkbook, XSSFSheet destWorksheet, int sourceRowNum, int destinationRowNum) {
		try {
			// Get the source / new row
			XSSFRow newRow = destWorksheet.getRow(destinationRowNum);
			XSSFRow sourceRow = sourceWorksheet.getRow(sourceRowNum);

			// If the row exist in destination, push down all rows by 1 else create a new
			// row
			if (newRow != null) {
				destWorksheet.shiftRows(destinationRowNum, destWorksheet.getLastRowNum(), 1);
			} else {
				newRow = destWorksheet.createRow(destinationRowNum);
			}

			// Loop through source columns to add to new row
			for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
				// Grab a copy of the old/new cell
				XSSFCell oldCell = sourceRow.getCell(i);
				XSSFCell newCell = newRow.createCell(i);

				// If the old cell is null jump to next cell
				if (oldCell == null) {
					newCell = null;
					continue;
				}

				// Copy style from old cell and apply to new cell
				CellStyle newCellStyle = destWorkbook.createCellStyle();
				newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
				newCell.setCellStyle(newCellStyle);

				// If there is a cell comment, copy
				if (oldCell.getCellComment() != null) {
					newCell.setCellComment(oldCell.getCellComment());
				}

				// If there is a cell hyperlink, copy
				if (oldCell.getHyperlink() != null) {
					newCell.setHyperlink(oldCell.getHyperlink());
				}

				// Set the cell data type
				newCell.setCellType(oldCell.getCellType());

				// Set the cell data value
				switch (oldCell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					newCell.setCellValue(oldCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					newCell.setCellValue(oldCell.getBooleanCellValue());
					break;
				case Cell.CELL_TYPE_ERROR:
					newCell.setCellErrorValue(oldCell.getErrorCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					newCell.setCellFormula(oldCell.getCellFormula());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					newCell.setCellValue(oldCell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					newCell.setCellValue(oldCell.getRichStringCellValue());
					break;
				}
			}
		} catch (Exception e) {
			Log4j.info("Failed to copy row from one sheet to another sheet");
			Log4j.info(e.getMessage());
		}
	}
	
	/**
	 * This method is used to convert .xlsx to .csv file
	 * @param directoryName
	 * @param excelFileName
	 */
	public static void convertExcelToCSV(String directoryName, String excelFileName) {
		StringBuilder data = new StringBuilder();
		InputStream inputStream = null;
		
		try {
			String excelFilePath = directoryName + File.separator + excelFileName;
			inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(inputStream);
			
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				Sheet sheet = workbook.getSheetAt(i);
				String sheetName = workbook.getSheetAt(i).getSheetName();
				Iterator<Row> rowIterator = sheet.iterator();
				
				while (rowIterator.hasNext()) {
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();

						CellType type = cell.getCellTypeEnum();
						if (type == CellType.BOOLEAN) {
							data.append(cell.getBooleanCellValue());
						
						} else if (type == CellType.NUMERIC) {
							data.append(cell.getNumericCellValue());
						
						} else if (type == CellType.STRING) {
							data.append(cell.getStringCellValue());
						
						} else if (type == CellType.BLANK) {
						
						} else {
							data.append(cell + "");
						}
						
						data.append(",");
					}
					data.append('\n');
				}
				
				Files.write(Paths.get(directoryName + File.separator + sheetName + ".csv"), data.toString().getBytes("UTF-8"));
			}
			
		} catch (Exception e) {
			Log4j.info("Failed to convert .xlsx to .csv file");
			Log4j.info(e.getMessage());
			
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					Log4j.info("Failed to close the InputStream");
					Log4j.info(e.getMessage());
				}
			}
		}
	}
	
	/**
	 * This method is used to get the cell value from a row based on rowIndex and colIndex
	 * @param sheetName
	 * @param excelFilePath
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 */
	public static String getCellValueFromRow(String sheetName, String excelFilePath, int rowIndex, int colIndex) {
		String cellValue = "";
		
		try {
			Row row = ExcelUtils.getSpecificRowData(sheetName, excelFilePath, rowIndex, colIndex);
			cellValue = ExcelUtils.getCellValue(row, colIndex).trim();
			return cellValue.trim();
		
		} catch (Exception e) {
			Log4j.info("Failed to get the cell value from Row");
			Log4j.info(e.getMessage());
			return cellValue.trim();
		}
	}
}
