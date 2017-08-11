package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import com.kaleidoscope.core.framework.workflow.controllers.Controller;

public interface DeltaBased <
		SourceArtefact, 
		TargetArtefact,
		SourceArtefactDelta,
		TargetArtefactDelta
	> extends Controller<
		SourceArtefact, 
		TargetArtefact
	> {
	public TargetArtefact syncForward(SourceArtefactDelta artefactDelta);
	public SourceArtefact syncBackward(TargetArtefactDelta artefactDelta);
}
