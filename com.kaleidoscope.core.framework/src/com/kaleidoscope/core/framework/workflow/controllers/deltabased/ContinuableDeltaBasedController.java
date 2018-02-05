package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.ContinuableSynchroniser;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationContinuationResult;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaInputAdapter;

public class ContinuableDeltaBasedController <
											SourceModel, 
											SourceArtefact, 
											TargetModel,
											TargetArtefact,
											UpdatePolicy,
											ModelDelta extends IDelta,
											Failed extends IDelta,
											SourceArtefactDelta,
											TargetArtefactDelta>
					extends DeltaBasedController<
											SourceModel,
											SourceArtefact,
											TargetModel,
											TargetArtefact,
											UpdatePolicy,
											ModelDelta,
											Failed,
											SourceArtefactDelta,
											TargetArtefactDelta>
					 implements DeltaBasedContinuable<
											SourceModel,
											SourceArtefact,
											TargetModel,
											TargetArtefact,
											Failed,
											UpdatePolicy>{

	protected final ContinuableSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> continuableSynchroniser;
	
	@Inject
	public ContinuableDeltaBasedController(@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter,
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			ContinuableSynchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> continuableSynchroniser,
			@Src DeltaInputAdapter<ModelDelta, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
			@Trg DeltaInputAdapter<ModelDelta, TargetArtefactDelta, TargetModel> targetDeltaAdapter) {
		
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
    public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncForward(SourceArtefactDelta artefactDelta) throws SynchronisationFailedException{
		return generateContinuableSyncResult(super.syncForward(artefactDelta));
	}
	
	@Override
    public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> syncBackward(TargetArtefactDelta artefactDelta) throws SynchronisationFailedException{
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
