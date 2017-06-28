package com.kaleidoscope.extensionpoint;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.runtime.DeltaSpecification;

public interface DeltaDiscoverer {
	public DeltaSpecification generateDeltaSpecFromModels(EObject oldModel, EObject newModel);
}
