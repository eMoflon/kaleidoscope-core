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

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.eclipse.emf.common.util.EList;

import com.google.common.collect.Lists;
import com.kaleidoscope.core.auxiliary.simpleexcel.utils.ExcelConstants;

import Simpleexcel.ColObject;
import Simpleexcel.RowObject;
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
		List<ColObject> columnObjectList = new ArrayList<ColObject>();
		List<RowObject> rowObjectList = new ArrayList<RowObject>();

		RowObject firstRow = null;
		RowObject lastRow = null;
		ColObject firstColumn = null;
		ColObject lastColumn = null;

		System.out.println("Reading from Sheet :" + this.workBook.getSheetName(sheetCount));

		currentSimpleSheet.setSheetName(currentExcelSheet.getSheetName());

		// read the rows of whole sheet
		List<Row> rowList = new ArrayList<Row>();
		Iterator<Row> rowIterator = currentExcelSheet.iterator();
		while (rowIterator.hasNext()) {
			Row currentRow = rowIterator.next();
			rowList.add(currentRow);
		}

		// creat rows
		for (int rowIndex = 0; rowIndex < currentExcelSheet.getPhysicalNumberOfRows(); rowIndex++) {
			RowObject rowObject = SimpleexcelFactory.eINSTANCE.createRowObject();
			rowObjectList.add(rowObject);
			currentSimpleSheet.getRowobject().add(rowObject);
		}

		// set row relations - next
		for (int rowIndex = 0; rowIndex < rowObjectList.size() - 1; rowIndex++) {
			rowObjectList.get(rowIndex).setNextRow(rowObjectList.get(rowIndex + 1));
		}

		// set row relations - prev
		for (int rowIndex = 1; rowIndex < rowObjectList.size(); rowIndex++) {
			rowObjectList.get(rowIndex).setPrevRow((rowObjectList.get(rowIndex - 1)));
		}

		// get firstRow
		for (RowObject rowObject : currentSimpleSheet.getRowobject()) {
			if (rowObject.getPrevRow() == null)
				firstRow = rowObject;
		}
		RowObject tempRowObject = firstRow;

		// get lastRow
		while (tempRowObject != null && tempRowObject.getNextRow() != null) {
			tempRowObject = tempRowObject.getNextRow();
		}
		lastRow = tempRowObject;

		// get max number of cell in a row - set that as column number
		int maxColumnNumber = 0;
		for (Row row : rowList) {
			int lastRowNum = row.getLastCellNum();
			if (lastRowNum > maxColumnNumber)
				maxColumnNumber = lastRowNum;
		}

		// create columns
		for (int colIndex = 0; colIndex < maxColumnNumber; colIndex++) {
			ColObject columnObject = SimpleexcelFactory.eINSTANCE.createColObject();
			columnObjectList.add(columnObject);
			currentSimpleSheet.getColobject().add(columnObject);
		}

		// set column relations
		for (int index = 0; index < columnObjectList.size(); index++) {
			if (index < maxColumnNumber - 1) {
				columnObjectList.get(index).setNextColumn(columnObjectList.get(index + 1));
			}
		}

		// get firstColumn
		for (ColObject colObject : currentSimpleSheet.getColobject()) {
			if (colObject.getPrevColumn() == null)
				firstColumn = colObject;
		}
		ColObject tempColObject = firstColumn;

		// get lastColumn
		while (tempColObject != null && tempColObject.getNextColumn() != null) {
			tempColObject = tempColObject.getNextColumn();
		}
		lastColumn = tempColObject;

		currentSimpleSheet = readCellData(firstRow, firstColumn, currentExcelSheet, currentSimpleSheet);

		tempRowObject = firstRow;
		int i = 1;
		while (tempRowObject != null) {
			System.out.println(i++);
			tempRowObject = tempRowObject.getNextRow();
		}

		System.out.println();
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
	private Simpleexcel.Sheet readCellData(RowObject firstRow, ColObject firstColumn, Sheet currentExcelSheet,
			Simpleexcel.Sheet currentSimpleSheet) {
		// read cell data for every row and every column
		RowObject tempRow = firstRow;

		int rowIndex = 0;

		while (tempRow != null) {
			ColObject tempCol = firstColumn;
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
					// add to col
					tempCol.getCell().add(simpleCell);
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
