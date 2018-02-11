/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;

import java.nio.file.Path;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;

import com.kaleidoscope.core.auxiliary.simpleexcel.utils.UnableToEditExcelFile;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

import Simpleexcel.Cell;
import Simpleexcel.File;
import Simpleexcel.RowObject;
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
		// ExcelDelta excelDelta =
		// excelDeltaAdapter.unparse(generateOperationalDeltaForFile(), path);
		ExcelDelta excelDelta = excelDeltaAdapter.unparse(generateOperationalDeltaForFile1(), path);
		try {
			excelDelta.execute();
		} catch (UnableToEditExcelFile e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method: alternate input for operational delta with existing file
	 * 
	 * @return
	 */
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
				RowObject startRow = null;
				for (int rowCounter = 0; rowCounter < sheet.getRowobject().size(); rowCounter++) {
					if (sheet.getRowobject().get(rowCounter).getPrevRow() == null) {
						startRow = sheet.getRowobject().get(rowCounter);
					}
				}
			}
		}

		// add new Sheet Sheet newSheet = SimpleexcelFactory.eINSTANCE.createSheet();
		Sheet newSheet = SimpleexcelFactory.eINSTANCE.createSheet();
		newSheet.setSheetName("Sheet to Add");
		opDelta.addNodeOp(newSheet);
		opDelta.addEdgeOp(new JavaBasedEdge(file, newSheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

		/*
		 * // delete a sheet Sheet toDel = SimpleexcelFactory.eINSTANCE.createSheet();
		 * toDel.setSheetName("Sheet to delete"); opDelta.deleteEdgeOp(new
		 * JavaBasedEdge(file, toDel, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));
		 * 
		 * opDelta.deleteNodeOp(toDel);
		 */

		// add new row in new sheet
		/*
		 * RowObject newRow = SimpleexcelFactory.eINSTANCE.createRowObject();
		 * opDelta.addNodeOp(newRow); opDelta.addEdgeOp(new JavaBasedEdge(toEdit,
		 * newRow, SimpleexcelPackage.eINSTANCE.getSheet_Rowobject()));
		 */

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
		file.setFileName("CreatedNewFile.xlsx");
		file.setPath(
				"D:\\WorkSpaces\\Kaleidoscope Development\\Refactoring\\kaleidoscope-core\\com.kaleidoscope.core.aux.simpleexcel\\Resources\\");
		opDelta.addNodeOp(file);

		// iterate through all the sheets in a file
		for (int sheetCount = 0; sheetCount < file.getSheet().size(); sheetCount++) {
			Sheet sheet = m.get().getSheet().get(sheetCount);
			opDelta.addNodeOp(sheet);
			opDelta.addEdgeOp(new JavaBasedEdge(file, sheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));
		}

		// add new Sheet
		Sheet newSheet = SimpleexcelFactory.eINSTANCE.createSheet();
		newSheet.setSheetName("Sheet to Add");
		opDelta.addNodeOp(newSheet);
		opDelta.addEdgeOp(new JavaBasedEdge(file, newSheet, SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

		// edit an existing cell

		/*
		 * // add new row in new sheet RowObject newRow =
		 * SimpleexcelFactory.eINSTANCE.createRowObject(); opDelta.addNodeOp(newRow);
		 * opDelta.addEdgeOp(new JavaBasedEdge(newSheet, newRow,
		 * SimpleexcelPackage.eINSTANCE.getSheet_Rowobject()));
		 */

		// delete a sheet
		// Sheet toDel = SimpleexcelFactory.eINSTANCE.createSheet();
		// toDel.setSheetName("Sheet to delete");
		// opDelta.deleteEdgeOp(new JavaBasedEdge(file, toDel,
		// SimpleexcelPackage.eINSTANCE.getFile_Sheet()));

		// opDelta.deleteNodeOp(toDel);

		return opDelta;
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
