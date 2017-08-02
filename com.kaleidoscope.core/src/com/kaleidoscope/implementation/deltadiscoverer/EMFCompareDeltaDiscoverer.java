package com.kaleidoscope.implementation.deltadiscoverer;

import java.util.List;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.impl.AttributeChangeImpl;
import org.eclipse.emf.compare.impl.ReferenceChangeImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.kaleidoscope.extensionpoint.deltadiscoverer.OfflineDeltaDiscoverer;
import com.kaleidoscope.ui.delta.javabased.JavaBasedDelta;
import com.kaleidoscope.ui.delta.javabased.operational.OperationalJavaBasedDelta;

import Deltameta.AddEdgeOP;
import Deltameta.AddNodeOP;
import Deltameta.AttributeChangeOP;
import Deltameta.DeleteEdgeOP;
import Deltameta.DeleteNodeOP;
import Deltameta.DeltametaFactory;
import Deltameta.Edge;
import Deltameta.OperationalDelta;

public class EMFCompareDeltaDiscoverer implements OfflineDeltaDiscoverer<EObject> {

ResourceSet resourceSet = null;

	
	public EMFCompareDeltaDiscoverer() {
		
	}
	/**
	 * The method is used to generate DeltaSpecification from two models of the same metamodel.
	 * The for loop inside the method goes through all the differences between the two models and according to the type of difference it updates
	 * delta specification. 
	 * @param oldModel 
	 * @param newModel
	 * @return DeltaSpecification represents delta between the two models
	 */
	
	public JavaBasedDelta generateDeltaSpecFromModels(EObject oldModel, EObject newModel){
		//BasicConfigurator.configure();
		
		Comparison comparison = compareModels(oldModel, newModel);
		List<Diff> differences = comparison.getDifferences();
		
		OperationalDelta operationalDelta = DeltametaFactory.eINSTANCE.createOperationalDelta();
		
		System.out.println("------------------Doing comparison of models--------------------");
		for(Diff diff: differences)
	    {
			if(diff instanceof AttributeChangeImpl){
				if(diff.getKind().equals(DifferenceKind.CHANGE)){
					EAttribute affectedAttribute = ((AttributeChangeImpl) diff).getAttribute(); 
					Object newValue =  ((AttributeChangeImpl) diff).getValue();
						
					Match match = diff.getMatch();										
					//oldValue = match.getRight().eGet(((AttributeChangeImpl) diff).getAttribute());
					
					AttributeChangeOP attributeDelta = DeltametaFactory.eINSTANCE.createAttributeChangeOP();
					attributeDelta.setAttr(affectedAttribute);
					attributeDelta.setNode(match.getRight());	
					attributeDelta.setNewValue(newValue);
									
					operationalDelta.getOperations().add(attributeDelta);										
				}
			}else if(diff instanceof ReferenceChangeImpl){
				
				if(diff.getKind() == DifferenceKind.ADD){
					ReferenceChangeImpl refChgSpec = (ReferenceChangeImpl)diff;
					
					AddNodeOP addNodeOp = DeltametaFactory.eINSTANCE.createAddNodeOP();
					AddEdgeOP addEdgeOp = DeltametaFactory.eINSTANCE.createAddEdgeOP();
					
					Edge edge = DeltametaFactory.eINSTANCE.createEdge();														
				    edge.setType(refChgSpec.getReference());					
				    edge.setSrc(refChgSpec.getMatch().getRight());				    			
					edge.setTrg(refChgSpec.getValue());
					
					addEdgeOp.setEdge(edge);
					addNodeOp.setNode(((ReferenceChangeImpl) diff).getValue());
										
					operationalDelta.getOperations().add(addEdgeOp);
					operationalDelta.getOperations().add(addNodeOp);	
					
				}else if(diff.getKind().equals(DifferenceKind.DELETE)){	
					
					DeleteNodeOP removeNodeOp = DeltametaFactory.eINSTANCE.createDeleteNodeOP();
					DeleteEdgeOP removeEdgeOp = DeltametaFactory.eINSTANCE.createDeleteEdgeOP();
					Edge edgeRemove = DeltametaFactory.eINSTANCE.createEdge();
					
					edgeRemove.setType(((ReferenceChangeImpl) diff).getReference());					
				    edgeRemove.setSrc(((ReferenceChangeImpl) diff).getValue().eContainer());
				    edgeRemove.setTrg(((ReferenceChangeImpl) diff).getValue());
				    
				    removeEdgeOp.setEdge(edgeRemove);
				    removeNodeOp.setNode(((ReferenceChangeImpl) diff).getValue());

				    operationalDelta.getOperations().add(removeEdgeOp);
					operationalDelta.getOperations().add(removeNodeOp);		    					
				}else if(diff.getKind().equals(DifferenceKind.MOVE)){
					// TODO Move operation in EMFCompare
		
				}
			}
			
			System.out.println("d.toString():"  +diff);
			System.out.println("d.getKind(): "+diff.getKind());
			System.out.println("d.getMatch(): " + diff.getMatch());

			System.out.println("=========================================================");
	    }
		System.out.println("------------------Comparison finished--------------------");
		return new OperationalJavaBasedDelta(operationalDelta);
	}	
	/*
	public DeltaSpecification old_generateDeltaSpecFromModels(EObject oldModel, EObject newModel){
		//BasicConfigurator.configure();
		
		Comparison comparison = compareModels(oldModel, newModel);
		List<Diff> differences = comparison.getDifferences();
		
		DeltaSpecification deltaSpec = RuntimeFactory.eINSTANCE.createDeltaSpecification();
		
		System.out.println("------------------Doing comparison of models--------------------");
		for(Diff diff: differences)
	    {
			if(diff instanceof AttributeChangeSpec){
				if(diff.getKind().equals(DifferenceKind.CHANGE)){
					EAttribute affectedAttribute = ((AttributeChangeSpec) diff).getAttribute(); 
					Object newValue =  ((AttributeChangeSpec) diff).getValue();
					Object oldValue = null;	
			
					Match match = diff.getMatch();										
					oldValue = match.getRight().eGet(((AttributeChangeImpl) diff).getAttribute());
					
					AttributeDelta attributeDelta = RuntimeFactory.eINSTANCE.createAttributeDelta();
					attributeDelta.setAffectedAttribute(affectedAttribute);
					attributeDelta.setAffectedNode(match.getRight());
					attributeDelta.setOldValue(EcoreUtil.convertToString(affectedAttribute.getEAttributeType(), oldValue));
					attributeDelta.setNewValue(EcoreUtil.convertToString(affectedAttribute.getEAttributeType(), newValue));
									
					deltaSpec.getAttributeChanges().add(attributeDelta);										
				}
			}else if(diff instanceof ReferenceChangeSpec){
				if(diff.getKind() == DifferenceKind.ADD){
					ReferenceChangeSpec refChgSpec = (ReferenceChangeSpec)diff;
					EMoflonEdge edge = org.moflon.tgg.runtime.RuntimeFactory.eINSTANCE.createEMoflonEdge();														
				    edge.setName(refChgSpec.getReference().getName());					
				    edge.setSrc(refChgSpec.getMatch().getRight());				    			
					edge.setTrg(refChgSpec.getValue());
										
					deltaSpec.getAddedEdges().add(edge);
				    deltaSpec.getAddedNodes().add(((ReferenceChangeImpl) diff).getValue());				    				    					
				}else if(diff.getKind().equals(DifferenceKind.DELETE)){					
					EMoflonEdge edgeRemove = org.moflon.tgg.runtime.RuntimeFactory.eINSTANCE.createEMoflonEdge();
					edgeRemove.setName(((ReferenceChangeImpl) diff).getReference().getName());					
				    edgeRemove.setSrc(((ReferenceChangeImpl) diff).getValue().eContainer());
				    edgeRemove.setTrg(((ReferenceChangeImpl) diff).getValue());

				    deltaSpec.getDeletedEdges().add(edgeRemove);
				    deltaSpec.getDeletedNodes().add(((ReferenceChangeImpl) diff).getValue());				    					
				}else if(diff.getKind().equals(DifferenceKind.MOVE)){
					// TODO Move operation in EMFCompare
		
				}
			}
			
			System.out.println("d.toString():"  +diff);
			System.out.println("d.getKind(): "+diff.getKind());
			System.out.println("d.getMatch(): " + diff.getMatch());

			System.out.println("=========================================================");
	    }
		System.out.println("------------------Comparison finished--------------------");
		return deltaSpec;
	}	*/
	private Comparison compareModels(EObject model1, EObject model2) {
		
		IComparisonScope scope = new DefaultComparisonScope(model1, model2,null);	

		IDiffEngine diffEngine = new DefaultDiffEngine();
		EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine).build();
		Comparison comparison = comparator.compare(scope);
		
		return comparison;
				
	}
	

}
