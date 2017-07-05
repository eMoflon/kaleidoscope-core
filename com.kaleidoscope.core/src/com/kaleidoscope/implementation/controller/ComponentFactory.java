package com.kaleidoscope.implementation.controller;

import java.util.Optional;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.kaleidoscope.extensionpoint.ArtefactAdapter;
import com.kaleidoscope.extensionpoint.BXtool;
import com.kaleidoscope.extensionpoint.DeltaDiscoverer;

public class ComponentFactory {
	
	static ResourceSet resourceSet;
	static final String ARTEFACT_ADAPTER_EXTENSON_ID = "com.kaleidoscope.extensionpoint.artefactadapter";
	static final String DELTA_DISCOVER_EXTENSON_ID = "com.kaleidoscope.extensionpoint.deltadiscoverer";
	static final String COMPONENT_BUILDER_EXTENSON_ID = "com.kaleidoscope.extensionpoint.componentbuilder";
	static final String BXTOOL_EXTENSON_ID = "com.kaleidoscope.extensionpoint.bxtool";
	public static String COMPONENT_FACTORY_ID;
	
	private static String SOURCE_ARTEFACT_ADAPTER_ID;
	private static String TARGET_ARTEFACT_ADAPTER_ID;
	private static String DELTA_ARTEFACT_ADAPTER_ID;
	private static String BX_TOOL_NAME;
	
	private Optional<ArtefactAdapter> sourceArtefactAdapter;
	private Optional<ArtefactAdapter> targetArtefactAdapter;
	private Optional<ArtefactAdapter> deltaArtefactAdapter;
	private Optional<BXtool> tool;
	private Optional<DeltaDiscoverer> deltaDiscoverer;
	
	
	public Optional<DeltaDiscoverer> getDeltaDiscoverer() {
		return deltaDiscoverer;
	}

   public static final ResourceSet createDefaultResourceSet()
   {
      final ResourceSetImpl set = new ResourceSetImpl();
      return set;
   }

	public void setDeltaDiscoverer(Optional<DeltaDiscoverer> deltaDiscoverer) {
		this.deltaDiscoverer = deltaDiscoverer;
	}

	//private static ComponentFactory instance = null;
	
	public static ComponentFactory getInstance() {
	     
	    	 resourceSet = createDefaultResourceSet();
	    	 acquireDataFromExtension();
	    	 ComponentFactory instance = new ComponentFactory();
	    	 
	    	 instance.setSourceArtefactAdapter(artefactAdapterFactory(SOURCE_ARTEFACT_ADAPTER_ID, null));
	    	 instance.setTargetArtefactAdapter(artefactAdapterFactory(TARGET_ARTEFACT_ADAPTER_ID, null));
	    	 instance.setDeltaArtefactAdapter(artefactAdapterFactory(DELTA_ARTEFACT_ADAPTER_ID, null));
	    	 instance.setDeltaDiscoverer(deltaDiscoveryFactory());
	    	 instance.setTool(bxToolFactory());	
	    	 
	    	 instance.sourceArtefactAdapter.ifPresent(o -> o.setResourceSet(resourceSet));
	    	 instance.targetArtefactAdapter.ifPresent(o -> o.setResourceSet(resourceSet));
	    	 instance.deltaArtefactAdapter.ifPresent(o -> o.setResourceSet(resourceSet));
	    	 instance.tool.ifPresent(o -> o.setResourceSet(resourceSet));
	         return instance;
	 }
	
	
	private static void acquireDataFromExtension(){
		 IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(COMPONENT_BUILDER_EXTENSON_ID);
	        for (IConfigurationElement e : config) {
	        	
	        	Optional<String> componentFactoryID = Optional.ofNullable(e.getAttribute("componentFactoryID"));
	        	
	        	if(!componentFactoryID.equals(Optional.of(COMPONENT_FACTORY_ID)))
	        		continue;
	        	
				Optional<String> sourceArtefactAdapterID = Optional.ofNullable(e.getAttribute("sourceArtefactAdapterID"));
				Optional<String> targetArtefactAdapterID = Optional.ofNullable(e.getAttribute("targetArtefactAdapterID"));
				Optional<String> deltaArtefactAdapterID = Optional.ofNullable(e.getAttribute("deltaArtefactAdapterID"));
				Optional<String> toolName = Optional.ofNullable(e.getAttribute("toolName"));
				
				sourceArtefactAdapterID.ifPresent(o -> SOURCE_ARTEFACT_ADAPTER_ID = o);
				targetArtefactAdapterID.ifPresent(o -> TARGET_ARTEFACT_ADAPTER_ID = o);
				deltaArtefactAdapterID.ifPresent(o -> DELTA_ARTEFACT_ADAPTER_ID = o);
				toolName.ifPresent(o -> BX_TOOL_NAME = o);	
			}
	}
	
	
	public static void resetTool(ComponentFactory instance){
		instance.setTool(bxToolFactory());
	}
	
	public Optional<BXtool> getTool() {
		return tool;
	}

	public void setTool(Optional<BXtool> tool) {
		this.tool = tool;
	}
	public Optional<ArtefactAdapter> getDeltaArtefactAdapter() {
		return deltaArtefactAdapter;
	}

	public void setDeltaArtefactAdapter(Optional<ArtefactAdapter> deltaArtefactAdapter) {
		this.deltaArtefactAdapter = deltaArtefactAdapter;
	}
	
	public Optional<ArtefactAdapter> getSourceArtefactAdapter() {
		return sourceArtefactAdapter;
	}


	public void setSourceArtefactAdapter(Optional<ArtefactAdapter> sourceArtefactAdapter) {
		this.sourceArtefactAdapter = sourceArtefactAdapter;
	}


	public Optional<ArtefactAdapter> getTargetArtefactAdapter() {
		return targetArtefactAdapter;
	}


	public void setTargetArtefactAdapter(Optional<ArtefactAdapter> targetArtefactAdapter) {
		this.targetArtefactAdapter = targetArtefactAdapter;
	}


	public static Optional<BXtool> bxToolFactory() {
		 IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(BXTOOL_EXTENSON_ID);
	        try {
	        	for (IConfigurationElement e : config) {
	            	
	            	Optional<String> typeAttribute = Optional.ofNullable(e.getAttribute("name"));
	            	
	            	if(typeAttribute.equals(Optional.of(BX_TOOL_NAME))){
	            			                
		                final Object o = e.createExecutableExtension("class");
		                if (o instanceof BXtool) {
		                	return Optional.of((BXtool)o);
		                }
	            	}
	            }	           
	        } catch (CoreException ex) {
	            //LogUtils.error(logger, ex);
	        }
	        return Optional.empty();
    }
	
	
	public static Optional<DeltaDiscoverer> deltaDiscoveryFactory() {
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(DELTA_DISCOVER_EXTENSON_ID);
        try {
        	for (IConfigurationElement e : config) {
            	
            	Optional<String> typeAttribute = Optional.ofNullable(e.getAttribute("default"));
            	
            	if(typeAttribute.equals(Optional.of(true))){
            			                
	                final Object o = e.createExecutableExtension("class");
	                if (o instanceof DeltaDiscoverer) {
	                	return Optional.of((DeltaDiscoverer)o);
	                }
            	}
            }
            for (IConfigurationElement e : config) {                 
	                final Object o = e.createExecutableExtension("class");
	                if (o instanceof DeltaDiscoverer) {
	                	return Optional.of((DeltaDiscoverer)o);
	                }  
            }
        } catch (CoreException ex) {
            //LogUtils.error(logger, ex);
        }
        return Optional.empty();
    }
	
	public static  Optional<ArtefactAdapter> artefactAdapterFactory(String id, String extension) {
        IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(ARTEFACT_ADAPTER_EXTENSON_ID);
        try {
            for (IConfigurationElement e : config) {
            	
            	Optional<String> idAttribute = Optional.ofNullable(e.getAttribute("id"));
            	
            	if(idAttribute.equals(Optional.of(id))){
            		final ArtefactAdapter o = (ArtefactAdapter)e.createExecutableExtension("class");
            		o.setResourceSet(resourceSet);            		
                    return Optional.of((ArtefactAdapter)o);
            	}          
            }
            for (IConfigurationElement e : config) {
            	
            	Optional<String> extensionAttribute = Optional.ofNullable(e.getAttribute("extension"));
            	
            	if(extensionAttribute.equals(Optional.of(extension))){
            		final ArtefactAdapter o = (ArtefactAdapter)e.createExecutableExtension("class");
            		o.setResourceSet(resourceSet);            		
                    return Optional.of((ArtefactAdapter)o);
            	}          
            }
        } catch (CoreException ex) {
            //LogUtils.error(logger, ex);
        }
        
        return Optional.empty();
    }
	
	
}
