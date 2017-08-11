package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface ContinuableSynchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		D extends Delta, 
		F extends Delta
	> 
	extends Synchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		D, 
		F
	> {

	public boolean hasContinuation();
	public void continueSync();
	
}
