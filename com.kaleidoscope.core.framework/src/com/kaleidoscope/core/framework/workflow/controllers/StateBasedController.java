package com.kaleidoscope.core.framework.workflow.controllers;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.Synchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class StateBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, D extends Delta,  UpdatePolicy, F extends Delta> {

	protected ArtefactAdapter<SourceModel,SourceArtefact> sourceArtefactAdapter;
	protected ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;

	protected Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser;
	protected OfflineDeltaDiscoverer<SourceModel, D> sourceDeltaDiscoverer;
	protected OfflineDeltaDiscoverer<TargetModel, D> targetDeltaDiscoverer;
	
	@Inject
	public StateBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> synchroniser, 
			@Src OfflineDeltaDiscoverer<SourceModel, D> sourceDeltaDiscoverer,
			@Trg OfflineDeltaDiscoverer<TargetModel, D> targetDeltaDiscoverer) {
		
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		this.targetArtefactAdapter = targetArtefactAdapter;
		this.synchroniser = synchroniser;
		this.sourceDeltaDiscoverer = sourceDeltaDiscoverer;
		this.targetDeltaDiscoverer = targetDeltaDiscoverer;
	}	
	
	public TargetArtefact syncForward(SourceArtefact sourceArtefact){
				
		SourceModel newSourceModel = sourceArtefactAdapter.parse(sourceArtefact);
		SourceModel oldSourceModel = synchroniser.getSourceModel();
		
		D delta = sourceDeltaDiscoverer.discoverDelta(newSourceModel, oldSourceModel);
		synchroniser.syncForward(delta);	
		
		TargetModel targetModel = synchroniser.getTargetModel();
		return targetArtefactAdapter.unparse(targetModel);
	}
	
	public SourceArtefact syncBackward(TargetArtefact targetArtefact) {
		
		TargetModel newTargetModel = targetArtefactAdapter.parse(targetArtefact);
		TargetModel oldTargetModel = synchroniser.getTargetModel();
		
		D delta = targetDeltaDiscoverer.discoverDelta(newTargetModel, oldTargetModel);
		synchroniser.syncBackward(delta);
		
		SourceModel sourceModel = synchroniser.getSourceModel();
		return sourceArtefactAdapter.unparse(sourceModel);
	}
}
