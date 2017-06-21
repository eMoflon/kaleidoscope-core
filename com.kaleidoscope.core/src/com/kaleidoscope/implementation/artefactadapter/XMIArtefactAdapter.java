package com.kaleidoscope.implementation.artefactadapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.caleidoscope.extensionpoint.ArtefactAdapter;

public class XMIArtefactAdapter implements ArtefactAdapter {

	private ResourceSet resourceSet;
	private Path filePath;
	private static final Logger logger = Logger.getLogger(XMIArtefactAdapter.class);
	
	public void initialize(ResourceSet set){
		this.resourceSet = set;
	}
	
	@Override
	public <M> M parse() {	
		
		logger.info("Parsing " + filePath + " to XMI model is being performed!");
		File file = filePath.toFile();
		Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
		try {
			resource.load(null);
		} catch (IOException e) {
			logger.error("Not able to load the XMI file from "+ filePath, e);
			return null;
		}
		return (M)resource.getContents().get(0);
	
	}
	@Override
	public <M> void unparse(M rootElementOfModel) {
		logger.info("Starting to unparse XMI!");
		
		File file = filePath.toFile();  
		Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
		
		try {			
			resource.getContents().add((EObject) rootElementOfModel);
			resource.save(null);
			
			logger.info("XMI Resource saved!");
			
		} catch (IOException e) {
			logger.error("Not able to safe XMI Resource!", e);			
		}		
	}

	@Override
	public <P> void setParseSource(P parseSource) {
		this.filePath = (Path)parseSource;
		
	}

	@Override
	public <P> void setUnParseSource(P unparseSource) {
		this.filePath = (Path)unparseSource;
		
	}

}
