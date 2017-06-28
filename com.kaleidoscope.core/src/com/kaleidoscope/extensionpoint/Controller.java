package com.kaleidoscope.extensionpoint;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

public interface Controller {

	public void sourceToTargetTransformation(Optional<Consumer<EObject>>targetModelPostProcessing);
	public void targetToSourceTransformation();
	public void syncForwardFromDelta();
	public void syncBackwardFromDelta();
	
	public void persistModels();
	
	public void setSourceArtefactAdapter(ArtefactAdapter sourceEditor);
	public void setTargetArtefactAdapter(ArtefactAdapter targetEditor);
	
	public Path getDeltaPath();
	public void setDeltaPath(Path absDeltaPath);
	public void initialize(BXtool tool, DeltaDiscoverer deltaDiscover, ArtefactAdapter deltaArtefactAdapter);
}
