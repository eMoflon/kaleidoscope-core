package com.kaleidoscope.extensionpoint.bxtool;

import java.util.Optional;

import org.eclipse.emf.ecore.resource.ResourceSet;
import com.kaleidoscope.extensionpoint.UpdatePolicy;
import com.kaleidoscope.ui.delta.javabased.JavaBasedDelta;

public interface BXtool<S, T, D> {
	
	public void setResourceSet(ResourceSet resourceSet);
	
	public  S getSourceModel();
	public  T getTargetModel();
	
	public void setSourceModel(S sourceModel);
	public void setTargetModel(T targetModel);

	public void sourceToTargetTransformation();
	public void targetToSourceTransformation();
	
	public Optional<SynchronizationReport> syncForwardFromJavaBasedDelta(JavaBasedDelta javaBasedDelta, Optional<UpdatePolicy<?>> updatePolicy);
	public Optional<SynchronizationReport> syncBackwardFromJavaBasedDelta(JavaBasedDelta javaBasedDelta, Optional<UpdatePolicy<?>> updatePolicy);
	
	public void persistState(D toDestination);
	public void restoreState(D fromDestination);
	public void clear();
	public void initialize();
}
