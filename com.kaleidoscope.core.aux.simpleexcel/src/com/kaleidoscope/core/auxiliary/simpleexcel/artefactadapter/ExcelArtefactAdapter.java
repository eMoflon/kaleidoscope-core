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
import Simpleexcel.ExcelElement;
import Simpleexcel.File;
import Simpleexcel.Row;
import Simpleexcel.Sheet;
import Simpleexcel.SimpleexcelPackage;

/**
 * @author Srijani
 *
 */
public class ExcelArtefactAdapter implements ArtefactAdapter<ExcelElement, Path> {

	private Optional<ExcelElement> model;
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
		ExcelDelta excelDelta = excelDeltaAdapter.unparse(generateOperationalDeltaForFile(getModel()), path);
		try {
			excelDelta.execute();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Generate operational delta for new file
	 * 
	 * @return
	 */
	private OperationalDelta generateOperationalDeltaForFile(Optional<ExcelElement> m) {
		// OperationalDelta initialize
		OperationalDelta opDelta = new OperationalDelta();

		// iterate through model

		// get File name
		//Optional<File> m = getModel();

		// add file node
		File file = (File)m.get();
		
		// for windows
		if(System.getProperty("os.name").contains("Windows") || System.getProperty("os.name").contains("windows")) {
			file.setPath(path.toString().substring(0, path.toString().lastIndexOf("\\")));
		}
		//for other OS
		else {
			file.setPath(path.subpath(0, path.getNameCount() - 1).toString());
		}
		file.setFileName(path.getFileName().toString());
		
		opDelta.addNodeOp(file);

		// iterate through all the sheets in a file
		for (int sheetCount = 0; sheetCount < file.getSheet().size(); sheetCount++) {
			Sheet sheet = file.getSheet().get(sheetCount);
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
	public void setArtefact(Path a) {
		path = a;
	}

	@Override
	public Optional<ExcelElement> getModel() {
		return model;
	}

	@Override
	public Optional<Path> getArtefact() {
		return Optional.of(path);
	}

	@Override
	public void setModel(ExcelElement m) {
		model = Optional.of(m);
		
	}

}
