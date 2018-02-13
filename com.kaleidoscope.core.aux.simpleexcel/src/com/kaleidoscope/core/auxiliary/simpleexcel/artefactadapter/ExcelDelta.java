/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kaleidoscope.core.auxiliary.simpleexcel.bean.ExcelOperationsBean;
import com.kaleidoscope.core.auxiliary.simpleexcel.utils.ExcelException;

/**
 * @author Srijani
 *
 */
public class ExcelDelta {

	private Path filePath;
	private String file;

	private List<ExcelOperationsBean> excelOperations;
	private List<ExcelOperationsBean> excelOperationsAddNodes = new ArrayList<ExcelOperationsBean>();
	private List<ExcelOperationsBean> excelOperationsDeleteNodes = new ArrayList<ExcelOperationsBean>();;
	private List<ExcelOperationsBean> excelOperationsAddEdges = new ArrayList<ExcelOperationsBean>();;
	private List<ExcelOperationsBean> excelOperationsDeleteEdges = new ArrayList<ExcelOperationsBean>();
	private List<ExcelOperationsBean> excelOperationsChangeAttributes = new ArrayList<ExcelOperationsBean>();

	/**
	 * @param path
	 * @param operationList2
	 */
	public ExcelDelta(List<ExcelOperationsBean> excelOperations) {
		this.excelOperations = excelOperations;
		for (ExcelOperationsBean excelOperationBean : excelOperations) {
			String fileName = "";
			String filePath = "";
			if (excelOperationBean.getOperationName().equals("ADD_FILE")) {
				if (excelOperationBean.getOperationDetails().containsKey("FILE_NAME"))
					fileName = excelOperationBean.getOperationDetails().get("FILE_NAME");
				if (excelOperationBean.getOperationDetails().containsKey("FILE_PATH"))
					filePath = excelOperationBean.getOperationDetails().get("FILE_PATH");

				if (fileName != null && !fileName.equals("")) {
					if (filePath != null && !filePath.equals("")) {
						this.filePath = Paths.get(filePath + "\\" + fileName);
					} else {
						this.filePath = Paths.get(fileName);
					}
				}

			} else {
				this.filePath = null;
			}
		}
		splitOperations();
	}

	/**
	 * Split functions based on the operation types
	 */
	private void splitOperations() {
		for (ExcelOperationsBean excelOperationsBean : excelOperations) {
			String opName = excelOperationsBean.getOperationName();
			System.out.println(opName);
			// ADD EDGE
			if (opName.startsWith("ADD_") && opName.endsWith("_EDGE")) {
				excelOperationsAddEdges.add(excelOperationsBean);
			}

			// ADD NODE
			if (opName.startsWith("ADD_") && !opName.endsWith("_EDGE")) {
				excelOperationsAddNodes.add(excelOperationsBean);
			}

			// DELETE EDGE
			if (opName.startsWith("DELETE_") && opName.endsWith("_EDGE")) {
				excelOperationsDeleteEdges.add(excelOperationsBean);
			}

			// DELETE NODE
			if (opName.startsWith("DELETE_") && !opName.endsWith("_EDGE")) {
				excelOperationsDeleteNodes.add(excelOperationsBean);
			}

			// CHANGE ATTRIBUTE
			if (opName.startsWith("CHANGE_ATTR")) {
				excelOperationsChangeAttributes.add(excelOperationsBean);
			}

		}
	}

	/**
	 * Entry point for this class
	 * 
	 * @throws ExcelException
	 */
	public void execute() throws ExcelException {
		for (ExcelOperationsBean excelOperationsBean : excelOperations) {
			String operationName = excelOperationsBean.getOperationName();
			System.out.println(operationName);
			switch (operationName) {
			case "ADD_FILE":
				fileOperation("ADD_FILE", excelOperationsBean.getOperationDetails());
				break;

			case "ADD_SHEET":
				sheetOperation("ADD_SHEET", excelOperationsBean.getOperationDetails());
				break;

			case "DELETE_SHEET":
				sheetOperation("DELETE_SHEET", excelOperationsBean.getOperationDetails());
				break;

			case "ADD_ROW":
				rowOperation("ADD_ROW", excelOperationsBean.getOperationDetails());
				break;

			case "ADD_CELL":
				cellOperation("ADD_CELL", excelOperationsBean.getOperationDetails());
				break;

			case "CHANGE_ATTR_CELL":
				cellOperation("CHANGE_ATTR_CELL", excelOperationsBean.getOperationDetails());
				break;

			default:
				System.out.println("OPERATION NOT FOUND IN EXCEL API");
				break;
			}
		}

	}

	/**
	 * Implements all the cell related operations
	 * 
	 * @param string
	 * @param operationDetails
	 * @throws ExcelException
	 */
	private void cellOperation(String param, HashMap<String, String> operationDetails) throws ExcelException {
		switch (param) {
		case "CHANGE_ATTR_CELL":
			changeAttributeCell(operationDetails);
			break;

		case "ADD_CELL":
			addCell(operationDetails);
			break;

		default:
			throw new ExcelException("This operation is not supported...");
			// break;
		}
	}

	/**
	 * Adds a cell in a sheet/row
	 * 
	 * @param operationDetails
	 * @throws ExcelException
	 */
	private void addCell(HashMap<String, String> operationDetails) throws ExcelException {
		String sheetName = "";
		int rowIndex = 0;
		int colIndex = 0;
		if (operationDetails.containsKey("SHEET_NAME")) {
			sheetName = operationDetails.get("SHEET_NAME");
		} else
			throw new ExcelException("Sheet name to be modified not found for the cell");
		String fileName = discoverFileName(sheetName);
		if (operationDetails.containsKey("ROW_INDEX")) {
			String rowIndexString = operationDetails.get("ROW_INDEX");
			rowIndex = Integer.parseInt(rowIndexString);
		} else
			throw new ExcelException("Row index to be modified not found for the cell");
		if (operationDetails.containsKey("COL_INDEX")) {
			String colIndexString = operationDetails.get("COL_INDEX");
			colIndex = Integer.parseInt(colIndexString);
		} else
			throw new ExcelException("Column Index to be modified not found for the cell");

		try {
			File file = null;
			if (null != fileName || !fileName.isEmpty()) {
				file = new File(fileName);
			} else
				throw new ExcelException("File name can not be empty");

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(is);
				XSSFSheet sheetToEdit = workbook.getSheet(sheetName);
				Cell cell = null;
				if (sheetToEdit.getRow(rowIndex) == null) {
					System.out.println("Generating row automatically...");
					sheetToEdit.createRow(rowIndex);
				}
				cell = sheetToEdit.getRow(rowIndex).createCell(colIndex);
				if (operationDetails.containsKey("CELL_TEXT"))
					cell.setCellValue(operationDetails.get("CELL_TEXT"));
				if (operationDetails.containsKey("CELL_COLORS")) {
					XSSFCellStyle style1 = workbook.createCellStyle();
					Color rgb = hex2Rgb(operationDetails.get("CELL_COLORS"));
					style1.setFillForegroundColor(new XSSFColor(rgb));
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					cell.setCellStyle(style1);
					// cell.getRow().setRowStyle(style1);
				}
				if (operationDetails.containsKey("CELL_COMMENTS")) {
					createCellComment(cell, operationDetails.get("CELL_COMMENTS"), workbook);
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();

			} else {
				throw new ExcelException("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifies the attributes for a cell
	 * 
	 * @param operationDetails
	 * @throws ExcelException
	 */
	private void changeAttributeCell(HashMap<String, String> operationDetails) throws ExcelException {
		String attributeName = "";
		int rowIndex = 0;
		int colIndex = 0;
		String newValue = "";
		String sheetName = "";
		if (operationDetails.containsKey("ATTR_NAME")) {
			attributeName = operationDetails.get("ATTR_NAME");
		} else
			throw new ExcelException("Attribute to be modified not found for the cell");
		if (operationDetails.containsKey("SHEET_NAME")) {
			sheetName = operationDetails.get("SHEET_NAME");
		} else
			throw new ExcelException("Sheet name to be modified not found for the cell");
		String fileName = discoverFileName(sheetName);
		if (operationDetails.containsKey("ROW_INDEX")) {
			String rowIndexString = operationDetails.get("ROW_INDEX");
			rowIndex = Integer.parseInt(rowIndexString);
		} else
			throw new ExcelException("Row index to be modified not found for the cell");
		if (operationDetails.containsKey("COL_INDEX")) {
			String colIndexString = operationDetails.get("COL_INDEX");
			colIndex = Integer.parseInt(colIndexString);
		} else
			throw new ExcelException("Column Index to be modified not found for the cell");
		if (operationDetails.containsKey("NEW_VALUE")) {
			newValue = operationDetails.get("NEW_VALUE");
		} else
			throw new ExcelException("New value to be inserted not found for the cell");

		XSSFWorkbook workbook = null;

		try {
			File file = null;
			if (null != fileName && !fileName.isEmpty()) {
				file = new File(fileName);
			} else
				throw new ExcelException("File name can not be empty");

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				workbook = new XSSFWorkbook(is);
				XSSFSheet sheetToEdit = workbook.getSheet(sheetName);
				if (sheetToEdit.getRow(rowIndex) != null) {
					if (sheetToEdit.getRow(rowIndex).getCell(colIndex) != null) {
						Cell cellToEdit = sheetToEdit.getRow(rowIndex).getCell(colIndex);
						switch (attributeName) {
						case "text":
							cellToEdit.setCellValue(newValue);
							break;

						case "backgroundColor":
							XSSFCellStyle style1 = workbook.createCellStyle();
							Color rgb = hex2Rgb(newValue);
							style1.setFillForegroundColor(new XSSFColor(rgb));
							style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
							cellToEdit.setCellStyle(style1);
							break;

						case "cellComments":
							createCellComment(cellToEdit, newValue, workbook);
							break;

						default:
							break;
						}

						FileOutputStream fileOutputStream = new FileOutputStream(file);
						workbook.write(fileOutputStream);
						fileOutputStream.close();
					} else {
						throw new ExcelException(
								"Cell not found to edit. The cell must already exist in the file before editing...");
					}
				} else {
					throw new ExcelException(
							"Cell not found to edit. The cell must already exist in the file before editing...");
				}

			} else {
				throw new ExcelException("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create Cell comments
	 * 
	 * @param cellToEdit
	 * @param newValue
	 * @param workbook
	 */
	private void createCellComment(Cell cellToEdit, String newValue, XSSFWorkbook workbook) {
		if (cellToEdit.getSheet() instanceof XSSFSheet) {
			CreationHelper factory = workbook.getCreationHelper();
			Drawing drawing = cellToEdit.getSheet().createDrawingPatriarch();

			ClientAnchor anchor = factory.createClientAnchor();
			Comment comment = drawing.createCellComment(anchor);
			RichTextString string = factory.createRichTextString(newValue);
			comment.setString(string);
			// comment.setAuthor("Srijani");
			cellToEdit.setCellComment(comment);
		}
	}

	/**
	 * 
	 * @param colorStr
	 *            e.g. "#FFFFFF"
	 * @return
	 * @throws ExcelException
	 */
	public static Color hex2Rgb(String colorStr) throws ExcelException {
		Color color = null;
		try {
			color = new Color(Integer.valueOf(colorStr.substring(1, 3), 16),
					Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(colorStr.substring(5, 7), 16));
		} catch (Exception e) {
			throw new ExcelException("Color format is wrong. Please input #FF0000 for color:Red");
		}
		return color;
	}

	/**
	 * ROW OPERATIONS, ADD_ROW & DELETE_ROW
	 * 
	 * @param string
	 * @param object
	 * @throws ExcelException
	 */
	private void rowOperation(String string, Object object) throws ExcelException {
		switch (string) {
		case "ADD_ROW":
			if (object instanceof HashMap<?, ?>)
				addRow((HashMap<String, String>) object);
			else
				throw new ExcelException("Exception!");
			break;

		default:
			throw new ExcelException("This operation is not supported..");
		}
	}

	/**
	 * Adds a row to a sheet
	 * 
	 * @param object
	 * @throws ExcelException
	 */
	private void addRow(HashMap<String, String> object) throws ExcelException {
		HashMap<String, String> rowDataMap = object;
		String color = "";
		if (rowDataMap != null) {
			if (rowDataMap.containsKey("ROW_COLOR")) {
				color = rowDataMap.get("ROW_COLOR");
			}
		}
		String sheetName = "";
		if (object.containsKey("SHEET_NAME")) {
			sheetName = object.get("SHEET_NAME");
		} else
			throw new ExcelException("Sheet name to be modified not found for the cell");

		String fileName = discoverFileName(sheetName);
		try {
			File file = null;
			if (null != fileName || !fileName.isEmpty()) {
				file = new File(fileName);
			} else
				throw new ExcelException("File name can not be empty");

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(is);
				XSSFSheet sheetToEdit = workbook.getSheet(sheetName);

				Row newRow = sheetToEdit.createRow(sheetToEdit.getLastRowNum() + 1);
				XSSFCellStyle style1 = workbook.createCellStyle();
				if (color != null) {
					Color rgb = hex2Rgb(color);
					style1.setFillForegroundColor(new XSSFColor(rgb));
					style1.setFillPattern(CellStyle.SOLID_FOREGROUND);
					newRow.setRowStyle(style1);
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();

			} else {
				throw new ExcelException("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * SHEET OPERATIONS, ADD_SHEET & DELETE_SHEET
	 * 
	 * @param string
	 * @param object
	 * @param object
	 * @throws ExcelException
	 */
	private void sheetOperation(String string, HashMap<String, String> object) throws ExcelException {
		HashMap<String, String> sheetDataMap = object;
		String sheetName = "";
		int sheetId = 0;
		if (null != sheetDataMap) {
			if (sheetDataMap.containsKey("SHEET_NAME"))
				if (sheetDataMap.get("SHEET_NAME") instanceof String)
					sheetName = (String) sheetDataMap.get("SHEET_NAME");
				else
					throw new ExcelException("SHEET NAME NOT READBLE...");
		}

		switch (string) {
		case "ADD_SHEET":
			createSheet(sheetName, sheetId);
			break;

		case "DELETE_SHEET":
			deleteSheet(sheetName, sheetId);
			break;

		default:
			break;
		}
	}

	/**
	 * Deletes a sheet in excel file
	 * 
	 * @param sheetName
	 * @param sheetId
	 * @throws ExcelException
	 */
	private void deleteSheet(String sheetName, int sheetId) throws ExcelException {
		try {

			File file;
			if (null != this.file) {
				file = new File(this.file); // deals with new files
			} else {
				file = new File(discoverFileName(sheetName)); // deals with existing files
			}

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(is);

				for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
					if (workbook.getSheetName(sheetIndex).equals(sheetName))
						workbook.removeSheetAt(sheetIndex);
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			} else {
				throw new ExcelException("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Creates sheet in a excel file
	 * 
	 * @param sheetName
	 * @param sheedId
	 * @throws ExcelException
	 */
	private void createSheet(String sheetName, int sheedId) throws ExcelException {
		try {
			File file;
			if (null != this.file) {
				file = new File(this.file);
			} else {
				file = new File(discoverFileName(sheetName));
			}

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(is);
				workbook.createSheet(sheetName);

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			} else {
				throw new ExcelException("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds file name when it is not the operational delta
	 * 
	 * @param sheetName
	 * 
	 * @return
	 */
	private String discoverFileName(String sheetName) {
		// iterate through all the operations.
		for (ExcelOperationsBean excelOps : excelOperations) {
			if (excelOps.getOperationName().equals("ADD_FILE_SHEET_EDGE")
					|| excelOps.getOperationName().equals("DELETE_FILE_SHEET_EDGE")) {
				HashMap<String, String> map = excelOps.getOperationDetails();

				if (map.get("TRG").equals(sheetName)) {
					return (String) map.get("SRC");
				}

			}
		}
		return "";
	}

	/**
	 * ADD_FILE & DELETE_FILE
	 * 
	 * @param string
	 * @param object
	 * @throws ExcelException
	 */
	private void fileOperation(String string, Object object) throws ExcelException {
		HashMap<String, Object> fileDataMap = (HashMap<String, Object>) object;
		String fileName = "";
		String filePath = "";
		if (null != fileDataMap) {
			if (fileDataMap.containsKey("FILE_NAME")) {
				if (fileDataMap.get("FILE_NAME") instanceof String)
					fileName = (String) fileDataMap.get("FILE_NAME");
				else
					throw new ExcelException("FILE NAME NOT READBLE...");
			}
			if (fileDataMap.containsKey("FILE_PATH")) {
				if (fileDataMap.get("FILE_PATH") instanceof String)
					filePath = (String) fileDataMap.get("FILE_PATH");
				else
					throw new ExcelException("FILE PATH NOT READBLE...");
			}
		}
		switch (string) {
		case "ADD_FILE":
			createFile(fileName, filePath);
			break;
		case "DELETE_FILE":
			// TODO
			break;
		default:
			break;
		}
	}

	/**
	 * Creates a new file
	 * 
	 * @param fileName
	 * @param filePath
	 * @throws ExcelException
	 */
	private void createFile(String fileName, String filePath) throws ExcelException {
		File file = new File(filePath + "\\" + fileName);
		if (file.exists()) {
			throw new ExcelException("File already exists!");
		} else {
			this.file = filePath + "\\" + fileName;
			System.out.println("Creating new file...");
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

			try {
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				xssfWorkbook.write(fileOutputStream);
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
