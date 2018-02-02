package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface Synchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		Input extends Delta, 
		Failed extends Delta
	> {
	
	SourceModel getSourceModel();
	TargetModel getTargetModel();
	
	void syncForward(Input srcDelta)throws SynchronisationFailedException;
	void syncBackward(Input trgDelta) throws SynchronisationFailedException;
	
	Failed getFailedDelta();
	void setUpdatePolicy(UpdatePolicy updatePolicy);
	
	void initialise() throws SynchronisationFailedException;
	void terminate();
}
