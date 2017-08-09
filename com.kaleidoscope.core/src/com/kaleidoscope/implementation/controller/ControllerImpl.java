package com.kaleidoscope.implementation.controller;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.extensionpoint.ArtefactAdapter;
import com.kaleidoscope.extensionpoint.bxtool.BXtool;
import com.kaleidoscope.extensionpoint.deltadiscoverer.OfflineDeltaDiscoverer;
import com.kaleidoscope.ui.delta.javabased.operational.OperationalJavaBasedDelta;


public  interface ControllerImpl {

	
	/**
	 *  Transforms source model into the target model and unparses the newly generated target model.
	 */
	public default void sourceToTargetTransformation(Object sourceModelParseSource, Object targetModelUnparseSource,Path toolWorkingDirPath, Optional<Consumer<EObject>> targetModelPostProcessing)throws NullPointerException{
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
		
		EObject sourceModel = (EObject)sourceArtefactAdapter.parse(sourceModelParseSource);
		
		tool.setSourceModel(sourceModel);
		tool.sourceToTargetTransformation();
		
		EObject targetModel = (EObject)tool.getTargetModel();
		targetModelPostProcessing.ifPresent(t -> t.accept(targetModel));		
		targetArtefactAdapter.unparse(targetModelUnparseSource, targetModel);
		tool.persistState(toolWorkingDirPath);
	}
	/**
	 *  Transforms target model into the source model and unparses the newly generated source model.
	 */
	public default void targetToSourceTransformation(Object sourceModelUnparseSource,Path toolWorkingDirPath, Object targetModelParseSource){
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
	
		EObject targetModel = (EObject)targetArtefactAdapter.parse(targetModelParseSource);
		tool.setTargetModel(targetModel);
		tool.targetToSourceTransformation();
		
		EObject sourceModel = (EObject)tool.getSourceModel();
		sourceArtefactAdapter.unparse(sourceModelUnparseSource, sourceModel);
		tool.persistState(toolWorkingDirPath);
	}
	/** 
	 * Synchronizes target model with source model. It first generates delta specification between the old 
	 * source model and the new model and then uses that delta to perform synchronization. After synchronization
	 *  target model is unparsed.
	 */
	public default void syncForwardFromDelta(Object sourceModelParseSource, Object targetModelUnparseSource,Path toolWorkingDirPath, Object deltaSource){
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		ArtefactAdapter deltaArtefactAdapter = factory.getDeltaArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
		
		tool.restoreState(toolWorkingDirPath);
		OfflineDeltaDiscoverer deltaDiscover = (OfflineDeltaDiscoverer)ComponentFactory.deltaDiscoveryFactory().get();
		
		EObject newSourceModel = (EObject)sourceArtefactAdapter.parse(sourceModelParseSource);
		EObject oldSourceModel = (EObject)tool.getSourceModel();
		
		
		
		OperationalJavaBasedDelta operationalDelta = (OperationalJavaBasedDelta)deltaDiscover.generateDeltaSpecFromModels(newSourceModel, oldSourceModel);
		deltaArtefactAdapter.unparse(deltaSource, operationalDelta.transformIntoOperationalDelta());
		
		tool.syncForwardFromJavaBasedDelta(operationalDelta, Optional.empty());	
		targetArtefactAdapter.unparse(targetModelUnparseSource, tool.getTargetModel());
		tool.persistState(toolWorkingDirPath);
	}
	/** 
	 * Synchronizes source model with target model. It first generates delta specification between the old 
	 * java model and the new model and then uses the delta to perform synchronization. After synchronization
	 *  source model is unparsed.
	 */
	public default void syncBackwardFromDelta(Object sourceModelUnparseSource, Object targetModelParseSource, Path toolWorkingDirPath, Object deltaSource){
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		ArtefactAdapter deltaArtefactAdapter = factory.getDeltaArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
		tool.restoreState(toolWorkingDirPath);
		OfflineDeltaDiscoverer deltaDiscover = (OfflineDeltaDiscoverer)ComponentFactory.deltaDiscoveryFactory().get();
		
		EObject newTargetModel = (EObject)targetArtefactAdapter.parse(targetModelParseSource);
		EObject oldTargetModel = (EObject)tool.getTargetModel();
		
		
		
		OperationalJavaBasedDelta operationalDelta = (OperationalJavaBasedDelta)deltaDiscover.generateDeltaSpecFromModels(newTargetModel, oldTargetModel);
		deltaArtefactAdapter.unparse(deltaSource, operationalDelta.transformIntoOperationalDelta());
		
		tool.syncBackwardFromJavaBasedDelta(operationalDelta, Optional.empty());
		sourceArtefactAdapter.unparse(sourceModelUnparseSource, tool.getSourceModel());
		
		tool.persistState(toolWorkingDirPath);
	}
}
