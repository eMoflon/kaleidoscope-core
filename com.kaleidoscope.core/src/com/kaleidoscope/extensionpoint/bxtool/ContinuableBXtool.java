package com.kaleidoscope.extensionpoint.bxtool;

import java.util.List;

public interface ContinuableBXtool<S, T, D, C> extends BXtool<S, T, D> {

	public boolean hasContinuation();
	public List<C> getChoicesForContinuation();
	public void continueSync(C choice);
}
