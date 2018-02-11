/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kaleidoscope.core.auxiliary.simpleexcel.utils.ExcelConstants;

import Simpleexcel.Column;
import Simpleexcel.SimpleexcelFactory;

/**
 * @author Srijani
 *
 */
public class ExcelHandler {
	private static final Logger logger = Logger.getLogger(ExcelHandler.class);

	private Path path;
	private Workbook workBook;

	private int cellId = ExcelConstants.INIT_CELL;

	public ExcelHandler(Path path) {
		this.path = path;
	}

	/**
	 * Read data from an Excel File
	 * 
	 * @return
	 */
	public Optional<Simpleexcel.File> parseExcelFile() {
		Optional<Simpleexcel.File> result = Optional.empty();

		try {
			logger.debug("Starting reading...");

			FileInputStream excelFile = new FileInputStream(path.toFile());
			this.workBook = new XSSFWorkbook(excelFile);

			Simpleexcel.File simpleFile = SimpleexcelFactory.eINSTANCE.createFile();
			String absoluteFileName = path.toAbsolutePath().toString();
			if (absoluteFileName.contains("\\.\\")) {
				absoluteFileName = absoluteFileName.replace("\\.\\", "\\");
			}
			simpleFile.setFileName(absoluteFileName);
			simpleFile.setPath(absoluteFileName);

			// iterate through all the sheets
			for (int sheetCount = 0; sheetCount < workBook.getNumberOfSheets(); sheetCount++) {
				// create excelElement from Sheet
				Simpleexcel.Sheet simpleSheet = SimpleexcelFactory.eINSTANCE.createSheet();
				readSheet(workBook.getSheetAt(sheetCount), sheetCount, simpleSheet);
				simpleFile.getSheet().add(simpleSheet);
			}

			result = Optional.of(simpleFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * Read data from an Excel Sheet
	 * 
	 * @param sheetCount
	 * @param currentSimpleSheet
	 * @param sheetAt
	 */
	private void readSheet(Sheet currentExcelSheet, int sheetCount, Simpleexcel.Sheet currentSimpleSheet) {
		List<Column> columnObjectList = new ArrayList<Column>();
		List<Simpleexcel.Row> rowObjectList = new ArrayList<Simpleexcel.Row>();

		Simpleexcel.Row firstRow = null;
		Simpleexcel.Row lastRow = null;
		Column firstColumn = null;
		Column lastColumn = null;

		System.out.println("Reading from Sheet :" + this.workBook.getSheetName(sheetCount));

		currentSimpleSheet.setSheetName(currentExcelSheet.getSheetName());

		// read the rows of whole sheet
		List<Row> rowList = new ArrayList<Row>();
		Iterator<Row> rowIterator = currentExcelSheet.iterator();
		while (rowIterator.hasNext()) {
			Row currentRow = rowIterator.next();
			rowList.add(currentRow);
		}

		readRows(currentExcelSheet, rowObjectList, currentSimpleSheet);

		List<Simpleexcel.Row> firstAndLastRows = getFirstAndLastRows(currentSimpleSheet);
		firstRow = firstAndLastRows.get(0);
		lastRow = firstAndLastRows.get(1);

		readColumns(rowList, columnObjectList, currentSimpleSheet);

		List<Simpleexcel.Column> firstAndLastCols = getFirstAndLastColumns(currentSimpleSheet);
		firstColumn = firstAndLastCols.get(0);
		lastColumn = firstAndLastCols.get(1);

		currentSimpleSheet = readCellData(firstRow, firstColumn, currentExcelSheet, currentSimpleSheet);

		System.out.println();
	}

	/**
	 * Read first and last column for every sheet
	 * 
	 * @param currentSimpleSheet
	 * @return
	 */
	private List<Column> getFirstAndLastColumns(Simpleexcel.Sheet currentSimpleSheet) {
		Simpleexcel.Column firstColumn = null;
		Simpleexcel.Column lastColumn = null;
		List<Simpleexcel.Column> returnVal = new ArrayList<Simpleexcel.Column>();
		// get firstColumn
		for (Column colObject : currentSimpleSheet.getColobject()) {
			if (colObject.getPrevColumn() == null)
				firstColumn = colObject;
		}
		Column tempColObject = firstColumn;
		returnVal.add(firstColumn);

		// get lastColumn
		while (tempColObject != null && tempColObject.getNextColumn() != null) {
			tempColObject = tempColObject.getNextColumn();
		}
		lastColumn = tempColObject;
		returnVal.add(lastColumn);
		
		return returnVal;
	}

	/**
	 * Returns first and last Row for every sheet
	 * 
	 * @param currentSimpleSheet
	 * @return
	 */
	private List<Simpleexcel.Row> getFirstAndLastRows(Simpleexcel.Sheet currentSimpleSheet) {
		Simpleexcel.Row firstRow = null;
		Simpleexcel.Row lastRow = null;
		List<Simpleexcel.Row> returnVal = new ArrayList<Simpleexcel.Row>();

		// get firstRow
		for (Simpleexcel.Row rowObject : currentSimpleSheet.getRowobject()) {
			if (rowObject.getPrevRow() == null)
				firstRow = rowObject;
		}
		Simpleexcel.Row tempRowObject = firstRow;
		returnVal.add(firstRow);

		// get lastRow
		while (tempRowObject != null && tempRowObject.getNextRow() != null) {
			tempRowObject = tempRowObject.getNextRow();
		}
		lastRow = tempRowObject;
		returnVal.add(lastRow);

		return returnVal;
	}

	/**
	 * Reads all columns of a sheet
	 * 
	 * @param rowList
	 * @param columnObjectList
	 * @param currentSimpleSheet
	 */
	private void readColumns(List<Row> rowList, List<Column> columnObjectList, Simpleexcel.Sheet currentSimpleSheet) {
		// get max number of cell in a row - set that as column number
		int maxColumnNumber = 0;
		for (Row row : rowList) {
			int lastRowNum = row.getLastCellNum();
			if (lastRowNum > maxColumnNumber)
				maxColumnNumber = lastRowNum;
		}

		// create columns
		for (int colIndex = 0; colIndex < maxColumnNumber; colIndex++) {
			Column columnObject = SimpleexcelFactory.eINSTANCE.createColumn();
			columnObjectList.add(columnObject);
			currentSimpleSheet.getColobject().add(columnObject);
			columnObject.setSheet(currentSimpleSheet);
		}

		// set column relations
		for (int index = 0; index < columnObjectList.size(); index++) {
			if (index < maxColumnNumber - 1) {
				columnObjectList.get(index).setNextColumn(columnObjectList.get(index + 1));
			}
		}
	}

	/**
	 * Read all rows of a sheet
	 * 
	 * @param currentExcelSheet
	 * @param rowObjectList
	 * @param currentSimpleSheet
	 */
	private void readRows(Sheet currentExcelSheet, List<Simpleexcel.Row> rowObjectList,
			Simpleexcel.Sheet currentSimpleSheet) {

		// create rows
		for (int rowIndex = 0; rowIndex < currentExcelSheet.getPhysicalNumberOfRows(); rowIndex++) {
			Simpleexcel.Row row = SimpleexcelFactory.eINSTANCE.createRow();
			rowObjectList.add(row);
			currentSimpleSheet.getRowobject().add(row);
			row.setSheet(currentSimpleSheet);
		}

		// set row relations - next
		for (int rowIndex = 0; rowIndex < rowObjectList.size() - 1; rowIndex++) {
			rowObjectList.get(rowIndex).setNextRow(rowObjectList.get(rowIndex + 1));
		}

		// set row relations - prev
		for (int rowIndex = 1; rowIndex < rowObjectList.size(); rowIndex++) {
			rowObjectList.get(rowIndex).setPrevRow((rowObjectList.get(rowIndex - 1)));
		}
	}

	/**
	 * Reads every cell in the sheet
	 * 
	 * @param firstRow
	 * @param firstColumn
	 * @param currentExcelSheet
	 * @param currentSimpleSheet
	 * @return
	 */
	private Simpleexcel.Sheet readCellData(Simpleexcel.Row firstRow, Column firstColumn, Sheet currentExcelSheet,
			Simpleexcel.Sheet currentSimpleSheet) {
		// read cell data for every row and every column
		Simpleexcel.Row tempRow = firstRow;

		int rowIndex = 0;

		while (tempRow != null) {
			Column tempCol = firstColumn;
			int colIndex = 0;
			while (tempCol != null) {
				Cell excelCell = currentExcelSheet.getRow(rowIndex).getCell(colIndex);
				if (null != excelCell) {
					Simpleexcel.Cell simpleCell = SimpleexcelFactory.eINSTANCE.createCell();
					simpleCell.setText(excelCell.getStringCellValue());
					String comment = excelCell.getCellComment() != null
							? excelCell.getCellComment().getString().toString()
							: "";
					// add attributes to the cellObject
					if (!comment.equals("")) // ignore empty comments
						simpleCell.setCellComments(comment);
					// get cell colors
					XSSFColor xssfColor = (XSSFColor) excelCell.getCellStyle().getFillForegroundColorColor();
					if (xssfColor != null) {
						String argbHex = xssfColor.getARGBHex();
						System.out.println("row:" + rowIndex + ",col:" + colIndex + " color: " + argbHex);
						simpleCell.setBackgroundColor(argbHex);
					}
					// add to row
					tempRow.getCell().add(simpleCell);
					simpleCell.setRow(tempRow);
					// add to col
					tempCol.getCell().add(simpleCell);
					simpleCell.setColumn(tempCol);
					// add to sheet
					currentSimpleSheet.getCell().add(simpleCell);
				}
				tempCol = tempCol.getNextColumn();
				colIndex++;
			}
			tempRow = tempRow.getNextRow();
			rowIndex++;
		}

		return currentSimpleSheet;
	}

}
