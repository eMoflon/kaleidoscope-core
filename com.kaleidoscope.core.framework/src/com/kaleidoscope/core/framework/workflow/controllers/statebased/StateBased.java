package com.kaleidoscope.core.framework.workflow.controllers.statebased;

import com.kaleidoscope.core.delta.javabased.IDelta;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;
import com.kaleidoscope.core.framework.synchronisation.SynchronisationResult;
import com.kaleidoscope.core.framework.workflow.controllers.Controller;

public interface StateBased<SourceModel, SourceArtefact, TargetModel, TargetArtefact, UpdatePolicy, Failed extends IDelta> extends 
			     Controller<SourceArtefact, TargetArtefact, UpdatePolicy> {
	
	
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncForward(SourceArtefact sourceArtefact) throws SynchronisationFailedException;
	public SynchronisationResult<SourceModel, SourceArtefact,TargetModel, TargetArtefact, Failed> syncBackward(TargetArtefact targetArtefact)throws SynchronisationFailedException;
	
}
