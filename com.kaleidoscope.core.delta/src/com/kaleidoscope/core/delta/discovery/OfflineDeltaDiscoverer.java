package com.kaleidoscope.core.delta.discovery;
import com.kaleidoscope.core.delta.javabased.Delta;

public interface OfflineDeltaDiscoverer<Model, D extends Delta> extends DeltaDiscoverer<Model, D> {
	public D discoverDelta(Model oldModel, Model newModel);
}
