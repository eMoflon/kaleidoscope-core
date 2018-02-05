package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.IDelta;

public interface ContinuableSynchroniser<
		SourceModel, TargetModel, 
		UpdatePolicy, Input extends IDelta, 
		Failed extends IDelta> 
	extends Synchroniser<
		SourceModel, TargetModel, 
		UpdatePolicy, Input, Failed> {

	public boolean hasContinuation();
	public void continueSync();
	public UpdatePolicy getContinuationPolicy();
	
}
