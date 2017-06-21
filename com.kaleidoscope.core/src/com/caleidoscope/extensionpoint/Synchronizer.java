package com.caleidoscope.extensionpoint;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface Synchronizer {

	public void sourceToTargetTransformation(Optional<Consumer<EObject>>targetModelPostProcessing);
	public void targetToSourceTransformation();
	public void syncForwardFromDelta();
	public void syncBackwardFromDelta();
	
	public void persistModels();
	
	public void setSourceArtefactAdapter(ArtefactAdapter sourceEditor);
	public void setTargetArtefactAdapter(ArtefactAdapter targetEditor);
	
	public Path getDeltaPath();
	public void setDeltaPath(Path absDeltaPath);
	public void initialize(BXtool tool, DeltaDiscovery deltaDiscover, ArtefactAdapter deltaArtefactAdapter);
}
