package com.kaleidoscope.extensionpoint;

import org.eclipse.emf.ecore.EObject;

import Deltameta.Delta;

public interface DeltaDiscoverer {
	public Delta generateDeltaSpecFromModels(EObject oldModel, EObject newModel);
}
