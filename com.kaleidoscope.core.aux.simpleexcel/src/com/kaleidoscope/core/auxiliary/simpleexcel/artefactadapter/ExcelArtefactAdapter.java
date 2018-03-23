/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.nio.file.Path;
import java.util.Optional;

import com.kaleidoscope.core.auxiliary.simpleexcel.utils.ExcelException;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

import Simpleexcel.Cell;
import Simpleexcel.Column;
import Simpleexcel.File;
import Simpleexcel.Row;
import Simpleexcel.Sheet;
import Simpleexcel.SimpleexcelFactory;
import Simpleexcel.SimpleexcelPackage;

/**
 * @author Srijani
 *
 */
public class ExcelArtefactAdapter implements ArtefactAdapter<Simpleexcel.File, Path> {

	private Optional<Simpleexcel.File> model;
	private Path path;

	public ExcelArtefactAdapter(Path path) {
		this.path = path;
		this.model = Optional.empty();
	}

	@Override
	public void parse() {
		ExcelHandler excelHandler = new ExcelHandler(path);
		model = excelHandler.parseExcelFile();
	}

	@Override
	public void unparse() {
		ExcelDeltaAdapter excelDeltaAdapter = new ExcelDeltaAdapter();
		ExcelDelta excelDelta = excelDeltaAdapter.unparse(generateOperationalDeltaForFile(), path);
		try {
			excelDelta.execute();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method: alternate input for operational delta with existing file
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private OperationalDelta generateOperationalDeltaForFile1() {
		// OperationalDelta initialize
		OperationalDelta opDelta = new OperationalDelta();

		// get File name
		Optional<File> m = getModel();
		File file = m.get();

		// iterate through all the sheets in a file
		for (int sheetCount = 0; sheetCount < file.getSheet().size(); sheetCount++) {
			Sheet sheet = m.get().getSheet().get(sheetCount);
			opDelta.addEdgeOp(new JavaBasedEdge(file, sheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

			// edit an existing cell in sheet- Sheet to edit
			if (sheet.getSheetName().equals("Sheet to edit")) {
				// identify starting row
				Row startRow = null;
				for (int rowCounter = 0; rowCounter < sheet.getRowobject().size(); rowCounter++) {
					if (sheet.getRowobject().get(rowCounter).getPrevRow() == null) {
						startRow = sheet.getRowobject().get(rowCounter);
						break;
					}
				}

				// identify starting column
				Column startColumn = null;
				for (int colCounter = 0; colCounter < sheet.getRowobject().size(); colCounter++) {
					if (sheet.getColobject().get(colCounter).getPrevColumn() == null) {
						startColumn = sheet.getColobject().get(colCounter);
						break;
					}
				}

				// append a new row - with color and 2 cells in thet row (in col 1 and col4)
				Row rowToAdd = SimpleexcelFactory.eINSTANCE.createRow();
				rowToAdd.setBackgroundColor("#FF0000");
				int rowIndex = 1;
				Row tempRow = startRow;
				opDelta.addNodeOp(rowToAdd);
				opDelta.addEdgeOp(
						new JavaBasedEdge(sheet, rowToAdd, SimpleexcelPackage.eINSTANCE.getSheet_Rowobject()));
				while (tempRow != null) {
					if (tempRow.getNextRow() == null) {
						tempRow.setNextRow(rowToAdd);
						break;
					}
					tempRow = tempRow.getNextRow();
					rowIndex++;
				}

				// edit a cell (1,1)
				int cellRowIndex = 1;
				int cellColIndex = 1;
				tempRow = startRow;
				rowIndex = 0;
				while (tempRow != null) {
					Column tempCol = startColumn;
					int colIndex = 0;
					while (tempCol != null) {
						if (rowIndex == cellRowIndex && colIndex == cellColIndex) {
							Simpleexcel.Cell cellToEdit = tempRow.getCell().get(colIndex);
							opDelta.changeAttributeOp(SimpleexcelPackage.eINSTANCE.getCell_Text(), "Edited cell",
									cellToEdit, "Cell to edit");
							opDelta.changeAttributeOp(SimpleexcelPackage.eINSTANCE.getCell_BackgroundColor(), "#00FF00",
									cellToEdit);
							opDelta.changeAttributeOp(SimpleexcelPackage.eINSTANCE.getCell_CellComments(),
									"This is a test comment", cellToEdit);
						}
						tempCol = tempCol.getNextColumn();
						colIndex++;

					}
					tempRow = tempRow.getNextRow();
					rowIndex++;
				}

				// add a cell (6,3) to existing row
				cellRowIndex = 6;
				cellColIndex = 3;
				tempRow = startRow;
				rowIndex = 0;
				while (tempRow != null) {
					Column tempCol = startColumn;
					int colIndex = 0;
					while (tempCol != null) {
						if (rowIndex == cellRowIndex && colIndex == cellColIndex) {
							Cell addCell = SimpleexcelFactory.eINSTANCE.createCell();
							addCell.setText("Added cell to existing row");
							opDelta.addNodeOp(addCell);
							opDelta.addEdgeOp(
									new JavaBasedEdge(tempRow, addCell, SimpleexcelPackage.eINSTANCE.getRow_Cell()));
							opDelta.addEdgeOp(
									new JavaBasedEdge(tempCol, addCell, SimpleexcelPackage.eINSTANCE.getColumn_Cell()));
						}
						tempCol = tempCol.getNextColumn();
						colIndex++;
					}
					tempRow = tempRow.getNextRow();
					rowIndex++;
				}

				// add a cell (10,6) to new row
				cellRowIndex = 10;
				cellColIndex = 6;

				tempRow = startRow;
				rowIndex = 0;
				while (tempRow != null) {
					Column tempCol = startColumn;
					int colIndex = 0;
					while (tempCol != null) {
						if (rowIndex == cellRowIndex && colIndex == cellColIndex) {
							Cell addCell = SimpleexcelFactory.eINSTANCE.createCell();
							addCell.setText("Added cell to new row");
							addCell.setBackgroundColor("#FF0000");
							opDelta.addNodeOp(addCell);
							opDelta.addEdgeOp(
									new JavaBasedEdge(tempRow, addCell, SimpleexcelPackage.eINSTANCE.getRow_Cell()));
							opDelta.addEdgeOp(
									new JavaBasedEdge(tempCol, addCell, SimpleexcelPackage.eINSTANCE.getColumn_Cell()));
							break;
						}
						if (tempCol.getNextColumn() == null && colIndex < cellColIndex) {
							Column col = SimpleexcelFactory.eINSTANCE.createColumn();
							col.setPrevColumn(tempCol);
							opDelta.addNodeOp(col);
							opDelta.addEdgeOp(
									new JavaBasedEdge(sheet, col, SimpleexcelPackage.eINSTANCE.getSheet_Colobject()));
							System.out.println("ADDED ONE COL");
						}
						tempCol = tempCol.getNextColumn();
						colIndex++;
					}
					if (tempRow.getNextRow() == null && rowIndex < cellRowIndex) {
						Row row = SimpleexcelFactory.eINSTANCE.createRow();
						row.setPrevRow(tempRow);
						opDelta.addNodeOp(row);
						opDelta.addEdgeOp(
								new JavaBasedEdge(sheet, row, SimpleexcelPackage.eINSTANCE.getSheet_Rowobject()));
						System.out.println("ADDED ONE ROW");
					}
					tempRow = tempRow.getNextRow();
					rowIndex++;
				}

				System.out.println();

			}
		}

		// add new Sheet Sheet newSheet = SimpleexcelFactory.eINSTANCE.createSheet();

		Sheet newSheet = SimpleexcelFactory.eINSTANCE.createSheet();
		newSheet.setSheetName("Sheet to Add");
		opDelta.addNodeOp(newSheet);
		opDelta.addEdgeOp(new JavaBasedEdge(file, newSheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

		return opDelta;
	}

	/**
	 * Generate operational delta for new file
	 * 
	 * @return
	 */
	private OperationalDelta generateOperationalDeltaForFile() {
		// OperationalDelta initialize
		OperationalDelta opDelta = new OperationalDelta();

		// iterate through model

		// get File name
		Optional<File> m = getModel();

		// add file node
		File file = m.get();
		file.setFileName("TestExcelDocResult.xlsx");
		file.setPath("C:\\Users\\Srijani\\Desktop\\");
		opDelta.addNodeOp(file);

		// iterate through all the sheets in a file
		for (int sheetCount = 0; sheetCount < file.getSheet().size(); sheetCount++) {
			Sheet sheet = m.get().getSheet().get(sheetCount);
			opDelta.addNodeOp(sheet);
			opDelta.addEdgeOp(new JavaBasedEdge(file, sheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

			// identify starting row and add its cells
			Row startRow = null;
			for (int rowCounter = 0; rowCounter < sheet.getRowobject().size(); rowCounter++) {
				if (sheet.getRowobject().get(rowCounter).getPrevRow() == null) {
					startRow = sheet.getRowobject().get(rowCounter);
					break;
				}
			}

			// identify starting column
			Column startColumn = null;
			for (int colCounter = 0; colCounter < sheet.getRowobject().size(); colCounter++) {
				if (sheet.getColobject().get(colCounter).getPrevColumn() == null) {
					startColumn = sheet.getColobject().get(colCounter);
					break;
				}
			}
			opDelta.addNodeOp(startColumn);
			opDelta.addEdgeOp(new JavaBasedEdge(sheet, startColumn, SimpleexcelPackage.eINSTANCE.getSheet_Colobject()));

			// create all columns
			Column tempCol = startColumn;
			while (tempCol != null) {
				Column nextCol = tempCol.getNextColumn();
				if (nextCol != null) {
					opDelta.addNodeOp(nextCol);
					opDelta.addEdgeOp(
							new JavaBasedEdge(sheet, nextCol, SimpleexcelPackage.eINSTANCE.getSheet_Colobject()));
					opDelta.addEdgeOp(
							new JavaBasedEdge(tempCol, nextCol, SimpleexcelPackage.eINSTANCE.getColumn_NextColumn()));
				}

				tempCol = nextCol;
			}

			// iterate all rows and add cells
			Row tempRow = startRow;
			while (tempRow != null) {
				opDelta.addNodeOp(tempRow);
				opDelta.addEdgeOp(new JavaBasedEdge(sheet, tempRow, SimpleexcelPackage.eINSTANCE.getSheet_Rowobject()));
				opDelta.addEdgeOp(new JavaBasedEdge(tempRow, tempRow, SimpleexcelPackage.eINSTANCE.getRow_NextRow()));

				// iterate all cells for a row
				for (int cellcount = 0; cellcount < tempRow.getCell().size(); cellcount++) {
					Cell cell = tempRow.getCell().get(cellcount);

					opDelta.addNodeOp(cell);
					opDelta.addEdgeOp(new JavaBasedEdge(sheet, cell, SimpleexcelPackage.eINSTANCE.getSheet_Cell()));
					opDelta.addEdgeOp(new JavaBasedEdge(tempRow, cell, SimpleexcelPackage.eINSTANCE.getRow_Cell()));

					// get col for that cell
					Column col = getColumnForCell(cellcount, startColumn);
					if (col != null) {
						opDelta.addEdgeOp(new JavaBasedEdge(col, cell, SimpleexcelPackage.eINSTANCE.getColumn_Cell()));
					}
				}

				Row nextRow = tempRow.getNextRow();
				tempRow = nextRow;
			}
		}

		return opDelta;
	}

	/**
	 * @param cellcount
	 * @param startColumn
	 * @return
	 */
	private Column getColumnForCell(int cellcount, Column startColumn) {
		int count = cellcount;
		int i = 0;
		Column returnCol = null;
		while (i <= count) {
			returnCol = startColumn;
			startColumn = returnCol.getNextColumn();
			i++;
		}
		return returnCol;
	}

	@Override
	public void setModel(Simpleexcel.File m) {
		model = Optional.of(m);
	}

	@Override
	public void setArtefact(Path a) {
		path = a;
	}

	@Override
	public Optional<Simpleexcel.File> getModel() {
		return model;
	}

	@Override
	public Optional<Path> getArtefact() {
		return Optional.of(path);
	}

}
