package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.Delta;

public class IdentityDeltaAdapter<ModelDelta extends Delta, Model> implements DeltaAdapter<ModelDelta, ModelDelta, Model> {
	@Override
	public ModelDelta parse(ModelDelta md, Model m) {
		return md;
	}
}
