package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationContinuationResult;

public interface DeltaBasedContinuable<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed extends Delta, UpdatePolicy>{

	public SynchronisationContinuationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed, UpdatePolicy> continueSync();
	
}
