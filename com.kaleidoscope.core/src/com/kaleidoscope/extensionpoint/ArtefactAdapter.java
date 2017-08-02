package com.kaleidoscope.extensionpoint;

import org.eclipse.emf.ecore.resource.ResourceSet;

public interface ArtefactAdapter<M, S> {

	public  M parse(S parseSource);
	public  void unparse(S unparseSource, M content);
	public void setResourceSet(ResourceSet resourceSet);
}
