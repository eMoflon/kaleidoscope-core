package com.kaleidoscope.core.framework.workflow.controllers.deltabased;

import org.apache.commons.lang3.tuple.Pair;

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
	public Pair<SourceArtefact, TargetArtefact> syncForward(SourceArtefactDelta artefactDelta);
	public Pair<SourceArtefact, TargetArtefact> syncBackward(TargetArtefactDelta artefactDelta);
}
