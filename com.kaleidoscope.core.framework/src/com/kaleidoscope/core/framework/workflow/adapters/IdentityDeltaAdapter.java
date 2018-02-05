package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.IDelta;

public class IdentityDeltaAdapter<ModelDelta extends IDelta, Model> implements DeltaAdapter<ModelDelta, ModelDelta, Model> {
	@Override
	public ModelDelta parse(ModelDelta md, Model m) {
		return md;
	}
}
