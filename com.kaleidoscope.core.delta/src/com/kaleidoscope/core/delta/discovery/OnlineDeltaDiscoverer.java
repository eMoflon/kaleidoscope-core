package com.kaleidoscope.core.delta.discovery;

import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

public interface OnlineDeltaDiscoverer<Model> extends DeltaDiscoverer<Model, OperationalDelta> {
	
	public void generateDeltaFromModel(Model srcModel);
	public OperationalDelta getCurrentDelta();
	public void start();
	public void restart();
	public void stop();
	
}
