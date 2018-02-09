/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kaleidoscope.core.auxiliary.simpleexcel.utils.UnableToEditExcelFile;

/**
 * @author Srijani
 *
 */
public class ExcelDelta {

	private Path filePath;
	private XSSFWorkbook workbook;
	private String file;

	private List<List<Object>> excelOperations;
	private List<List<Object>> excelOperationsAddNodes;
	private List<List<Object>> excelOperationsDeleteNodes;
	private List<List<Object>> excelOperationsAddEdges;
	private List<List<Object>> excelOperationsDeleteEdges;

	/**
	 * @param path
	 * @param operationList2
	 */
	public ExcelDelta(List<List<Object>> excelOperations) {
		// this.filePath = path;
		this.excelOperations = excelOperations;
		for (List<Object> list : excelOperations) {
			if (list.get(0).equals("ADD_FILE")) {
				if (list.get(1) instanceof Simpleexcel.File) {
					String fileName = ((Simpleexcel.File) (list.get(1))).getFileName();
					String filePath = ((Simpleexcel.File) (list.get(1))).getPath();
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
		for (List<Object> list : excelOperations) {
			String opName = list.get(0).toString();
			switch (opName) {
			case "ADD_NODE":
				excelOperationsAddNodes.add(list);
				break;

			case "ADD_EDGE":
				excelOperationsAddEdges.add(list);
				break;

			case "DELET_NODE":
				excelOperationsDeleteNodes.add(list);
				break;

			case "DELETE_EDGE":
				excelOperationsDeleteEdges.add(list);
				break;

			default:
				break;
			}
		}
	}

	/**
	 * Entry point for this class
	 * 
	 * @throws UnableToEditExcelFile
	 */
	public void execute() throws UnableToEditExcelFile {
		System.out.println("Printing excel operations");
		for (List<Object> list : excelOperations) {
			String operationName = list.get(0).toString();
			System.out.println(operationName);
			switch (operationName) {
			case "ADD_FILE":
				fileOperation("ADD_FILE", list.get(1));
				break;

			case "ADD_SHEET":
				sheetOperation("ADD_SHEET", list.get(1));
				break;

			case "DELETE_SHEET":
				sheetOperation("DELETE_SHEET", list.get(1));
				break;

			case "ADD_ROW":
				rowOperation("ADD_ROW", null);
				break;

			case "ADD_CELL":
				break;

			default:
				System.out.println("OPERATION NOT FOUND IN EXCEL API");
				break;
			}
		}

	}

	/**
	 * ROW OPERATIONS, ADD_ROW & DELETE_ROW
	 * 
	 * @param string
	 * @param object
	 */
	private void rowOperation(String string, Object object) {
		// at this moment, there is nothing in the object.

		switch (string) {
		case "ADD_ROW":

			break;

		case "DELETE_ROW":

			break;

		default:
			break;
		}
	}

	/**
	 * SHEET OPERATIONS, ADD_SHEET & DELETE_SHEET
	 * 
	 * @param string
	 * @param object
	 * @throws UnableToEditExcelFile
	 */
	private void sheetOperation(String string, Object object) throws UnableToEditExcelFile {
		HashMap<String, Object> sheetDataMap = (HashMap<String, Object>) object;
		String sheetName = "";
		int sheetId = 0;
		if (null != sheetDataMap) {
			if (sheetDataMap.containsKey("SHEET_NAME"))
				if (sheetDataMap.get("SHEET_NAME") instanceof String)
					sheetName = (String) sheetDataMap.get("SHEET_NAME");
				else
					throw new UnableToEditExcelFile("SHEET NAME NOT READBLE...");
			if (sheetDataMap.containsKey("SHEET_ID"))
				if (sheetDataMap.get("SHEET_ID") instanceof Integer)
					sheetId = (int) sheetDataMap.get("SHEET_ID");
				else
					throw new UnableToEditExcelFile("SHEET ID NOT READBLE...");
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
	 * @throws UnableToEditExcelFile
	 */
	private void deleteSheet(String sheetName, int sheetId) throws UnableToEditExcelFile {
		try {

			File file = new File(this.file);
			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				workbook = new XSSFWorkbook(is);

				for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
					if (workbook.getSheetName(sheetIndex).equals(sheetName))
						workbook.removeSheetAt(sheetIndex);
				}

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			} else {
				throw new UnableToEditExcelFile("FILE NOT FOUND..");
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
	 * @throws UnableToEditExcelFile
	 */
	private void createSheet(String sheetName, int sheedId) throws UnableToEditExcelFile {
		try {
			File file;
			if (null != this.file) {
				file = new File(this.file);
			} else {
				file = new File(discoverFileName(sheetName));
			}

			if (file.exists()) {
				final InputStream is = new FileInputStream(file);
				workbook = new XSSFWorkbook(is);
				workbook.createSheet(sheetName);

				FileOutputStream fileOutputStream = new FileOutputStream(file);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
			} else {
				throw new UnableToEditExcelFile("FILE NOT FOUND..");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		for (List<Object> excelOps : excelOperations) {
			if (excelOps.get(0).equals("ADD_FILE_SHEET_EDGE")) {
				HashMap<String, Object> map = (HashMap<String, Object>) excelOps.get(1);

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
	 * @throws UnableToEditExcelFile
	 */
	private void fileOperation(String string, Object object) throws UnableToEditExcelFile {
		HashMap<String, Object> fileDataMap = (HashMap<String, Object>) object;
		String fileName = "";
		String filePath = "";
		if (null != fileDataMap) {
			if (fileDataMap.containsKey("FILE_NAME")) {
				if (fileDataMap.get("FILE_NAME") instanceof String)
					fileName = (String) fileDataMap.get("FILE_NAME");
				else
					throw new UnableToEditExcelFile("FILE NAME NOT READBLE...");
			}
			if (fileDataMap.containsKey("FILE_PATH")) {
				if (fileDataMap.get("FILE_PATH") instanceof String)
					filePath = (String) fileDataMap.get("FILE_PATH");
				else
					throw new UnableToEditExcelFile("FILE PATH NOT READBLE...");
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
	 * @throws UnableToEditExcelFile
	 */
	private void createFile(String fileName, String filePath) throws UnableToEditExcelFile {
		File file = new File(filePath + "\\" + fileName);
		if (file.exists()) {
			throw new UnableToEditExcelFile("File already exists!");
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
