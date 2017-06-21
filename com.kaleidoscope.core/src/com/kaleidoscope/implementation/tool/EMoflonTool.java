package com.kaleidoscope.implementation.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.moflon.tgg.algorithm.synchronization.SynchronizationHelper;
import org.moflon.tgg.runtime.CorrespondenceModel;

import com.caleidoscope.extensionpoint.BXtool;

import CryptoConfigToJava.CryptoConfigToJavaPackage;



public class EMoflonTool implements BXtool{

	
	private Path persistanceDirectory = null;
	private String sourceModelFileName = "fwd.src.xmi";
	private String targetModelFileName = "fwd.trg.xmi";
	private String corrModelFileName = "fwd.corr.xmi";
	private String syncProtocolFileName = "fwd.protocol.xmi";
	
	private ResourceSet set;
	private SynchronizationHelper helper;
	
	public EMoflonTool() {
		
		
	}
	public void initialize(ResourceSet set, String pathToTGGtransformationProjet, EPackage corrPack, Path persistanceDir){
		
		this.persistanceDirectory = persistanceDir;
		this.set = set;
		helper = new SynchronizationHelper(CryptoConfigToJavaPackage.eINSTANCE, pathToTGGtransformationProjet, set);		
		loadTriple(persistanceDirectory.resolve(corrModelFileName));		
	}
	
	public void syncForwardFromDelta(Path absPathToDeltaSpec){
		loadTriple(persistanceDirectory.resolve(corrModelFileName));
		helper.loadSynchronizationProtocol(persistanceDirectory.resolve(syncProtocolFileName).toString());
		
		try {
			Method m = helper.getClass().getDeclaredMethod("executeDeltaSpec", null);
			m.setAccessible(true);
			helper.setChangeSrc((Consumer<EObject>) m.invoke(absPathToDeltaSpec.toString(), null));
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		helper.integrateForward();	
	}
	public void syncBackwardFromDelta(Path absPathToDeltaSpec){
		loadTriple(persistanceDirectory.resolve(corrModelFileName));
		helper.loadSynchronizationProtocol(persistanceDirectory.resolve(syncProtocolFileName).toString());
		
		try {
			Method m = helper.getClass().getDeclaredMethod("executeDeltaSpec", null);
			m.setAccessible(true);
			helper.setChangeTrg((Consumer<EObject>) m.invoke(absPathToDeltaSpec.toString(), null));
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		helper.integrateBackward();	
	}
	private void loadTriple(Path corrPath) {
		try {
			helper.loadCorr(corrPath.toString());
			CorrespondenceModel corrModel = (CorrespondenceModel) helper.getCorr();						
			helper.setTrg(corrModel.getTarget());
			helper.setSrc(corrModel.getSource());
			
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load input triple for " + corrPath + ", " + iae.getMessage());
		}
	}
	public void persistModels() {
		helper.getSrc().eResource().setURI(URI.createFileURI(persistanceDirectory.resolve(sourceModelFileName).toString()));
		helper.getTrg().eResource().setURI(URI.createFileURI(persistanceDirectory.resolve(targetModelFileName).toString()));
		helper.getCorr().eResource().setURI(URI.createFileURI(persistanceDirectory.resolve(corrModelFileName).toString()));
		
		helper.saveCorr(persistanceDirectory.resolve(corrModelFileName).toString());
		helper.saveSynchronizationProtocol(persistanceDirectory.resolve(syncProtocolFileName).toString());
		helper.saveSrc(persistanceDirectory.resolve(sourceModelFileName).toString());		
		helper.saveTrg(persistanceDirectory.resolve(targetModelFileName).toString());
	}
	public void sourceToTargetTransformation(){
		helper.integrateForward();
		
	}
	public void targetToSourceTransformation(){
		helper.integrateBackward();		
	}
	public EObject getSourceModel(){
		return helper.getSrc();
	}
	public EObject getTargetModel(){
		return helper.getTrg();
	}
	public void setSourceModel(EObject sourceModel){
		Resource resource = set.createResource(URI.createURI("sourceModel.configuration"));	
		resource.getContents().add(0,(EObject) sourceModel);
		helper.setSrc(sourceModel);
	}
	public void setTargetModel(EObject targetModel){
		Resource resource = set.createResource(URI.createURI("targetModel.java"));	
		resource.getContents().add(0, (EObject) targetModel);
		helper.setTrg(targetModel);
	}
	public void setWorkingDirectory(Path persistanceDirectory){
		this.persistanceDirectory = persistanceDirectory;
	}
	public Path getWorkingDirectory(){
		return persistanceDirectory;
	}
	
}
