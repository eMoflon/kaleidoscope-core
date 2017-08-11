package com.kaleidoscope.core.framework.workflow.controllers;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Dest;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.PersistentSynchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class PersistentStateBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		UpdatePolicy, 
		D extends Delta, 
		F extends Delta, 
		Destination
	>
	extends StateBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		D, 
		UpdatePolicy, 
		F
	>{
	protected final Destination destination;
	protected final PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, D, F, Destination> synchroniser;
	
	@Inject
	public PersistentStateBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, D, F, Destination> synchroniser, 
			@Src OfflineDeltaDiscoverer<SourceModel, D> sourceDeltaDiscoverer,
			@Trg OfflineDeltaDiscoverer<TargetModel, D> targetDeltaDiscoverer, 
			@Dest Destination destination) {
		
		super(sourceArtefactAdapter, targetArtefactAdapter, synchroniser, sourceDeltaDiscoverer, targetDeltaDiscoverer);
		this.destination = destination; 
		this.synchroniser = synchroniser;
		
	}	

	public TargetArtefact syncForward(SourceArtefact sourceArtefact){
		synchroniser.restoreState(destination);
		TargetArtefact targetArtefact = super.syncForward(sourceArtefact);
		synchroniser.persistState(destination);		
		
		return targetArtefact;
	}
	
	public SourceArtefact syncBackward(TargetArtefact targetArtefact) {
		synchroniser.restoreState(destination);
		SourceArtefact sourceArtefact = super.syncBackward(targetArtefact);
		synchroniser.persistState(destination);		
		
		return sourceArtefact;
	}
}