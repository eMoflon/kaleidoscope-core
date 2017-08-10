package com.kaleidoscope.core.framework.synchronisation;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface PersistentSynchroniser<SourceModel, TargetModel, UpdatePolicy, Destination,  D extends Delta, F extends Delta> extends Synchroniser<SourceModel, TargetModel, UpdatePolicy, D, F> {
	
	public void persistState(Destination toDestination);
	public void restoreState(Destination fromDestination);

}
