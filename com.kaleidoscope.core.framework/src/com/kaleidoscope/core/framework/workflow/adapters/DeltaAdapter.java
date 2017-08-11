package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.javabased.Delta;

public interface DeltaAdapter<
		D extends Delta, 
		ArtefactDelta, 
		Model
	> {
	
	public D parse(ArtefactDelta ad, Model m);
	public ArtefactDelta unparse(D d, Model a);

}
