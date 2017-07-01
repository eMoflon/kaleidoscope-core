package com.kaleidoscope.implementation.controller;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.runtime.DeltaSpecification;

import com.kaleidoscope.extensionpoint.ArtefactAdapter;
import com.kaleidoscope.extensionpoint.BXtool;
import com.kaleidoscope.extensionpoint.DeltaDiscoverer;

public  interface ControllerImpl {

	/**
	 *  Transforms source model into the target model and unparses the newly generated target model.
	 */
	public default void sourceToTargetTransformation(Object sourceModelParseSource, Object targetModelUnparseSource,Path toolWorkingDirPath, Optional<Consumer<EObject>> targetModelPostProcessing){
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
		tool.setWorkingDirectory(toolWorkingDirPath);
		
		EObject sourceModel = sourceArtefactAdapter.parse(sourceModelParseSource);
		
		tool.setSourceModel(sourceModel);
		tool.sourceToTargetTransformation();
		
		EObject targetModel = tool.getTargetModel();
		targetModelPostProcessing.ifPresent(t -> t.accept(targetModel));		
		targetArtefactAdapter.unparse(targetModelUnparseSource, targetModel);
		tool.persistModels();
	}
	/**
	 *  Transforms target model into the source model and unparses the newly generated source model.
	 */
	public default void targetToSourceTransformation(Object sourceModelUnparseSource,Path toolWorkingDirPath, Object targetModelParseSource){
		
		ComponentFactory factory = ComponentFactory.getInstance();
		ArtefactAdapter sourceArtefactAdapter = factory.getSourceArtefactAdapter().get();
		ArtefactAdapter targetArtefactAdapter = factory.getTargetArtefactAdapter().get();
		BXtool tool = factory.getTool().get();
		tool.setWorkingDirectory(toolWorkingDirPath);
	
		EObject targetModel = targetArtefactAdapter.parse(targetModelParseSource);
		tool.setTargetModel(targetModel);
		tool.targetToSourceTransformation();
		
		EObject sourceModel = tool.getSourceModel();
		sourceArtefactAdapter.unparse(sourceModelUnparseSource, sourceModel);
		tool.persistModels();
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
		tool.setWorkingDirectory(toolWorkingDirPath);
		DeltaDiscoverer deltaDiscover = ComponentFactory.deltaDiscoveryFactory().get();
		
		EObject newSourceModel = sourceArtefactAdapter.parse(sourceModelParseSource);
		EObject oldSourceModel = tool.getSourceModel();
		
		
		
		DeltaSpecification deltaSpec = deltaDiscover.generateDeltaSpecFromModels(newSourceModel, oldSourceModel);
		deltaArtefactAdapter.unparse(deltaSource, deltaSpec);
		
		tool.syncForwardFromDelta((Path)deltaSource);	
		targetArtefactAdapter.unparse(targetModelUnparseSource, tool.getTargetModel());
		tool.persistModels();
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
		tool.setWorkingDirectory(toolWorkingDirPath);
		DeltaDiscoverer deltaDiscover = ComponentFactory.deltaDiscoveryFactory().get();
		
		EObject newTargetModel = targetArtefactAdapter.parse(targetModelParseSource);
		EObject oldTargetModel = tool.getTargetModel();
		
		
		
		DeltaSpecification deltaSpec = deltaDiscover.generateDeltaSpecFromModels(newTargetModel, oldTargetModel);
		deltaArtefactAdapter.unparse(deltaSource, deltaSpec);
		
		tool.syncBackwardFromDelta((Path)deltaSource);
		sourceArtefactAdapter.unparse(sourceModelUnparseSource, tool.getSourceModel());
	}
}
