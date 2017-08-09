package com.kaleidoscope.implementation.artefactadapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.kaleidoscope.extensionpoint.ArtefactAdapter;

public class XMIArtefactAdapter implements ArtefactAdapter {

	ResourceSet resourceSet;
	
	private static final Logger logger = Logger.getLogger(XMIArtefactAdapter.class);
	
	@Override
	public Object parse(Object parseSource) {	
		
		logger.info("Parsing to XMI model is being performed!");
		try {
			
			Path parsePath = (Path)parseSource;
			File file = parsePath.toFile();
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
			
			resource.load(null);
			
			return resource.getContents().get(0);
			
			
		} catch (IOException e) {
			
			logger.error("Not able to load the XMI file from the provided parseSource", e);
			return null;
			
		}catch(ClassCastException e){
			logger.error("Not able to cast parseSource into Path class", e);
			return null;
		}
		
	
	}
	@Override
	public void unparse(Object unparseSource, Object content) {
		logger.info("Starting to unparse XMI!");
		
		try {
			
			File file = ((Path) unparseSource).toFile();  
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
					
			resource.getContents().add((EObject) content);
			resource.save(null);
			
			logger.info("XMI Resource saved!");
			
		} catch (IOException | ClassCastException e) {
			logger.error("Not able to safe XMI Resource!", e);			
		}		
	}
	public void setResourceSet(ResourceSet resourceSet){
		this.resourceSet = resourceSet;
	}
}
