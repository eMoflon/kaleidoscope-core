package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import org.apache.commons.lang3.tuple.Pair;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Dest;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.PersistentSynchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class PersistentDeltaBasedController<
		SourceModel, 
		SourceArtefact, 
		TargetModel, 
		TargetArtefact, 
		UpdatePolicy, 
		ModelDelta extends Delta, 
		Failed extends Delta, 
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
	
	public Pair<SourceArtefact, TargetArtefact> syncForward(SourceArtefactDelta artefactDelta){
		synchroniser.restoreState(destination);
		Pair<SourceArtefact, TargetArtefact> artefactPair = super.syncForward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return artefactPair;
	}
	
	public Pair<SourceArtefact, TargetArtefact> syncBackward(TargetArtefactDelta artefactDelta) {
		synchroniser.restoreState(destination);
		Pair<SourceArtefact, TargetArtefact> artefactPair = super.syncBackward(artefactDelta);
		synchroniser.persistState(destination);		
		
		return artefactPair;
	}
}