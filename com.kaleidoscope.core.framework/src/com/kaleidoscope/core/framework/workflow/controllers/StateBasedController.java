package com.kaleidoscope.core.framework.workflow.controllers;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.Synchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class StateBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		D extends Delta, 
		UpdatePolicy, 
		F extends Delta
	>{
	protected final ArtefactAdapter<SourceModel,SourceArtefact> sourceArtefactAdapter;
	protected final ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;
	protected final Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser;
	protected final OfflineDeltaDiscoverer<SourceModel, D> sourceDeltaDiscoverer;
	protected final OfflineDeltaDiscoverer<TargetModel, D> targetDeltaDiscoverer;
	
	@Inject
	public StateBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			     Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser, 
			@Src OfflineDeltaDiscoverer<SourceModel, D> sourceDeltaDiscoverer,
			@Trg OfflineDeltaDiscoverer<TargetModel, D> targetDeltaDiscoverer
		){
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		this.targetArtefactAdapter = targetArtefactAdapter;
		this.synchroniser = synchroniser;
		this.sourceDeltaDiscoverer = sourceDeltaDiscoverer;
		this.targetDeltaDiscoverer = targetDeltaDiscoverer;
	}	
	
	public TargetArtefact syncForward(SourceArtefact sourceArtefact){
		sourceArtefactAdapter.setArtefact(sourceArtefact);
		sourceArtefactAdapter.parse();
		SourceModel newSourceModel = sourceArtefactAdapter
				.getModel()
				.orElseThrow(() -> new IllegalStateException("Unable to create source model."));
		SourceModel oldSourceModel = synchroniser.getSourceModel();
		
		D delta = sourceDeltaDiscoverer.discoverDelta(newSourceModel, oldSourceModel);
		synchroniser.syncForward(delta);	
		
		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();
		return targetArtefactAdapter
				.getArtefact()
				.orElseThrow(() -> new IllegalStateException("Unable to create target artefact."));
	}
	
	public SourceArtefact syncBackward(TargetArtefact targetArtefact) {
		targetArtefactAdapter.setArtefact(targetArtefact);
		targetArtefactAdapter.parse();
		TargetModel newTargetModel = targetArtefactAdapter
				.getModel()
				.orElseThrow(() -> new IllegalStateException("Unable to create target model."));
		TargetModel oldTargetModel = synchroniser.getTargetModel();
		
		D delta = targetDeltaDiscoverer.discoverDelta(newTargetModel, oldTargetModel);
		synchroniser.syncBackward(delta);
		
		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();
		return sourceArtefactAdapter
				.getArtefact()
				.orElseThrow(() -> new IllegalStateException("Unable to create source artefact."));
	}
}