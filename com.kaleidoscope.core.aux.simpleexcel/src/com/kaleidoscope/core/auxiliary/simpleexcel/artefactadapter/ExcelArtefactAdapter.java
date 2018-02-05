/**
 * 
 */
package com.kaleidoscope.core.auxiliary.simpleexcel.artefactadapter;


import java.nio.file.Path;
import java.util.Optional;

import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

/**
 * @author Srijani
 *
 */
public class ExcelArtefactAdapter implements ArtefactAdapter<Simpleexcel.File, Path>{
	
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
		// TODO [Srijani]:  Use DeltaAdapter internally once that is implemented
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
