package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.controllers.Controller;

public interface DeltaBased<SourceModel, SourceArtefact, TargetModel, TargetArtefact, SourceArtefactDelta, TargetArtefactDelta, UpdatePolicy, Failed extends IDelta>
		extends Controller<SourceArtefact, TargetArtefact,  UpdatePolicy> {
	
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncForward(SourceArtefactDelta artefactDelta) throws SynchronisationFailedException;
	public SynchronisationResult<SourceModel, SourceArtefact, TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefactDelta artefactDelta)throws SynchronisationFailedException;
	
	
}
