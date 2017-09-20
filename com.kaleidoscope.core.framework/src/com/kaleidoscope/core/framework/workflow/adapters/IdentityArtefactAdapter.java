package com.kaleidoscope.core.framework.workflow.adapters;

import java.util.Optional;

public class IdentityArtefactAdapter<Model, Artefact> implements ArtefactAdapter<Model, Artefact>{

	private Model model;
	private Artefact artefact;
	
	@Override
	public void parse() {
	}

	@Override
	public void unparse() {		
	}

	@Override
	public void setModel(Model m) {
		this.model = m;
	}

	@Override
	public void setArtefact(Artefact a) {
		this.artefact = a;
		
	}

	@Override
	public Optional<Model> getModel() {
		return Optional.of(model);
	}

	@Override
	public Optional<Artefact> getArtefact() { 
		return Optional.of(artefact);
	}

}
