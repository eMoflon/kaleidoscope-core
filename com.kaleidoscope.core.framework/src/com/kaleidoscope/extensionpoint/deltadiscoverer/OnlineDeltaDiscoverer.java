package com.kaleidoscope.extensionpoint.deltadiscoverer;

import com.kaleidoscope.delta.javabased.JavaBasedDelta;

public interface OnlineDeltaDiscoverer {
	
	public <M>void generateDeltaFromModel(M srcModel);
	public JavaBasedDelta getCurrentDelta();
	public void start();
	public void restart();
	public void stop();
}
