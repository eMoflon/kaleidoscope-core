package com.kaleidoscope.core.framework.workflow.controllers;

import com.kaleidoscope.core.framework.synchronisation.SynchronisationFailedException;

public interface Controller<SourceArtefact, TargetArtefact, UpdatePolicy> {
	
	void setUpdatePolicy(UpdatePolicy updatePolicy);
	void initialise() throws SynchronisationFailedException;
	
	
}
