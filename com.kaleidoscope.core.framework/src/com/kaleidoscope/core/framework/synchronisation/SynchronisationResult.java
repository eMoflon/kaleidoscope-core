package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed extends Delta> {
	
	protected ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter;
	protected ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;
	protected Failed failedDelta;

	public SynchronisationResult() {
		
	}
	
	public SynchronisationResult(ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefact, ArtefactAdapter<TargetModel, TargetArtefact> targetArtefact, Failed failedDelta) {		
		this.sourceArtefactAdapter = sourceArtefact;
		this.targetArtefactAdapter = targetArtefact;
		this.failedDelta = failedDelta;
	}
	
	
	public ArtefactAdapter<SourceModel, SourceArtefact> getSourceArtefactAdapter() {
		return sourceArtefactAdapter;
	}
	public void setSourceArtefactAdapter(ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefact) {
		this.sourceArtefactAdapter = sourceArtefact;
	}
	public ArtefactAdapter<TargetModel, TargetArtefact> getTargetArtefactAdapter() {
		return targetArtefactAdapter;
	}
	public void setTargetArtefactAdapter(ArtefactAdapter<TargetModel, TargetArtefact> targetArtefact) {
		this.targetArtefactAdapter = targetArtefact;
	}
	public Failed getFailedDelta() {
		return failedDelta;
	}

}
