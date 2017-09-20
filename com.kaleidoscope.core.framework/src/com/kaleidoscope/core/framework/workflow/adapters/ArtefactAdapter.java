package com.kaleidoscope.core.framework.workflow.adapters;

import java.util.Optional;

public interface ArtefactAdapter<Model, Artefact> {
	
	public void parse();
	public void unparse();

	public void setModel(Model m);
	public void setArtefact(Artefact a);
	
	public Optional<Model> getModel();
	public Optional<Artefact> getArtefact();
	
}
