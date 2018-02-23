package com.kaleidoscope.core.framework.workflow.controllers.statebased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.annotations.Dest;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.PersistentSynchroniser;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class PersistentStateBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		UpdatePolicy, 
		ModelDelta extends IDelta, 
		Failed extends IDelta, 
		Destination
	>
	extends StateBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		ModelDelta, 
		UpdatePolicy, 
		Failed
	>{
	protected final Destination destination;
	protected final PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed, Destination> synchroniser;
	
	@Inject
	public PersistentStateBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed, Destination> synchroniser, 
			@Src OfflineDeltaDiscoverer<SourceModel, ModelDelta> sourceDeltaDiscoverer,
			@Trg OfflineDeltaDiscoverer<TargetModel, ModelDelta> targetDeltaDiscoverer, 
			@Dest Destination destination) {
		
		super(sourceArtefactAdapter, targetArtefactAdapter, synchroniser, sourceDeltaDiscoverer, targetDeltaDiscoverer);
		this.destination = destination; 
		this.synchroniser = synchroniser;
		
	}	

	@Override
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncForward(SourceArtefact sourceArtefact)throws SynchronisationFailedException{
		synchroniser.restoreState(destination);
		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = super.syncForward(sourceArtefact);
		synchroniser.persistState(destination);		
		
		return syncResult;
	}
	@Override
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefact targetArtefact)throws SynchronisationFailedException {
		synchroniser.restoreState(destination);
		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = super.syncBackward(targetArtefact);
		synchroniser.persistState(destination);		
		
		return syncResult;
	}
}