package com.kaleidoscope.core.delta.javabased.opaque;

import com.kaleidoscope.core.delta.javabased.Delta;

@FunctionalInterface
public interface OpaqueDelta<Model> extends Delta {

	void execute(Model model);
	
}
