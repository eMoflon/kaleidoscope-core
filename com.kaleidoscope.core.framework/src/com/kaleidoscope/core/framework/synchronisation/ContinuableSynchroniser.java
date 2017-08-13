package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface ContinuableSynchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		Input extends Delta, 
		Failed extends Delta
	> 
	extends Synchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		Input, 
		Failed
	> {

	public boolean hasContinuation();
	public void continueSync();
	public UpdatePolicy getContinuationPolicy();
	
}
