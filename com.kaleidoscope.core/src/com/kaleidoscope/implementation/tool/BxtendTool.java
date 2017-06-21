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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.moflon.core.utilities.eMoflonEMFUtil;
import org.moflon.tgg.runtime.AttributeDelta;
import org.moflon.tgg.runtime.DeltaSpecification;
import org.moflon.tgg.runtime.EMoflonEdge;

import com.caleidoscope.extensionpoint.BXtool;

import BxtendCryptoImpl.rules.BxtendCryptoImplTransformation;
import CryptoAPIConfig.Import;
import CryptoAPIConfig.Task;
import CryptoJava.JavaImport;

public class BxtendTool  implements BXtool{
	
	private Resource sourceRes;
	private Resource targetRes;
	private Resource corrRes;
	
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
	public void initialize(Path persistanceDirectory) {
		this.set = new ResourceSetImpl();
		this.sourceRes = set.createResource(URI.createURI(persistanceDirectory.resolve(sourceModelFileName).toString()));
		this.targetRes = set.createResource(URI.createURI(persistanceDirectory.resolve(targetModelFileName).toString()));
		this.corrRes = set.createResource(URI.createURI(persistanceDirectory.resolve(corrModelFileName).toString()));
		this.persistanceDirectory = persistanceDirectory;
		
		loadTriple();
		
	}
	
	private void loadTriple() {
		try {
			sourceRes =  loadModel(persistanceDirectory.resolve(sourceModelFileName).toString());
			targetRes = loadModel(persistanceDirectory.resolve(targetModelFileName).toString());
			corrRes = loadModel(persistanceDirectory.resolve(corrModelFileName).toString());
			
			source = sourceRes.getContents().get(0);
			target = targetRes.getContents().get(0);
			corr = corrRes.getContents().get(0);
			
			EcoreUtil.resolveAll(corrRes.getContents().get(0));
			
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
	         for (EMoflonEdge de : localDeltaSpec.getDeletedEdges())
	            performActionOnFeature(de, (f, o) -> ((EList) de.getSrc().eGet(f)).remove(o), (f, o) -> de.getSrc().eUnset(f));

	         // Node deletion
	         for (EObject delObj : localDeltaSpec.getDeletedNodes())
	            EcoreUtil.delete(delObj);

	         // Attribute deltas
	         for (AttributeDelta ac : localDeltaSpec.getAttributeChanges())
	            ac.getAffectedNode().eSet(ac.getAffectedAttribute(), EcoreUtil.createFromString(ac.getAffectedAttribute().getEAttributeType(), ac.getNewValue()));
	      };
	   }
	 
	public void syncForwardFromDelta(Path absPathToDeltaSpec){
		loadTriple();
		Consumer<EObject> change = executeDeltaSpec(absPathToDeltaSpec.toString());
		//change.accept(sourceRes.getContents().get(0));
		Task task = (Task)sourceRes.getContents().get(0);
		Import imp = (Import)task.getAlgorithms().get(0).getImports().get(0);
		task.getAlgorithms().get(0).getImports().remove(0);
		
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.sourceToTarget();
		source = sourceRes.getContents().get(0);
		target = targetRes.getContents().get(0);
		corr = corrRes.getContents().get(0);
	}
	public void syncBackwardFromDelta(Path absPathToDeltaSpec){
		loadTriple();
		Consumer<EObject> change = executeDeltaSpec(absPathToDeltaSpec.toString());
		change.accept(targetRes.getContents().get(0));
		
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.targetToSource();
		source = sourceRes.getContents().get(0);
		target = targetRes.getContents().get(0);
		corr = corrRes.getContents().get(0);
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
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.sourceToTarget();
		
		source = sourceRes.getContents().get(0);
		target = targetRes.getContents().get(0);
		corr = corrRes.getContents().get(0);
	}
	public void targetToSourceTransformation(){
		BxtendCryptoImplTransformation f2pt =  new BxtendCryptoImplTransformation(sourceRes, targetRes, corrRes);
		f2pt.targetToSource();		
		
		source = sourceRes.getContents().get(0);
		target = targetRes.getContents().get(0);
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
		sourceRes.getContents().add(0, sourceModel);
	}
	public void setTargetModel(EObject targetModel){
		target = targetModel;
		targetRes.getContents().add(0, targetModel);
	}
	public void setWorkingDirectory(Path persistanceDirectory){
		this.persistanceDirectory = persistanceDirectory;
	}
	public Path getWorkingDirectory(){
		return persistanceDirectory;
	}
}
