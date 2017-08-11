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
	
	public void syncForward(Input srcDelta);
	public void syncBackward(Input trgDelta);
	
	public Failed getFailedDelta();
	public void setUpdatePolicy(UpdatePolicy updatePolicy);
	
	public void initialize();
	public void terminate();
	
}
