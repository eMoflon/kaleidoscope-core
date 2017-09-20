package com.kaleidoscope.core.framework.workflow.controllers;

public interface Controller<SourceArtefact, TargetArtefact, UpdatePolicy> {
	
	void setUpdatePolicy(UpdatePolicy updatePolicy);
	
	
	
}
