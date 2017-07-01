package com.kaleidoscope.extensionpoint;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface ArtefactAdapter {

	public <M> M parse(Object parseSource);
	public <M> void unparse(Object unparseSource, M content);
	public void setResourceSet(ResourceSet resourceSet);
}
