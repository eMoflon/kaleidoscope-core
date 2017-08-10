package com.kaleidoscope.core.framework.workflow.adapters;

public interface ArtefactAdapter<Model, Artefact> {
	
	public Model parse(Artefact a);
	public Artefact unparse(Model m);

}
