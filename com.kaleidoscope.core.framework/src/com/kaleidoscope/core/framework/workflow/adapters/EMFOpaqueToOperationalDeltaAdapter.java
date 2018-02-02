package com.kaleidoscope.core.framework.workflow.adapters;

import com.kaleidoscope.core.delta.discovery.EMFOnlineChangeDetector;
import com.kaleidoscope.core.delta.discovery.OnlineDeltaDiscoverer;
import com.kaleidoscope.core.delta.javabased.opaque.OpaqueDelta;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

public class EMFOpaqueToOperationalDeltaAdapter<Model> implements DeltaAdapter<OperationalDelta, OpaqueDelta<Model>, Model> {
	
	
	@Override
	public OperationalDelta parse(OpaqueDelta<Model> md, Model m) {
		OnlineDeltaDiscoverer<Model> deltaDiscoverer = new EMFOnlineChangeDetector<Model>();
		deltaDiscoverer.generateDeltaFromModel(m);
		deltaDiscoverer.start();
		md.execute(m);
		deltaDiscoverer.stop();
		OperationalDelta delta = deltaDiscoverer.getCurrentDelta();
		delta.rollback();
		return deltaDiscoverer.getCurrentDelta();
	}
	
	
	
}