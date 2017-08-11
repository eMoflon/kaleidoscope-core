package com.kaleidoscope.core.framework.workflow.controllers.statebased;

public interface StateBased<SourceArtefact, TargetArtefact> {
	public TargetArtefact syncForward(SourceArtefact sourceArtefact);
	public SourceArtefact syncBackward(TargetArtefact targetArtefact);
}
