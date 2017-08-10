package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface Synchroniser<SourceModel, TargetModel, UpdatePolicy, D extends Delta, F extends Delta> {
	
	public  SourceModel getSourceModel();
	public  TargetModel getTargetModel();
	
	public void syncForward(D srcDelta);
	public void syncBackward(D trgDelta);
	
	public F getFailedDelta();
	public void setUpdatePolicy(UpdatePolicy updatePolicy);
	
	public void initialize();
	public void terminate();
	
}
