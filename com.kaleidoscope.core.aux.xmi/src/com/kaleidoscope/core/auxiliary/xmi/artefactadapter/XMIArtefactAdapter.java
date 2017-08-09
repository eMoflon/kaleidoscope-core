package com.kaleidoscope.core.auxiliary.xmi.artefactadapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.kaleidoscope.extensionpoint.ArtefactAdapter;

public class XMIArtefactAdapter implements ArtefactAdapter<EObject, Path> {

	ResourceSet resourceSet;
	
	private static final Logger logger = Logger.getLogger(XMIArtefactAdapter.class);
	
	@Override
	public EObject parse(Path parseSource) {	
		
		logger.info("Parsing to XMI model is being performed!");
		try {
			
			Path parsePath = parseSource;
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
	public void unparse(Path unparseSource, EObject content) {
		logger.info("Starting to unparse XMI!");
		
		try {
			File file = unparseSource.toFile();  
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
					
			resource.getContents().add(content);
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
