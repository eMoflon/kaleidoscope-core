package com.caleidoscope.extensionpoint;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface ArtefactAdapter {

	public <M> M parse();
	public <M> void unparse(M rootElementOfModel);
		
	public <P>void setParseSource(P parseSource);
	public <P>void setUnParseSource(P unparseSource);
	
}
