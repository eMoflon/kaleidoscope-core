package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.synchronisation.Synchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;
import com.kaleidoscope.core.framework.workflow.adapters.DeltaAdapter;

public class DeltaBasedController<SourceModel, SourceArtefact, TargetModel, TargetArtefact, UpdatePolicy, ModelDelta extends Delta, Failed extends Delta, SourceArtefactDelta, TargetArtefactDelta>
		implements
		DeltaBased<SourceModel, SourceArtefact, TargetModel, TargetArtefact, SourceArtefactDelta, TargetArtefactDelta, UpdatePolicy, Failed> {
	protected final ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter;
	protected final ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;
	protected final Synchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> synchroniser;
	protected final DeltaAdapter<ModelDelta, SourceArtefactDelta, SourceModel> sourceDeltaAdapter;
	protected final DeltaAdapter<ModelDelta, TargetArtefactDelta, TargetModel> targetDeltaAdapter;	

	@Inject
	public DeltaBasedController(@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter,
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			Synchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> synchroniser,
			@Src DeltaAdapter<ModelDelta, SourceArtefactDelta, SourceModel> sourceDeltaAdapter,
			@Trg DeltaAdapter<ModelDelta, TargetArtefactDelta, TargetModel> targetDeltaAdapter) {
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		this.targetArtefactAdapter = targetArtefactAdapter;
		this.synchroniser = synchroniser;
		this.sourceDeltaAdapter = sourceDeltaAdapter;
		this.targetDeltaAdapter = targetDeltaAdapter;		
	}

	@Override
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncForward(SourceArtefactDelta artefactDelta)throws SynchronisationFailedException {
		
		ModelDelta delta = sourceDeltaAdapter.parse(artefactDelta, synchroniser.getSourceModel());
		synchroniser.syncForward(delta);

		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();

		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();

		SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncResult = 
												new SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed>(
																	sourceArtefactAdapter,
																	targetArtefactAdapter,
																	synchroniser.getFailedDelta());

		return syncResult;
	}

	@Override
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncBackward(
			TargetArtefactDelta artefactDelta) throws SynchronisationFailedException{
		ModelDelta delta = targetDeltaAdapter.parse(artefactDelta, synchroniser.getTargetModel());

		synchroniser.syncBackward(delta);

		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();

		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();

		SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncResult = new SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed>(
				sourceArtefactAdapter, targetArtefactAdapter, synchroniser.getFailedDelta());

		return syncResult;
	}

	@Override
	public void setUpdatePolicy(UpdatePolicy updatePolicy) {
		synchroniser.setUpdatePolicy(updatePolicy);
	}

	@Override
	public void initialise() throws SynchronisationFailedException {
		synchroniser.initialise();
		
	}
}
