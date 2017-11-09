package com.kaleidoscope.core.auxiliary.xmi.artefactadapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.kaleidoscope.core.framework.workflow.adapters.ArtefactAdapter;


public class XMIArtefactAdapter<Model extends EObject> implements ArtefactAdapter<Model, Path> {

	private final static Logger logger = Logger.getLogger(XMIArtefactAdapter.class); 
	
	private ResourceSet resourceSet;	
	private Optional<Model> model;
	private Path path;
	
	public XMIArtefactAdapter(Path path) {
		
		ResourceSet set = new ResourceSetImpl();
		set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		this.resourceSet = set;
		this.path = path;
		this.model = Optional.empty();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void parse() {	
		logger.debug("Parsing to XMI");
		try {
			File file = path.toFile();
			System.out.println(file.exists());
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));
			resource.load(null);
			
			if(resource.getContents().isEmpty()) 
				model =  Optional.empty();
			else
				model = Optional.of((Model)resource.getContents().get(0));
			
		} catch (IOException e) {	
			logger.error("Not able to load the XMI file from " + path);			
		}catch(ClassCastException e){			
			logger.error("Not able to cast " + path + " to required type: " + e.getMessage());
		}
	}
	
	@Override
	public void unparse() {
		logger.debug("Starting to unparse XMI!");
		
		try {
			File file = path.toFile();  
			Resource resource = resourceSet.createResource(URI.createFileURI(file.getAbsolutePath()));	
			model.ifPresent(m -> resource.getContents().add(m));
			resource.save(null);			
			logger.debug("XMI Resource saved!");
		} catch (IOException | ClassCastException e) {
			logger.error("Not able to save XMI resource: " + e.getMessage());					
		}		
	}

	@Override
	public Optional<Model> getModel() {
		return model;
	}

	@Override
	public Optional<Path> getArtefact() {
		return Optional.of(path);
	}

	@Override
	public void setModel(Model m) {
		model = Optional.of(m);
	}

	@Override
	public void setArtefact(Path a) {
		path = a;
	}

}
