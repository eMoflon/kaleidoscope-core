package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface Synchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		Input extends Delta, 
		Failed extends Delta
	> {
	
	public  SourceModel getSourceModel();
	public  TargetModel getTargetModel();
	
	public void syncForward(Input srcDelta)throws SynchronisationFailedException;
	public void syncBackward(Input trgDelta) throws SynchronisationFailedException;
	
	public Failed getFailedDelta();
	public void setUpdatePolicy(UpdatePolicy updatePolicy);
	
	public void initialise() throws SynchronisationFailedException;
	public void terminate();
	
}
