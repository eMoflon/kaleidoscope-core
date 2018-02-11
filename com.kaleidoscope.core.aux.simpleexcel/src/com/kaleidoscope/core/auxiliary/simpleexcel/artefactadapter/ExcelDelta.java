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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kaleidoscope.core.auxiliary.simpleexcel.bean.ExcelOperationsBean;
import com.kaleidoscope.core.auxiliary.simpleexcel.utils.UnableToEditExcelFile;

/**
 * @author Srijani
 *
 */
public class ExcelDelta {

	private Path filePath;
	private XSSFWorkbook workbook;
	private String file;

	private List<ExcelOperationsBean> excelOperations;
	private List<ExcelOperationsBean> excelOperationsAddNodes = new ArrayList<ExcelOperationsBean>();
	private List<ExcelOperationsBean> excelOperationsDeleteNodes = new ArrayList<ExcelOperationsBean>();;
	private List<ExcelOperationsBean> excelOperationsAddEdges = new ArrayList<ExcelOperationsBean>();;
	private List<ExcelOperationsBean> excelOperationsDeleteEdges = new ArrayList<ExcelOperationsBean>();;

	/**
	 * @param path
	 * @param operationList2
	 */
	public ExcelDelta(List<ExcelOperationsBean> excelOperations) {
		// this.filePath = path;
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
			//ADD EDGE
			if(opName.startsWith("ADD_") && opName.endsWith("_EDGE")) {
				excelOperationsAddEdges.add(excelOperationsBean);
			}
			
			//ADD NODE
			if(opName.startsWith("ADD_") && !opName.endsWith("_EDGE")) {
				excelOperationsAddNodes.add(excelOperationsBean);
			}
			
			//DELETE EDGE
			if(opName.startsWith("DELETE_") && opName.endsWith("_EDGE")) {
				excelOperationsDeleteEdges.add(excelOperationsBean);
			}
			
			//DELETE NODE
			if(opName.startsWith("DELETE_") && !opName.endsWith("_EDGE")) {
				excelOperationsDeleteNodes.add(excelOperationsBean);
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
	 * @throws UnableToEditExcelFile 
	 */
	private void rowOperation(String string, Object object) throws UnableToEditExcelFile {
		// at this moment, there is nothing in the object.

		switch (string) {
		case "ADD_ROW":
			addRow();
			break;

		case "DELETE_ROW":

			break;

		default:
			break;
		}
	}

	private void addRow() throws UnableToEditExcelFile {
		//find sheet name
		for (ExcelOperationsBean edge : excelOperationsAddEdges) {
			if(edge.getOperationName().equals("ADD_SHEET_ROW_EDGE")) {
				HashMap<String, String> edgeData = edge.getOperationDetails();
				String sheetName = edgeData.get("SRC");
				String rowInfo = edgeData.get("TRG");
				//append a new row in a sheet
				if(rowInfo.equals("")) {
					try {

						File file;
						if (null != this.file) {
							file = new File(this.file); // deals with new files
						} else {
							file = new File(discoverFileName(sheetName)); // deals with existing files
						}

						if (file.exists()) {
							final InputStream is = new FileInputStream(file);
							workbook = new XSSFWorkbook(is);
							
							

							for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
								if (workbook.getSheetName(sheetIndex).equals(sheetName)) {
									XSSFSheet sheetToEdit = workbook.getSheet(sheetName);
									
									int maxRow = sheetToEdit.getLastRowNum();
									Row row = null;
									if(maxRow!=0)
										row = sheetToEdit.createRow(maxRow+1);
									else
										row = sheetToEdit.createRow(maxRow);
									Cell cell = row.createCell(0);
									cell.setCellValue("HELLO");
								}
									
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
			}
		}
	}

	/**
	 * SHEET OPERATIONS, ADD_SHEET & DELETE_SHEET
	 * 
	 * @param string
	 * @param object 
	 * @param object
	 * @throws UnableToEditExcelFile
	 */
	private void sheetOperation(String string, HashMap<String, String> object) throws UnableToEditExcelFile {
		HashMap<String, String> sheetDataMap = object;
		String sheetName = "";
		int sheetId = 0;
		if (null != sheetDataMap) {
			if (sheetDataMap.containsKey("SHEET_NAME"))
				if (sheetDataMap.get("SHEET_NAME") instanceof String)
					sheetName = (String) sheetDataMap.get("SHEET_NAME");
				else
					throw new UnableToEditExcelFile("SHEET NAME NOT READBLE...");
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

			File file;
			if (null != this.file) {
				file = new File(this.file); // deals with new files
			} else {
				file = new File(discoverFileName(sheetName)); // deals with existing files
			}

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
			if (excelOps.getOperationName().equals("ADD_FILE_SHEET_EDGE") || excelOps.getOperationName().equals("DELETE_FILE_SHEET_EDGE")) {
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
