package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;

public class SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed extends IDelta, UpdatePolicy>
						extends SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed>{

	private boolean hasContinuation;
	private UpdatePolicy updatePolicy;
	
	
	public SynchronisationContinuationResult() {
		
	}
	
	public SynchronisationContinuationResult(ArtefactAdapter<SourceModel, SourceArtefact> sourceArtefact, ArtefactAdapter<TargetModel, TargetArtefact> targetArtefact, Failed failedDelta, UpdatePolicy updatePolicy, boolean hasContinuation) {		
		super(sourceArtefact, targetArtefact, failedDelta);
	}
	
	public SynchronisationContinuationResult(SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncResult) {
		this.sourceArtefactAdapter = syncResult.getSourceArtefactAdapter();
		this.targetArtefactAdapter = syncResult.getTargetArtefactAdapter();
		this.failedDelta = syncResult.failedDelta;		
	}
	
	public boolean isHasContinuation() {
		return hasContinuation;
	}

	public void setHasContinuation(boolean hasContinuation) {
		this.hasContinuation = hasContinuation;
	}
	
	public UpdatePolicy getUpdatePolicy() {
		return updatePolicy;
	}

	public void setUpdatePolicy(UpdatePolicy updatePolicy) {
		this.updatePolicy = updatePolicy;
	}
}
