package com.kaleidoscope.core.framework.workflow.controllers;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.PersistentSynchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class PersistentDeltaBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, D extends Delta,  UpdatePolicy, F extends Delta, SourceArtefactDelta, TargetArtefactDelta, Destination> 
					extends DeltaBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, D,  UpdatePolicy, F, SourceArtefactDelta, TargetArtefactDelta>{
					
	Destination destination;
	PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, Destination, D, F>synchroniser;
	
	@Inject
	public PersistentDeltaBasedController(@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter,
										  @Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
										  PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, Destination, D, F> synchroniser,  
										  @Src DeltaAdapter<D, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
										  @Trg DeltaAdapter<D, TargetArtefactDelta, TargetModel> targetDeltaAdapter, 
										  Destination destination) {
		
		super(sourceArtefactAdapter, targetArtefactAdapter, synchroniser, sourceDeltaAdapter, targetDeltaAdapter);
		this.destination = destination; 
		this.synchroniser = synchroniser;
	}	
	
	public TargetArtefact syncForward(SourceArtefactDelta artefactDelta){
		
		synchroniser.restoreState(destination);
		TargetArtefact targetArtefact = super.syncForward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return targetArtefact;
	}
	
	public SourceArtefact syncBackward(TargetArtefactDelta artefactDelta) {
		
		synchroniser.restoreState(destination);
		SourceArtefact sourceArtefact = super.syncBackward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return sourceArtefact;
	}
}
