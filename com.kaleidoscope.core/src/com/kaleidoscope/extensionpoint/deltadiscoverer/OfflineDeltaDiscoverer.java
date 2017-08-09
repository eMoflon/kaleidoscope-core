package com.kaleidoscope.extensionpoint.deltadiscoverer;
import com.kaleidoscope.delta.javabased.JavaBasedDelta;

public interface OfflineDeltaDiscoverer<M> extends DeltaDiscoverer {
	public JavaBasedDelta generateDeltaSpecFromModels(M oldModel, M newModel);
}