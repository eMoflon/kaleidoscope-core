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
	private List<ColObject> columnObjectList = new ArrayList<ColObject>();

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
	 * @param simpleSheet
	 * @param sheetAt
	 */
	private void readSheet(Sheet currentSheet, int sheetCount, Simpleexcel.Sheet simpleSheet) {
		logger.debug("Reading from Sheet :" + this.workBook.getSheetName(sheetCount));

		simpleSheet.setSheetName(currentSheet.getSheetName());

		// read the rows of whole sheet
		List<Row> rowList = new ArrayList<Row>();
		Iterator<Row> rowIterator = currentSheet.iterator();
		while (rowIterator.hasNext()) {
			Row currentRow = rowIterator.next();
			rowList.add(currentRow);
		}

		// get max number of cell in a row - set that as column number
		int maxColumnNumber = 0;
		for (Row row : rowList) {
			int lastRowNum = row.getLastCellNum();
			if (lastRowNum > 0)
				maxColumnNumber = lastRowNum;
		}

		for (int colIndex = 0; colIndex < maxColumnNumber; colIndex++) {
			ColObject columnObject = SimpleexcelFactory.eINSTANCE.createColObject();
			columnObjectList.add(columnObject);
			simpleSheet.getColobject().add(columnObject);
		}

		// set column relations
		for (int index = 0; index < columnObjectList.size(); index++) {
			if (index < maxColumnNumber - 1) {
				columnObjectList.get(index).setNextColumn(columnObjectList.get(index+1));
			}
		}

		setRowRelations(rowList, simpleSheet, 0);
	}
	
	/**
	 * Recursive code for reading the rows and setting nextRowObject
	 * 
	 * @param rowList
	 * @param simpleSheet
	 * @param index
	 * @return
	 */
	private RowObject setRowRelations(List<Row> rowList, Simpleexcel.Sheet simpleSheet, int index) {
		Row currentRow = null;
		// RowObject nextRowObject = SimpleexcelFactory.eINSTANCE.createRowObject();
		RowObject nextRowObject = null;
		if (index < rowList.size()) {
			currentRow = rowList.get(index);
			if (!rowIsEmpty(currentRow)) {
				RowObject rowObject = SimpleexcelFactory.eINSTANCE.createRowObject();
				// if (rowId == 1)
				// rowObject.setIsheader(true);
				// rowObject.setRowId(rowId++);

				readRow(currentRow, rowObject, simpleSheet);

				nextRowObject = setRowRelations(rowList, simpleSheet, index + 1);

				// if (nextRowObject != null && !(nextRowObject.getRowId() <= 0))
				if (nextRowObject != null)
					rowObject.setNextRow(nextRowObject);

				simpleSheet.getRowobject().add(rowObject);
				return rowObject;
			}
		}
		return nextRowObject;
	}

	/**
	 * Check if a row is empty or null If so, then do not create any object for that
	 * 
	 * @param currentRow
	 */
	private boolean rowIsEmpty(Row currentRow) {
		if ((null == currentRow) || (currentRow.getLastCellNum() <= 0))
			return true;

		for (int cellIndex = currentRow.getFirstCellNum(); cellIndex < currentRow.getLastCellNum(); cellIndex++) {
			Cell cell = currentRow.getCell(cellIndex);
			if (null != cell && cell.getCellTypeEnum() != CellType.BLANK && StringUtils.isNotBlank(cell.toString())) {
				return false;
			}
		}

		return false;
	}

	/**
	 * Read data from each row
	 * 
	 * @param currentRow
	 * @param rowObject
	 * @param simpleSheet
	 */
	private void readRow(Row currentRow, RowObject rowObject, Simpleexcel.Sheet simpleSheet) {
		Iterator<Cell> cellIterator = currentRow.iterator();
		while (cellIterator.hasNext()) {
			Cell currentCell = cellIterator.next();
			// create Cell Object for Model
			Simpleexcel.Cell cellObject = SimpleexcelFactory.eINSTANCE.createCell();

			// cread attributes for every cell
			readCell(cellObject, currentCell);
			rowObject.getCell().add(cellObject);

			// add cell to colObject
			columnObjectList.get(currentCell.getAddress().getColumn()).getCell().add(cellObject);

			// add cell to simpleSheet
			simpleSheet.getCell().add(cellObject);
		}
	}

	/**
	 * This method reads the attributes for every cell and then insert them in the
	 * model
	 * 
	 * @param cellObject
	 * @param currentCell
	 */
	private void readCell(Simpleexcel.Cell cellObject, Cell currentCell) {
		// get attributes
		int rowIndex = currentCell.getRowIndex() + 1;
		int colIndex = currentCell.getColumnIndex() + 1;
		String comment = currentCell.getCellComment() != null ? currentCell.getCellComment().getString().toString()
				: "";

		// add attributes to the cellObject
		if (!comment.equals("")) // ignore empty comments
			cellObject.setCellComments(comment);
		if (!currentCell.toString().equals(""))
			cellObject.setText(currentCell.toString());
		cellObject.setCellId(cellId++);
		// get cell colors
		XSSFColor xssfColor = (XSSFColor) currentCell.getCellStyle().getFillForegroundColorColor();
		if (xssfColor != null) {
			String argbHex = xssfColor.getARGBHex();
			System.out.println("row:" + rowIndex + ",col:" + colIndex + " color: " + argbHex);
			/*if (argbHex.toString().compareTo(Constants.RED_ARGB) == 0)
				cellObject.setBackgroundColor("RED");
			if (argbHex.toString().compareTo(Constants.YELLOW_ARGB) == 0)
				cellObject.setBackgroundColor("YELLOW");
			if (argbHex.toString().compareTo(Constants.GREEN_ARGB) == 0)
				cellObject.setBackgroundColor("GREEN");
			*/
			cellObject.setBackgroundColor(argbHex);
		}
	}
}
