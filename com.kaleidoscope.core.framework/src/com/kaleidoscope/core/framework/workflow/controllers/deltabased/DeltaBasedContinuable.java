package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationContinuationResult;

public interface DeltaBasedContinuable<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed extends IDelta, UpdatePolicy>{

	public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> continueSync();
	
}
