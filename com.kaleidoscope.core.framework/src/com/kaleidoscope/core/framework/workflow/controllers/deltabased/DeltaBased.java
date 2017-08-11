package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

public interface DeltaBased<
		SourceArtefact, 
		TargetArtefact,
		SourceArtefactDelta,
		TargetArtefactDelta
	> {
	public TargetArtefact syncForward(SourceArtefactDelta artefactDelta);
	public SourceArtefact syncBackward(TargetArtefactDelta artefactDelta);
}
