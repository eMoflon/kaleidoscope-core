package com.kaleidoscope.core.framework.workflow.controllers.statebased;

import com.kaleidoscope.core.framework.workflow.controllers.Controller;

public interface StateBased<SourceArtefact, TargetArtefact> extends 
			     Controller<SourceArtefact, TargetArtefact> {
	public TargetArtefact syncForward(SourceArtefact sourceArtefact);
	public SourceArtefact syncBackward(TargetArtefact targetArtefact);
}
