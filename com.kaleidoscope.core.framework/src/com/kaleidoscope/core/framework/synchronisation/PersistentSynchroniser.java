package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface PersistentSynchroniser<
		SourceModel, 
		TargetModel, 
		UpdatePolicy,  
		Input extends Delta, 
		Failed extends Delta, 
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
