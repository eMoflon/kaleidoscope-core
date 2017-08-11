package com.kaleidoscope.core.framework.workflow.controllers;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.Synchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class DeltaBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, UpdatePolicy, D extends Delta, F extends Delta, SourceArtefactDelta, TargetArtefactDelta> {

	protected ArtefactAdapter<SourceModel,SourceArtefact> sourceArtefactAdapter;
	protected ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;

	protected Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser;
	protected DeltaAdapter<D, SourceArtefactDelta, SourceModel> sourceDeltaAdapter;
	protected DeltaAdapter<D, TargetArtefactDelta, TargetModel> targetDeltaAdapter;
	
	@Inject
	public DeltaBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
				 Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser,
			@Src DeltaAdapter<D, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
			@Trg DeltaAdapter<D, TargetArtefactDelta, TargetModel> targetDeltaAdapter) {
		
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		this.targetArtefactAdapter = targetArtefactAdapter;
		this.synchroniser = synchroniser;
		this.sourceDeltaAdapter = sourceDeltaAdapter;
		this.targetDeltaAdapter = targetDeltaAdapter;
	}	
	
	public TargetArtefact syncForward(SourceArtefactDelta artefactDelta){
		D delta = sourceDeltaAdapter.parse(artefactDelta, synchroniser.getSourceModel());
		synchroniser.syncForward(delta);	
		
		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();
		return targetArtefactAdapter
				.getArtefact()
				.orElseThrow(() -> new IllegalStateException("Unable to create target artefact."));
	}
	
	public SourceArtefact syncBackward(TargetArtefactDelta artefactDelta) {
		
		D delta = targetDeltaAdapter.parse(artefactDelta, synchroniser.getTargetModel());
		synchroniser.syncBackward(delta);	
		
		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();
		return sourceArtefactAdapter
				.getArtefact()
				.orElseThrow(() -> new IllegalStateException("Unable to create source artefact."));
	}
}
