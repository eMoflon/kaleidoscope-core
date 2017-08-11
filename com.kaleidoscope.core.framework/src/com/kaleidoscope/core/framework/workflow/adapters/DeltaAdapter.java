package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface DeltaAdapter<
		ModelDelta extends Delta, 
		ArtefactDelta, 
		Model
	> {
	
	public ModelDelta parse(ArtefactDelta ad, Model m);
	public ArtefactDelta unparse(ModelDelta d, Model a);

}
