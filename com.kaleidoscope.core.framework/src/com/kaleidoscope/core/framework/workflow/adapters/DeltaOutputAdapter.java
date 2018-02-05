package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.IDelta;

public interface DeltaOutputAdapter<ModelDelta extends IDelta, ArtefactDelta, Artefact> {
	public ArtefactDelta unparse(ModelDelta md, Artefact a);
}
