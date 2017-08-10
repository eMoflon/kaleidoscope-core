package com.kaleidoscope.core.auxiliary.xmi.artefactadapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;


public class XMIArtefactAdapter<M extends EObject> implements ArtefactAdapter<M, Path> {

	private ResourceSet resourceSet;
	private Path path;
	
	public XMIArtefactAdapter(ResourceSet resourceSet, Path path) {
		this.resourceSet = resourceSet;
		this.path  = path;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public M parse(Path parseSource) {	
		
		System.out.println("Parsing to XMI model is being performed!");
		try {
						
			File file = path.toFile();
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
			
			resource.load(null);
			
			return (M)resource.getContents().get(0);	
			
		} catch (IOException e) {
			
			System.out.println("Not able to load the XMI file from the provided parseSource");			
			return null;
			
		}catch(ClassCastException e){			
			System.out.println("Not able to cast parseSource into Path class");
			return null;
		}
	}
	
	@Override
	public Path unparse(M content) {
		System.out.println("Starting to unparse XMI!");
		
		try {
			
			File file = path.toFile();  
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
					
			resource.getContents().add(content);
			resource.save(null);
			
			System.out.println("XMI Resource saved!");
		
		} catch (IOException | ClassCastException e) {
			System.out.println("Not able to safe XMI Resource!");					
		}		
		return path;
	}
}
