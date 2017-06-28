package com.kaleidoscope.implementation.controller;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EObject;
import org.moflon.tgg.runtime.DeltaSpecification;

import com.caleidoscope.extensionpoint.ArtefactAdapter;
import com.caleidoscope.extensionpoint.BXtool;
import com.caleidoscope.extensionpoint.DeltaDiscoverer;
import com.caleidoscope.extensionpoint.Controller;

public class ControllerImpl implements Controller {

	private BXtool tool;
	private ArtefactAdapter targetArtefactAdapter;
	private ArtefactAdapter sourceArtefactAdapter;
	private ArtefactAdapter deltaArtefactAdapter;
	private DeltaDiscoverer deltaDiscover;
	
	
	private Path absDeltaPath;
	
	public Path getDeltaPath() {
		return absDeltaPath;
	}
	public void setDeltaPath(Path deltaPath) {
		this.absDeltaPath = deltaPath;
	}
	public ControllerImpl(){	
		
	}
	
	public void initialize(BXtool tool, DeltaDiscoverer deltaDiscover, ArtefactAdapter deltaArtefactAdapter){	
		this.tool = tool;
		this.deltaDiscover = deltaDiscover;
		this.deltaArtefactAdapter = deltaArtefactAdapter;
	}
	
	/**
	 *  Transforms source model into the target model and unparses the newly generated target model.
	 */
	public void sourceToTargetTransformation(Optional<Consumer<EObject>> targetModelPostProcessing){
		
		EObject sourceModel = sourceArtefactAdapter.parse();
		tool.setSourceModel(sourceModel);
		tool.sourceToTargetTransformation();
		
		EObject targetModel = tool.getTargetModel();
		targetModelPostProcessing.ifPresent(t -> t.accept(targetModel));		
		targetArtefactAdapter.unparse(targetModel);
	}
	/**
	 *  Transforms target model into the source model and unparses the newly generated source model.
	 */
	public void targetToSourceTransformation(){
		EObject targetModel = targetArtefactAdapter.parse();
		tool.setTargetModel(targetModel);
		tool.targetToSourceTransformation();
		
		EObject sourceModel = tool.getSourceModel();
		sourceArtefactAdapter.unparse(sourceModel);
	}
	/** 
	 * Synchronizes target model with source model. It first generates delta specification between the old 
	 * source model and the new model and then uses that delta to perform synchronization. After synchronization
	 *  target model is unparsed.
	 */
	public void syncForwardFromDelta(){
		EObject newSourceModel = sourceArtefactAdapter.parse();
		EObject oldSourceModel = tool.getSourceModel();
		
		DeltaSpecification deltaSpec = deltaDiscover.generateDeltaSpecFromModels(newSourceModel, oldSourceModel);
		deltaArtefactAdapter.setUnParseSource(absDeltaPath);
		deltaArtefactAdapter.unparse(deltaSpec);
		
		tool.syncForwardFromDelta(absDeltaPath);	
		targetArtefactAdapter.unparse(tool.getTargetModel());
	}
	/** 
	 * Synchronizes source model with target model. It first generates delta specification between the old 
	 * java model and the new model and then uses the delta to perform synchronization. After synchronization
	 *  source model is unparsed.
	 */
	public void syncBackwardFromDelta(){	
		EObject newTargetModel = targetArtefactAdapter.parse();
		EObject oldTargetModel = tool.getTargetModel();
		
		DeltaSpecification deltaSpec = deltaDiscover.generateDeltaSpecFromModels(newTargetModel, oldTargetModel);
		deltaArtefactAdapter.setUnParseSource(absDeltaPath);
		deltaArtefactAdapter.unparse(deltaSpec);
		
		tool.syncBackwardFromDelta(absDeltaPath);
		sourceArtefactAdapter.unparse(tool.getSourceModel());
	}
	
	
	@Override
	public void setSourceArtefactAdapter(ArtefactAdapter sourceArtefactAdapter) {
		this.sourceArtefactAdapter = sourceArtefactAdapter;
		
	}
	@Override
	public void setTargetArtefactAdapter(ArtefactAdapter targetArtefactAdapter) {
		this.targetArtefactAdapter = targetArtefactAdapter;
		
	}
	@Override
	public void persistModels() {
		tool.persistModels();
		
	}

}
