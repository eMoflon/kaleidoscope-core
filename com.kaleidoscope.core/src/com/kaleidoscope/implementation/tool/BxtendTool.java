package com.kaleidoscope.implementation.tool;

import java.nio.file.Path;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.tgg.runtime.AttributeDelta;
import org.moflon.tgg.runtime.DeltaSpecification;
import org.moflon.tgg.runtime.EMoflonEdge;

import com.kaleidoscope.extensionpoint.BXtool;

import BxtendCryptoImpl.Transformation;
import BxtendCryptoImpl.rules.BxtendCryptoImplTransformation;
import CryptoAPIConfig.Import;
import CryptoAPIConfig.Task;

public class BxtendTool  implements BXtool{
	
	private EObject source;
	private EObject target;
	private EObject corr;
	
	private Path persistanceDirectory = null;
	private String sourceModelFileName = "fwd.src.xmi";
	private String targetModelFileName = "fwd.trg.xmi";
	private String corrModelFileName = "fwd.corr.xmi";
	ResourceSet set = null;
	
	public BxtendTool(){
	
	}
	public void initialize(ResourceSet set, Path persistanceDirectory) {
		this.set = set;
		this.persistanceDirectory = persistanceDirectory;
		
		loadTriple();
		
	}
	
	private void loadTriple() {
		try {
			source =  loadModel(persistanceDirectory.resolve(sourceModelFileName).toString()).getContents().get(0);
			target = loadModel(persistanceDirectory.resolve(targetModelFileName).toString()).getContents().get(0);;
			corr = loadModel(persistanceDirectory.resolve(corrModelFileName).toString()).getContents().get(0);;
			EcoreUtil.resolveAll(corr);
			//source = ((Transformation) corr).getSourceModel();
			//target = ((Transformation) corr).getTargetModel();
			
		} catch (IllegalArgumentException iae) {
			System.err.println("Unable to load input triple");
		}
	}
	private Resource loadModel(final String path){
		
      Resource r = set.getResource(eMoflonEMFUtil.createFileURI(path, true), true);
      return r;
  
   }
	private void performActionOnFeature(EMoflonEdge e, BiConsumer<EStructuralFeature, EObject> actionMany, BiConsumer<EStructuralFeature, EObject> actionOne) {
		EStructuralFeature feature = e.getSrc().eClass().getEStructuralFeature(e.getName());
		if(!feature.isDerived()){
			if (feature.isMany()) {
				actionMany.accept(feature, e.getTrg());
			} else
				actionOne.accept(feature, e.getTrg());
		}

	}
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	   protected Consumer<EObject> executeDeltaSpec(String pathToDelta)
	   {
	      DeltaSpecification localDeltaSpec = (DeltaSpecification) loadModel(pathToDelta).getContents().get(0);
	      EcoreUtil.resolveAll(localDeltaSpec);
	      DeltaSpecification deltaSpec = EcoreUtil.copy(localDeltaSpec);
	      
	      return (input) -> {    	  
	    	  // Added edges (nodes are indirectly added)
	    	  for (EMoflonEdge ae : localDeltaSpec.getAddedEdges())
	    		  performActionOnFeature(ae, (f, o) -> ((EList) ae.getSrc().eGet(f)).add(o), ae.getSrc()::eSet);
	    	  
	         // Edge deletion
	         //for (EMoflonEdge de : localDeltaSpec.getDeletedEdges())
	          //  performActionOnFeature(de, (f, o) -> ((EList) de.getSrc().eGet(f)).remove(o), (f, o) -> de.getSrc().eUnset(f));

	         // Node deletion
	    	 while(localDeltaSpec.getDeletedNodes().size() != 0){
	    		 EcoreUtil.delete(localDeltaSpec.getDeletedNodes().get(0));
	    	 }	           
	         // Attribute deltas
	         for (AttributeDelta ac : localDeltaSpec.getAttributeChanges())
	            ac.getAffectedNode().eSet(ac.getAffectedAttribute(), EcoreUtil.createFromString(ac.getAffectedAttribute().getEAttributeType(), ac.getNewValue()));
	      };
	   }
	 
	public void syncForwardFromDelta(Path absPathToDeltaSpec){
		loadTriple();
		Consumer<EObject> change = executeDeltaSpec(absPathToDeltaSpec.toString());
		change.accept(source);
		
		//set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("family", new XMIResourceFactoryImpl());
		//set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("person", new XMIResourceFactoryImpl());
		//set.getResourceFactoryRegistry().getExtensionToFactoryMap().put("corr", new XMIResourceFactoryImpl());		
		
		Resource sourceRes = set.createResource(URI.createURI("sourceModel.task"));
		Resource  targetRes = set.createResource(URI.createURI("targetModel.package"));
		Resource corrRes = set.createResource(URI.createURI("corrModel.corr"));
		
		sourceRes.getContents().add(source);
		targetRes.getContents().add(target);
		corrRes.getContents().add(corr);
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.sourceToTarget();		
	}
	public void syncBackwardFromDelta(Path absPathToDeltaSpec){
		loadTriple();
		Consumer<EObject> change = executeDeltaSpec(absPathToDeltaSpec.toString());
		change.accept(target);
		
		Resource sourceRes = set.createResource(URI.createURI("sourceModel.task"));
		Resource  targetRes = set.createResource(URI.createURI("targetModel.package"));
		Resource corrRes = set.createResource(URI.createURI("corrModel.corr"));
		
		sourceRes.getContents().add(source);
		targetRes.getContents().add(target);
		corrRes.getContents().add(corr);
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.targetToSource();
	}	
	public void persistModels() {  
		corr.eResource().setURI(eMoflonEMFUtil.createFileURI(persistanceDirectory.resolve(corrModelFileName).toString(), false));
		source.eResource().setURI(eMoflonEMFUtil.createFileURI(persistanceDirectory.resolve(sourceModelFileName).toString(), false));
		target.eResource().setURI(eMoflonEMFUtil.createFileURI(persistanceDirectory.resolve(targetModelFileName).toString(), false));
	      
	    eMoflonEMFUtil.saveModel(set, corr, persistanceDirectory.resolve(corrModelFileName).toString());	    
	    eMoflonEMFUtil.saveModel(set, source, persistanceDirectory.resolve(sourceModelFileName).toString());
	    eMoflonEMFUtil.saveModel(set, target, persistanceDirectory.resolve(targetModelFileName).toString());	
	}	
	public void sourceToTargetTransformation(){
		
		Resource sourceRes = set.createResource(URI.createURI("sourceModel.task"));
		Resource  targetRes = set.createResource(URI.createURI("targetModel.package"));
		Resource corrRes = set.createResource(URI.createURI("corrModel.corr"));
		sourceRes.getContents().add(source);
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.sourceToTarget();
		
		target = targetRes.getContents().get(0);
		corr = corrRes.getContents().get(0);
		
		/*Transformation trans = (Transformation)corr;
		trans.setSourceModel(source);
		trans.setTargetModel(target);
		*/
	}
	public void targetToSourceTransformation(){
		
		Resource sourceRes = set.createResource(URI.createURI("sourceModel.task"));
		Resource  targetRes = set.createResource(URI.createURI("targetModel.package"));
		Resource corrRes = set.createResource(URI.createURI("corrModel.corr"));
	
		sourceRes.getContents().add(target);
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.targetToSource();		
		
		source = sourceRes.getContents().get(0);
		corr = corrRes.getContents().get(0);
	}
	public EObject getSourceModel(){
		return source;
	}
	public EObject getTargetModel(){
		return target;
	}
	
	public void setSourceModel(EObject sourceModel){
		source = sourceModel;
	}
	public void setTargetModel(EObject targetModel){
		target = targetModel;
	}
	public void setWorkingDirectory(Path persistanceDirectory){
		this.persistanceDirectory = persistanceDirectory;
	}
	public Path getWorkingDirectory(){
		return persistanceDirectory;
	}
}
