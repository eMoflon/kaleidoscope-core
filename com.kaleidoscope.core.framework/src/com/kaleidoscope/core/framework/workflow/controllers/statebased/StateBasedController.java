package com.kaleidoscope.core.framework.workflow.controllers.statebased;

import com.google.inject.Inject;
import com.kaleidoscope.core.delta.discovery.OfflineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.annotations.Src;
import com.kaleidoscope.core.framework.annotations.Trg;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.synchronisation.Synchroniser;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class StateBasedController <
		SourceModel, SourceArtefact, 
		TargetModel, TargetArtefact, 
		ModelDelta extends Delta, UpdatePolicy, 
		Failed extends Delta> 
	implements StateBased<
		SourceModel, SourceArtefact,TargetModel, TargetArtefact,
		UpdatePolicy,Failed>
	{
	protected final ArtefactAdapter<SourceModel,SourceArtefact> sourceArtefactAdapter;
	protected final ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter;
	protected final Synchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> synchroniser;
	protected final OfflineDeltaDiscoverer<SourceModel, ModelDelta> sourceDeltaDiscoverer;
	protected final OfflineDeltaDiscoverer<TargetModel, ModelDelta> targetDeltaDiscoverer;
	
	@Inject
	public StateBasedController(
			@Src ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefactAdapter, 
			@Trg ArtefactAdapter<TargetModel, TargetArtefact> targetArtefactAdapter,
			     Synchroniser<SourceModel, TargetModel, UpdatePolicy, ModelDelta, Failed> synchroniser, 
			@Src OfflineDeltaDiscoverer<SourceModel, ModelDelta> sourceDeltaDiscoverer,
			@Trg OfflineDeltaDiscoverer<TargetModel, ModelDelta> targetDeltaDiscoverer
		){
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		this.targetArtefactAdapter = targetArtefactAdapter;
		this.synchroniser = synchroniser;
		this.sourceDeltaDiscoverer = sourceDeltaDiscoverer;
		this.targetDeltaDiscoverer = targetDeltaDiscoverer;
	}	
	
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncForward(SourceArtefact sourceArtefact)throws SynchronisationFailedException{
		sourceArtefactAdapter.setArtefact(sourceArtefact);
		sourceArtefactAdapter.parse();
		
		SourceModel newSourceModel = sourceArtefactAdapter.getModel().orElse(synchroniser.getSourceModel());
		SourceModel oldSourceModel = synchroniser.getSourceModel();
		
		ModelDelta delta = sourceDeltaDiscoverer.discoverDelta(newSourceModel, oldSourceModel);
		synchroniser.syncForward(delta);	
	
		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();
		
		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();

		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = new SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed>(
				sourceArtefactAdapter, 
				targetArtefactAdapter,
				synchroniser.getFailedDelta());
		
		return syncResult;		
	}
	
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefact targetArtefact) throws SynchronisationFailedException{
		targetArtefactAdapter.setArtefact(targetArtefact);
		targetArtefactAdapter.parse();
		
		TargetModel newTargetModel = targetArtefactAdapter.getModel().orElse(synchroniser.getTargetModel());
		TargetModel oldTargetModel = synchroniser.getTargetModel();
		
		ModelDelta delta = targetDeltaDiscoverer.discoverDelta(newTargetModel, oldTargetModel);
		synchroniser.syncBackward(delta);
		
		SourceModel sourceModel = synchroniser.getSourceModel();
		sourceArtefactAdapter.setModel(sourceModel);
		sourceArtefactAdapter.unparse();
		
		TargetModel targetModel = synchroniser.getTargetModel();
		targetArtefactAdapter.setModel(targetModel);
		targetArtefactAdapter.unparse();
		
		SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncResult = new SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed>(
				sourceArtefactAdapter, 
				targetArtefactAdapter,
				synchroniser.getFailedDelta());
		
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