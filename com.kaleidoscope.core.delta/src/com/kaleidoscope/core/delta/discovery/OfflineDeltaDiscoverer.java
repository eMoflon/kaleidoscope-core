package com.kaleidoscope.core.delta.discovery;
import com.kaleidoscope.core.delta.javabased.IDelta;

public interface OfflineDeltaDiscoverer<Model, D extends IDelta> extends DeltaDiscoverer<Model, D> {
	public D discoverDelta(Model oldModel, Model newModel);
}
