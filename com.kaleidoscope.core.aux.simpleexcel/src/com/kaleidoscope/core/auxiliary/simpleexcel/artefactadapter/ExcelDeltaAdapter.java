/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.auxiliary.simpleexcel.bean.ExcelOperationsBean;
import com.kaleidoscope.core.auxiliary.simpleexcel.utils.ExcelException;
import com.kaleidoscope.core.delta.javabased.operational.AddEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.AddNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.Operation;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaOutputAdapter;

import Simpleexcel.Cell;
import Simpleexcel.Column;
import Simpleexcel.File;
import Simpleexcel.Row;
import Simpleexcel.Sheet;

/**
 * @author Srijani
 *
 */
public class ExcelDeltaAdapter implements DeltaOutputAdapter<OperationalDelta, ExcelDelta, Path> {

	List<Operation> operations = new ArrayList<Operation>();
	List<Operation> sortedOperationsEMF = new ArrayList<Operation>();
	List<Operation> sortedOperationsExcelPOI = new ArrayList<Operation>();
	List<ExcelOperationsBean> excelOperations = new ArrayList<ExcelOperationsBean>();

	// file and sheet
	private List<Operation> fileNodeAddDeleteOperations = new ArrayList<Operation>();
	private List<Operation> sheetNodeAddDeleteOperations = new ArrayList<Operation>();
	private List<Operation> fileToSheetEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	// node
	private List<Operation> cellNodeAddDeleteOperations = new ArrayList<Operation>();
	private List<Operation> sheetToCellEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	// row
	private List<Operation> rowNodeAddDeleteOperations = new ArrayList<Operation>();
	private List<Operation> sheetToRowEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	// row --> cell
	private List<Operation> rowToCellEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	private List<Operation> sheetChangeAttrOperation = new ArrayList<Operation>();
	private List<Operation> cellChangeAttrOperation = new ArrayList<Operation>();
	
	// sheet --> cols
	private List<Operation> sheetToColEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	@Override
	public ExcelDelta unparse(OperationalDelta od, Path path) {

		try {

			// get the operations in list
			operations = od.getOperations();

			classifyOperations();

			// sort the operations - EMF
			sortOperationsForEMF();

			// sort again for EXCEL API
			translateSortedOperationsForExcelApi();

			// assign excel tasks in order
			convertToExcelAssignments();
		} catch (ExcelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// connect with ExcelDelta
		ExcelDelta excelDelta = new ExcelDelta(excelOperations);
		return excelDelta;
	}

	/**
	 * This method takes sortedOperationsExcelPOI list and convert it to
	 * corresponding excel tasks
	 * 
	 * @throws ExcelException
	 */
	private void convertToExcelAssignments() throws ExcelException {
		for (Operation operation : sortedOperationsExcelPOI) {
			ExcelOperationsBean excelOperationsBean = null;

			if (operation instanceof AddNodeOp)
				excelOperationsBean = addAddNodeOperations(operation, excelOperationsBean);

			if (operation instanceof DeleteNodeOp)
				excelOperationsBean = addDeleteNodeOperations(operation, excelOperationsBean);

			if (operation instanceof AddEdgeOp)
				excelOperationsBean = addAddEdgeOperations(operation, excelOperationsBean);

			if (operation instanceof DeleteEdgeOp)
				excelOperationsBean = addDeleteEdgeOperations(operation, excelOperationsBean);

			if (operation instanceof AttributeChangeOp)
				excelOperationsBean = addAttributeChangeOperations(operation, excelOperationsBean);

			if (null != excelOperationsBean)
				excelOperations.add(excelOperationsBean);
		}
	}

	/**
	 * Attribute change operation translation
	 * 
	 * @param operation
	 * @param excelOperationsBean
	 * @return
	 * @throws ExcelException
	 */
	private ExcelOperationsBean addAttributeChangeOperations(Operation operation,
			ExcelOperationsBean excelOperationsBean) throws ExcelException {
		EObject changedObject = ((AttributeChangeOp) operation).getAffectedNode();

		// =========== CHANGE CELL ============
		if (changedObject instanceof Cell) {
			Cell changedCell = (Cell) changedObject;

			// identify row
			String rowIndex = identifyIndex("ROW", changedCell);
			// identify column
			String colIndex = identifyIndex("COL", changedCell);

			String changeAttrName = ((AttributeChangeOp) operation).getAffectedAttribute().getName();
			String newValue = ((AttributeChangeOp) operation).getNewValue().toString();

			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("CHANGE_ATTR_CELL");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			innerMap.put("ATTR_NAME", changeAttrName);
			innerMap.put("SHEET_NAME", changedCell.getRow().getSheet().getSheetName());
			innerMap.put("NEW_VALUE", newValue);
			innerMap.put("ROW_INDEX", rowIndex);
			innerMap.put("COL_INDEX", colIndex);
			
			excelOperationsBean.setOperationDetails(innerMap);
		} else {
			// ============= CHANGE SHEET ===============
			if (changedObject instanceof Sheet) {
				// TODO
			} else {
				throw new ExcelException(
						"Change attribute for anything except sheets and cells are not allowed..");
			}
		}

		return excelOperationsBean;
	}

	/**
	 * Returns the index of a row or column based on the param. param can be either
	 * 'ROW' or 'COL'
	 * 
	 * @param string
	 * @param changedCell
	 * @param sheetToRowEdgeAddAndDeleteOperations2
	 * @return
	 */
	private String identifyIndex(String param, Cell changedCell) {
		Sheet sheet = changedCell.getRow().getSheet();

		if (param.equals("ROW")) {
			Row firstRow = getFirstAndLastRows(sheet).get(0);
			int rowIndex = 0;
			if (firstRow != null) {
				Row tempRow = firstRow;
				int counter = 0;
				while (tempRow != null) {
					if (tempRow == changedCell.getRow()) {
						rowIndex = counter;
						break;
					}
					tempRow = tempRow.getNextRow();
					counter++;
				}
			}

			return rowIndex + "";
		}
		
		if (param.equals("COL")) {
			Column firstColumn = getFirstAndLastColumns(sheet).get(0);
			int colIndex = 0;
			if (firstColumn != null) {
				Column tempCol = firstColumn;
				int counter = 0;
				while (tempCol != null) {
					if (tempCol == changedCell.getColumn()) {
						colIndex = counter;
						break;
					}
					tempCol = tempCol.getNextColumn();
					counter++;
				}
			}

			return colIndex + "";
		}
		
		return null;
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
	 * DELETE EDGE OPERATIONS TRANSLATION
	 * 
	 * @param operation
	 * @param excelOperationsBean
	 * @return
	 */
	private ExcelOperationsBean addDeleteEdgeOperations(Operation operation, ExcelOperationsBean excelOperationsBean) {
		EObject src = ((DeleteEdgeOp) operation).getEdge().getSrc();
		EObject trg = ((DeleteEdgeOp) operation).getEdge().getTrg();

		// ============== DELETE FILE-->SHEET EDGE =================
		if (src instanceof Simpleexcel.File && trg instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_FILE_SHEET_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			String fileName = ((Simpleexcel.File) ((DeleteEdgeOp) operation).getEdge().getSrc()).getFileName();
			String path = ((Simpleexcel.File) ((DeleteEdgeOp) operation).getEdge().getSrc()).getPath();
			if (path != null && !path.isEmpty() && !path.equals(fileName)) {
				innerMap.put("SRC", path + "\\" + fileName);
			} else
				innerMap.put("SRC", fileName);
			innerMap.put("TRG", ((Simpleexcel.Sheet) ((DeleteEdgeOp) operation).getEdge().getTrg()).getSheetName());
			excelOperationsBean.setOperationDetails(innerMap);
		}

		// ============== DELETE SHEET-->ROW EDGE =================
		if (src instanceof Simpleexcel.File && trg instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_SHEET_ROW_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);
		}

		// ============== DELETE ROW-->CELL EDGE =================
		if (src instanceof Simpleexcel.File && trg instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_ROW_CELL_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);
		}

		return excelOperationsBean;
	}

	/**
	 * ADD EDGE OPERATIONS TRANSLATION
	 * 
	 * @param operation
	 * @param excelOperationsBean
	 * @return
	 */
	private ExcelOperationsBean addAddEdgeOperations(Operation operation, ExcelOperationsBean excelOperationsBean) {
		EObject src = ((AddEdgeOp) operation).getEdge().getSrc();
		EObject trg = ((AddEdgeOp) operation).getEdge().getTrg();

		// ============== ADD FILE-->SHEET EDGE =================

		if (src instanceof Simpleexcel.File && trg instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_FILE_SHEET_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			String fileName = ((Simpleexcel.File) ((AddEdgeOp) operation).getEdge().getSrc()).getFileName();
			String path = ((Simpleexcel.File) ((AddEdgeOp) operation).getEdge().getSrc()).getPath();
			if (path != null && !path.isEmpty() && !path.equals(fileName)) {
				innerMap.put("SRC", path + "\\" + fileName);
			} else
				innerMap.put("SRC", fileName);
			innerMap.put("TRG", ((Simpleexcel.Sheet) ((AddEdgeOp) operation).getEdge().getTrg()).getSheetName());
			excelOperationsBean.setOperationDetails(innerMap);

		}

		// ============== ADD SHEET-->ROW EDGE =================

		if (src instanceof Simpleexcel.Sheet && trg instanceof Row) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_SHEET_ROW_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			String sheetName = ((Simpleexcel.Sheet) ((AddEdgeOp) operation).getEdge().getSrc()).getSheetName();
			innerMap.put("SRC", sheetName);
			innerMap.put("TRG", ""); // just add new row. no other info
			excelOperationsBean.setOperationDetails(innerMap);

		}

		// ============== ADD ROW-->CELL EDGE =================

		if (src instanceof Row && trg instanceof Simpleexcel.Cell) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_ROW_CELL_EDGE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);

		}

		return excelOperationsBean;
	}

	/**
	 * DELETE NODE OPERATIONS TRANSLATION
	 * 
	 * @param operation
	 * @param excelOperationsBean
	 * @return
	 */
	private ExcelOperationsBean addDeleteNodeOperations(Operation operation, ExcelOperationsBean excelOperationsBean) {
		// ============== DELETE SHEET =================
		if (((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_SHEET");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			innerMap.put("SHEET_NAME", ((Simpleexcel.Sheet) ((DeleteNodeOp) operation).getNode()).getSheetName());
			excelOperationsBean.setOperationDetails(innerMap);
		}

		// ============== DELETE ROW =================
		if (((DeleteNodeOp) operation).getNode() instanceof Row) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_ROW");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);
		}

		// ============== DELETE CELL =================
		if (((DeleteNodeOp) operation).getNode() instanceof Row) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("DELETE_CELL");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);
		}

		return excelOperationsBean;
	}

	/**
	 * ADD NODE OPERATIONS TRANSLATION
	 * 
	 * @param operation
	 * @param excelOperationsBean
	 * @return
	 */
	private ExcelOperationsBean addAddNodeOperations(Operation operation, ExcelOperationsBean excelOperationsBean) {

		// ============== ADD FILE =================
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.File) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_FILE");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			innerMap.put("FILE_NAME", ((Simpleexcel.File) ((AddNodeOp) operation).getNode()).getFileName());
			innerMap.put("FILE_PATH", ((Simpleexcel.File) ((AddNodeOp) operation).getNode()).getPath());
			excelOperationsBean.setOperationDetails(innerMap);
		}
		// ============== ADD SHEET =================
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_SHEET");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			innerMap.put("SHEET_NAME", ((Simpleexcel.Sheet) ((AddNodeOp) operation).getNode()).getSheetName());
			excelOperationsBean.setOperationDetails(innerMap);
		}

		// ============== ADD ROW =================
		if (((AddNodeOp) operation).getNode() instanceof Row) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_ROW");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			excelOperationsBean.setOperationDetails(innerMap);
		}
		// ============== ADD CELL =================
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
			excelOperationsBean = new ExcelOperationsBean();
			excelOperationsBean.setOperationName("ADD_CELL");
			HashMap<String, String> innerMap = new HashMap<String, String>();
			innerMap.put("CELL_TEXT", ((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getText());
			innerMap.put("CELL_COMMENTS", ((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getCellComments());
			innerMap.put("CELL_COLORS", ((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getBackgroundColor());
		}

		return excelOperationsBean;

	}

	/**
	 * Sorted for being usable by POI API
	 */
	private void translateSortedOperationsForExcelApi() {

		// create file
		sortedOperationsExcelPOI.addAll(fileNodeAddDeleteOperations);

		// create sheets
		sortedOperationsExcelPOI.addAll(sheetNodeAddDeleteOperations);
		sortedOperationsExcelPOI.addAll(fileToSheetEdgeAddAndDeleteOperations);
		sortedOperationsExcelPOI.addAll(sheetChangeAttrOperation);

		// create rows
		sortedOperationsExcelPOI.addAll(rowNodeAddDeleteOperations);
		sortedOperationsExcelPOI.addAll(sheetToRowEdgeAddAndDeleteOperations);

		// create cells
		sortedOperationsExcelPOI.addAll(cellNodeAddDeleteOperations);
		sortedOperationsExcelPOI.addAll(rowToCellEdgeAddAndDeleteOperations);
		sortedOperationsExcelPOI.addAll(cellChangeAttrOperation);

		printOperationsFromList(sortedOperationsExcelPOI, "Sorted operations for EXCEL");

	}

	/**
	 * Sort the operations to make sense for EMF
	 */
	private void classifyOperations() {
		// printOperationsFromList(operations, "Original List");

		for (Operation operation : operations) {
			System.out.println(operation);

			if (operation instanceof AddNodeOp)
				classifyAddNodeOps(operation);

			if (operation instanceof AddEdgeOp)
				classifyAddEdgeOps(operation);

			if (operation instanceof DeleteNodeOp)
				classifyDeleteNodeOps(operation);

			if (operation instanceof DeleteEdgeOp)
				classifyDeleteEdgeOps(operation);

			if (operation instanceof AttributeChangeOp)
				classifyChangeOps(operation);

		}

		// printOperationsFromList(sortedOperationsEMF, "Sorted Operations for EMF");
	}

	/**
	 * Sort all the operations to be EMF readable
	 */
	private void sortOperationsForEMF() {
		sortedOperationsEMF.addAll(fileNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetChangeAttrOperation);
		sortedOperationsEMF.addAll(fileToSheetEdgeAddAndDeleteOperations);
		sortedOperationsEMF.addAll(cellNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(cellChangeAttrOperation);
		sortedOperationsEMF.addAll(sheetToCellEdgeAddAndDeleteOperations);
		sortedOperationsEMF.addAll(rowNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetToRowEdgeAddAndDeleteOperations);
		sortedOperationsEMF.addAll(rowToCellEdgeAddAndDeleteOperations);
	}

	/**
	 * Groups Change attribute operations
	 * 
	 * @param operation
	 */
	private void classifyChangeOps(Operation operation) {
		if (((AttributeChangeOp) operation).getAffectedNode() instanceof Simpleexcel.Cell) {
			cellChangeAttrOperation.add(operation);
		}
		if (((AttributeChangeOp) operation).getAffectedNode() instanceof Simpleexcel.Sheet) {
			sheetChangeAttrOperation.add(operation);
		}
	}

	/**
	 * Groups delete edge operations
	 * 
	 * @param operation
	 */
	private void classifyDeleteEdgeOps(Operation operation) {
		// ==========FILE->SHEET EDGE=====================
		// Delete edge
		if (((DeleteEdgeOp) operation).getEdge().getSrc() instanceof File
				&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Sheet) {
			fileToSheetEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============SHEET->CELL EDGE=================
		// Delete edge
		if (((DeleteEdgeOp) operation).getEdge().getSrc() instanceof Sheet
				&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
			sheetToCellEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============SHEET->ROW EDGE=================
		// Delete edge
		if (((DeleteEdgeOp) operation).getEdge().getSrc() instanceof Sheet
				&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Row) {
			sheetToRowEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============ROW->CELL EDGE=================
		// Delete edge
		if (((DeleteEdgeOp) operation).getEdge().getSrc() instanceof Row
				&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
			rowToCellEdgeAddAndDeleteOperations.add(operation);
		}
	}

	/**
	 * Groups delete node operations
	 * 
	 * @param operation
	 */
	private void classifyDeleteNodeOps(Operation operation) {
		// ==============FILE=================
		// delete node - file
		if (((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.File) {
			fileNodeAddDeleteOperations.add(operation);
		}
		// =============SHEET==================
		// delete node - sheet
		if (((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
			sheetNodeAddDeleteOperations.add(operation);
		}
		// =============CELL==================
		// delete node - cell
		if (((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
			cellNodeAddDeleteOperations.add(operation);
		}
		// ==============ROW=================
		// delete node - row
		if (((DeleteNodeOp) operation).getNode() instanceof Row) {
			rowNodeAddDeleteOperations.add(operation);
		}
	}

	/**
	 * Groups add edge operations
	 * 
	 * @param operation
	 */
	private void classifyAddEdgeOps(Operation operation) {
		// ==========FILE->SHEET EDGE=====================
		// add edge file--> sheet
		if (((AddEdgeOp) operation).getEdge().getSrc() instanceof File
				&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Sheet) {
			fileToSheetEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============SHEET->CELL EDGE=================
		// add edge sheet--> cell
		if (((AddEdgeOp) operation).getEdge().getSrc() instanceof Sheet
				&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
			sheetToCellEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============SHEET->ROW EDGE=================
		// add edge sheet--> row
		if (((AddEdgeOp) operation).getEdge().getSrc() instanceof Sheet
				&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Row) {
			sheetToRowEdgeAddAndDeleteOperations.add(operation);
		}
		// ==============ROW->CELL EDGE=================
		// add edge row-->cell
		if (((AddEdgeOp) operation).getEdge().getSrc() instanceof Row
				&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
			rowToCellEdgeAddAndDeleteOperations.add(operation);
		}
	}

	/**
	 * Groups add node operations
	 * 
	 * @param operation
	 */
	private void classifyAddNodeOps(Operation operation) {
		// ==============FILE=================
		// add node - file
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.File) {
			fileNodeAddDeleteOperations.add(operation);
		}
		// =============SHEET==================
		// add node - sheet
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
			sheetNodeAddDeleteOperations.add(operation);
		}
		// =============CELL==================
		// add node - cell
		if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
			cellNodeAddDeleteOperations.add(operation);
		}
		// ==============ROW=================
		// add node - row
		if (((AddNodeOp) operation).getNode() instanceof Row) {
			rowNodeAddDeleteOperations.add(operation);
		}
	}

	/**
	 * Test method to print all operations in details
	 * 
	 * @param operations2
	 * @param string
	 */
	private void printOperationsFromList(List<Operation> operations2, String string) {
		System.out.println("Printing list : " + string);

		for (Operation operation : operations2) {

			if (operation instanceof AddNodeOp) {
				System.out.println("--> Add Node --> " + ((AddNodeOp) operation).getNode());
			} else {
				if (operation instanceof AddEdgeOp) {
					System.out.println("--> Add Edge --> " + ((AddEdgeOp) operation).getEdge().getSrc() + " => "
							+ ((AddEdgeOp) operation).getEdge().getTrg());
				} else {
					if (operation instanceof DeleteNodeOp) {
						System.out.println("--> Delete Node --> " + ((DeleteNodeOp) operation).getNode());
					} else {
						if (operation instanceof DeleteEdgeOp) {
							System.out.println("--> Delete Node --> " + ((DeleteEdgeOp) operation).getEdge().getSrc()
									+ " => " + ((DeleteEdgeOp) operation).getEdge().getTrg());
						}
					}
				}
			}
		}
	}
}
