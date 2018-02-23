package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.IDelta;

public interface PersistentSynchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy,  
		Input extends IDelta, 
		Failed extends IDelta, 
		Destination
	> 
	extends Synchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy, 
		Input, 
		Failed
	> {
	
	public void persistState(Destination toDestination);
	public void restoreState(Destination fromDestination);

}
