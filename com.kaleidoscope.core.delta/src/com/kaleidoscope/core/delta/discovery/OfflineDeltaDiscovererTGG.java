package com.kaleidoscope.core.delta.discovery;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface OfflineDeltaDiscovererTGG<Model, D extends Delta> extends DeltaDiscoverer<Model, D> {
	public D discoverDelta(EObject oldModel, EObject newModel, String metaModel);
}
