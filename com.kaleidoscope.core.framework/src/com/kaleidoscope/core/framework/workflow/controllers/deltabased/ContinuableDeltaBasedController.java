package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.ContinuableSynchroniser;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationContinuationResult;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class ContinuableDeltaBasedController <SourceModel, SourceArtefact, TargetModel, TargetArtefact, UpdatePolicy, ModelDelta extends Delta, Failed extends Delta, SourceArtefactDelta, TargetArtefactDelta>
					extends DeltaBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, UpdatePolicy, ModelDelta, Failed, SourceArtefactDelta, TargetArtefactDelta>
					 implements DeltaBasedContinuable<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy>{

	protected final ContinuableSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> continuableSynchroniser;
	
	@Inject
	public ContinuableDeltaBasedController(@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter,
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			ContinuableSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> continuableSynchroniser,
			@Src DeltaAdapter<ModelDelta, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
			@Trg DeltaAdapter<ModelDelta, TargetArtefactDelta, TargetModel> targetDeltaAdapter) {
		
		super(sourceArtefactAdapter, targetArtefactAdapter, continuableSynchroniser, sourceDeltaAdapter, targetDeltaAdapter);
		this.continuableSynchroniser = continuableSynchroniser;
	}
	
	
	@Override
	public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> continueSync() {			
		continuableSynchroniser.continueSync();
		
		SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncResult = 
				new SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy>(
									sourceArtefactAdapter, targetArtefactAdapter, synchroniser.getFailedDelta(), 
									continuableSynchroniser.getContinuationPolicy(), continuableSynchroniser.hasContinuation());
		
		return syncResult;
	}
	
	@Override
    public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncForward(SourceArtefactDelta artefactDelta) {
		return generateContinuableSyncResult(super.syncForward(artefactDelta));
	}
	
	@Override
    public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncBackward(TargetArtefactDelta artefactDelta) {
		return generateContinuableSyncResult(super.syncBackward(artefactDelta));
	}
	
	private SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> 
		generateContinuableSyncResult(SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncResult) {


			SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncContinuationResult = 
												new SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy>(syncResult); 
			syncContinuationResult.setUpdatePolicy(continuableSynchroniser.getContinuationPolicy());
			syncContinuationResult.setHasContinuation(continuableSynchroniser.hasContinuation());
			return syncContinuationResult;
	}

}
