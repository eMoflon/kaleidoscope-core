package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.IDelta;

public interface DeltaInputAdapter<ModelDelta extends IDelta, ArtefactDelta, Model> {
	public ModelDelta parse(ArtefactDelta ad, Model m);
}
