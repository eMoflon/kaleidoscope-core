/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import com.kaleidoscope.core.delta.javabased.operational.AddEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.AddNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.Operation;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaOutputAdapter;

import Delta.AddNodeOP;
import Delta.Edge;
import Delta.impl.AddNodeOPImpl;
import Simpleexcel.Cell;
import Simpleexcel.File;
import Simpleexcel.RowObject;
import Simpleexcel.Sheet;

/**
 * @author Srijani
 *
 */
public class ExcelDeltaAdapter implements DeltaOutputAdapter<OperationalDelta, ExcelDelta, Path> {

	List<Operation> operations = new ArrayList<Operation>();
	List<Operation> sortedOperationsEMF = new ArrayList<Operation>();
	List<Operation> sortedOperationsExcelPOI = new ArrayList<Operation>();
	List<List<Object>> excelOperations = new ArrayList<List<Object>>();

	private List<Operation> fileNodeAddDeleteOperations = new ArrayList<Operation>();
	private List<Operation> sheetNodeAddDeleteOperations = new ArrayList<Operation>();

	private List<Operation> fileToSheetEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	private List<Operation> cellNodeAddDeleteOperations = new ArrayList<Operation>();

	private List<Operation> sheetToCellEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	private List<Operation> rowNodeAddDeleteOperations = new ArrayList<Operation>();

	private List<Operation> sheetToRowEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	private List<Operation> rowToCellEdgeAddAndDeleteOperations = new ArrayList<Operation>();

	@Override
	public ExcelDelta unparse(OperationalDelta od, Path path) {

		// get the operations in list
		operations = od.getOperations();

		// sort the operations - EMF
		sortOperations();

		// sort again for EXCEL API
		translateSortedOperationsForExcelApi();

		// assign excel tasks in order
		convertToExcelAssignments();

		// connect with ExcelDelta
		// ExcelDelta excelDelta = new ExcelDelta(path, excelOperations);
		ExcelDelta excelDelta = new ExcelDelta(excelOperations);
		return excelDelta;
	}

	/**
	 * This method takes sortedOperationsExcelPOI list and convert it to
	 * corresponding excel tasks
	 */
	private void convertToExcelAssignments() {
		for (Operation operation : sortedOperationsExcelPOI) {
			List<Object> innerOperations = new ArrayList<Object>();

			// ================ ADD NODE ===================
			if (operation instanceof AddNodeOp) {
				// ============== ADD FILE =================
				if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.File) {
					innerOperations.add("ADD_FILE");
					HashMap<String, String> innerMap = new HashMap<String, String>();
					innerMap.put("FILE_NAME", ((Simpleexcel.File) ((AddNodeOp) operation).getNode()).getFileName());
					innerMap.put("FILE_PATH", ((Simpleexcel.File) ((AddNodeOp) operation).getNode()).getPath());

					innerOperations.add(innerMap);
				}
				// ============== ADD SHEET =================
				if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
					innerOperations.add("ADD_SHEET");
					HashMap<String, Object> innerMap = new HashMap<String, Object>();
					innerMap.put("SHEET_NAME", ((Simpleexcel.Sheet) ((AddNodeOp) operation).getNode()).getSheetName());
					innerMap.put("SHEET_ID", ((Simpleexcel.Sheet) ((AddNodeOp) operation).getNode()).getSheetId());

					innerOperations.add(innerMap);
				}

				// ============== ADD ROW =================
				if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.RowObject) {
					innerOperations.add("ADD_ROW");
				}
				// ============== ADD CELL =================
				if (((AddNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
					innerOperations.add("ADD_CELL");
					HashMap<String, Object> innerMap = new HashMap<String, Object>();
					innerMap.put("CELL_TEXT", ((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getText());
					innerMap.put("CELL_ID", ((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getCellId());
					innerMap.put("CELL_COMMENTS",
							((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getCellComments());
					innerMap.put("CELL_COLOR",
							((Simpleexcel.Cell) ((AddNodeOp) operation).getNode()).getBackgroundColor());

					innerOperations.add(innerMap);
				}
			} else {
				// Delete nodes
				if (operation instanceof DeleteNodeOp) {
					// ============== DELETE SHEET =================
					if (((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
						innerOperations.add("DELETE_SHEET");
						HashMap<String, Object> innerMap = new HashMap<String, Object>();
						innerMap.put("SHEET_NAME",
								((Simpleexcel.Sheet) ((DeleteNodeOp) operation).getNode()).getSheetName());

						innerOperations.add(innerMap);
					}
				} else {
					// Add edges
					if (operation instanceof AddEdgeOp) {
						// ============== ADD FILE-->SHEET EDGE =================
						EObject src = ((AddEdgeOp) operation).getEdge().getSrc();
						EObject trg = ((AddEdgeOp) operation).getEdge().getTrg();

						if (src instanceof Simpleexcel.File && trg instanceof Simpleexcel.Sheet) {
							innerOperations.add("ADD_FILE_SHEET_EDGE");
							HashMap<String, Object> innerMap = new HashMap<String, Object>();
							String fileName = ((Simpleexcel.File) ((AddEdgeOp) operation).getEdge().getSrc()).getFileName();
							String path = ((Simpleexcel.File) ((AddEdgeOp) operation).getEdge().getSrc()).getPath();
							if(path!=null && !path.isEmpty() && !path.equals(fileName)) {
								innerMap.put("SRC", path+"\\"+fileName);
							}
							else
								innerMap.put("SRC", fileName);
							innerMap.put("TRG",
									((Simpleexcel.Sheet) ((AddEdgeOp) operation).getEdge().getTrg()).getSheetName());
							innerOperations.add(innerMap);
						}
					} else {
						// delete edges
						if (operation instanceof DeleteEdgeOp) {

						}
					}
				}
			}

			if (null != innerOperations && !innerOperations.isEmpty())
				excelOperations.add(innerOperations);
		}
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

		// create rows
		sortedOperationsExcelPOI.addAll(rowNodeAddDeleteOperations);
		sortedOperationsExcelPOI.addAll(sheetToRowEdgeAddAndDeleteOperations);

		// create cells
		sortedOperationsExcelPOI.addAll(cellNodeAddDeleteOperations);
		sortedOperationsExcelPOI.addAll(rowToCellEdgeAddAndDeleteOperations);

		printOperationsFromList(sortedOperationsExcelPOI, "Sorted operations for EXCEL");

	}

	/**
	 * Sort the operations to make sense for EMF
	 */
	private void sortOperations() {
		// printOperationsFromList(operations, "Original List");

		for (Operation operation : operations) {
			// ==============FILE=================
			// add node - file
			if ((operation instanceof AddNodeOp) && ((AddNodeOp) operation).getNode() instanceof Simpleexcel.File) {
				fileNodeAddDeleteOperations.add(operation);
			}
			// delete node - file
			if ((operation instanceof DeleteNodeOp)
					&& ((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.File) {
				fileNodeAddDeleteOperations.add(operation);
			}

			// =============SHEET==================
			// add node - sheet
			if ((operation instanceof AddNodeOp) && ((AddNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
				sheetNodeAddDeleteOperations.add(operation);
			}
			// delete node - sheet
			if ((operation instanceof DeleteNodeOp)
					&& ((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Sheet) {
				sheetNodeAddDeleteOperations.add(operation);
			}

			// ==========FILE->SHEET EDGE=====================
			// add edge file--> sheet
			if ((operation instanceof AddEdgeOp) && ((AddEdgeOp) operation).getEdge().getSrc() instanceof File
					&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Sheet) {
				fileToSheetEdgeAddAndDeleteOperations.add(operation);
			}
			// Delete edge
			if ((operation instanceof DeleteEdgeOp) && ((DeleteEdgeOp) operation).getEdge().getSrc() instanceof File
					&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Sheet) {
				fileToSheetEdgeAddAndDeleteOperations.add(operation);
			}

			// =============CELL==================
			// add node - cell
			if ((operation instanceof AddNodeOp) && ((AddNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
				cellNodeAddDeleteOperations.add(operation);
			}
			// delete node - cell
			if ((operation instanceof DeleteNodeOp)
					&& ((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.Cell) {
				cellNodeAddDeleteOperations.add(operation);
			}

			// ==============SHEET->CELL EDGE=================
			// add edge sheet--> cell
			if ((operation instanceof AddEdgeOp) && ((AddEdgeOp) operation).getEdge().getSrc() instanceof Sheet
					&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
				sheetToCellEdgeAddAndDeleteOperations.add(operation);
			}
			// Delete edge
			if ((operation instanceof DeleteEdgeOp) && ((DeleteEdgeOp) operation).getEdge().getSrc() instanceof Sheet
					&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
				sheetToCellEdgeAddAndDeleteOperations.add(operation);
			}

			// ==============ROW=================
			// add node - row
			if ((operation instanceof AddNodeOp)
					&& ((AddNodeOp) operation).getNode() instanceof Simpleexcel.RowObject) {
				rowNodeAddDeleteOperations.add(operation);
			}
			// delete node - row
			if ((operation instanceof DeleteNodeOp)
					&& ((DeleteNodeOp) operation).getNode() instanceof Simpleexcel.RowObject) {
				rowNodeAddDeleteOperations.add(operation);
			}

			// ==============SHEET->ROW EDGE=================
			// add edge sheet--> row
			if ((operation instanceof AddEdgeOp) && ((AddEdgeOp) operation).getEdge().getSrc() instanceof Sheet
					&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof RowObject) {
				sheetToRowEdgeAddAndDeleteOperations.add(operation);
			}
			// Delete edge
			if ((operation instanceof DeleteEdgeOp) && ((DeleteEdgeOp) operation).getEdge().getSrc() instanceof Sheet
					&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof RowObject) {
				sheetToRowEdgeAddAndDeleteOperations.add(operation);
			}

			// ==============ROW->CELL EDGE=================
			// add edge row-->cell
			if ((operation instanceof AddEdgeOp) && ((AddEdgeOp) operation).getEdge().getSrc() instanceof RowObject
					&& ((AddEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
				rowToCellEdgeAddAndDeleteOperations.add(operation);
			}
			// Delete edge
			if ((operation instanceof DeleteEdgeOp)
					&& ((DeleteEdgeOp) operation).getEdge().getSrc() instanceof RowObject
					&& ((DeleteEdgeOp) operation).getEdge().getTrg() instanceof Cell) {
				rowToCellEdgeAddAndDeleteOperations.add(operation);
			}
		}

		sortedOperationsEMF.addAll(fileNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetNodeAddDeleteOperations);

		sortedOperationsEMF.addAll(fileToSheetEdgeAddAndDeleteOperations);

		sortedOperationsEMF.addAll(cellNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetToCellEdgeAddAndDeleteOperations);

		sortedOperationsEMF.addAll(rowNodeAddDeleteOperations);
		sortedOperationsEMF.addAll(sheetToRowEdgeAddAndDeleteOperations);

		sortedOperationsEMF.addAll(rowToCellEdgeAddAndDeleteOperations);

		// printOperationsFromList(sortedOperationsEMF, "Sorted Operations for EMF");
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
