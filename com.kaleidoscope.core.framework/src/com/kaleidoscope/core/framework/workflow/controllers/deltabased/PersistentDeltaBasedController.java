package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.annotations.Dest;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.PersistentSynchroniser;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class PersistentDeltaBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		UpdatePolicy, 
		ModelDelta extends IDelta, 
		Failed extends IDelta, 
		SourceArtefactDelta, 
		TargetArtefactDelta, 
		Destination
	> 
	extends DeltaBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		UpdatePolicy, 
		ModelDelta, 
		Failed, 
		SourceArtefactDelta, 
		TargetArtefactDelta
	>{
	protected final Destination destination;
	protected final PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed, Destination>synchroniser;
	
	@Inject
	public PersistentDeltaBasedController(
			@Src  ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter,
			@Trg  ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
				  PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed, Destination> synchroniser,  
			@Src  DeltaAdapter<ModelDelta, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
			@Trg  DeltaAdapter<ModelDelta, TargetArtefactDelta, TargetModel> targetDeltaAdapter, 
			@Dest Destination destination
		) {
		super(sourceArtefactAdapter, targetArtefactAdapter, synchroniser, sourceDeltaAdapter, targetDeltaAdapter);
		this.destination = destination; 
		this.synchroniser = synchroniser;
	}	
	
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncForward(SourceArtefactDelta artefactDelta)throws SynchronisationFailedException{
		synchroniser.restoreState(destination);
		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = super.syncForward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return syncResult;
	}
	
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefactDelta artefactDelta)throws SynchronisationFailedException {
		synchroniser.restoreState(destination);
		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = super.syncBackward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return syncResult;
	}
}