package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.controllers.Controller;

public interface DeltaBased<SourceModel, SourceArtefact, TargetModel, TargetArtefact, SourceArtefactDelta, TargetArtefactDelta, UpdatePolicy, Failed extends Delta>
		extends Controller<SourceArtefact, TargetArtefact,  UpdatePolicy> {
	
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncForward(SourceArtefactDelta artefactDelta);
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefactDelta artefactDelta);
	
	
}
