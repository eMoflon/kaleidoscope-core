package com.caleidoscope.extensionpoint;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.runtime.DeltaSpecification;

public interface DeltaDiscovery {
	public DeltaSpecification generateDeltaSpecFromModels(EObject oldModel, EObject newModel);
}
