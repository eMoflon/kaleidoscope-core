package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.Operation;

import Delta.AddEdgeOP;
import Delta.DeltaFactory;

public class AddEdgeOp extends Operation {
	private JavaBasedEdge edge;
	
	public AddEdgeOp(JavaBasedEdge edge){
		this.edge = edge;
	}
	public AddEdgeOp(Delta.AddEdgeOP addEdgeOp){
		   this.edge = new JavaBasedEdge(addEdgeOp.getEdge());	   
	}
	
	public JavaBasedEdge getEdge(){
		return edge;
	}
	
   public Delta.Operation toOperationalEMF()
   {	      
	  AddEdgeOP addEdgeOp = DeltaFactory.eINSTANCE.createAddEdgeOP();      
	  addEdgeOp.setEdge(edge.toEMF());      
      return addEdgeOp;
   }
   
	@SuppressWarnings("rawtypes")
	public void rollbackOperation() {
		EStructuralFeature feature = edge.getType();
		if(!feature.isDerived()){
			if (feature.isMany()) {
				((EList) edge.getSrc().eGet(feature)).remove(edge.getTrg());
			} else
				edge.getSrc().eUnset(feature);
		}
	}
   @Override
   @SuppressWarnings("unchecked")
   public void executeOperation(){
	   EStructuralFeature feature = edge.getType();
		if(!feature.isDerived()){
			if (feature.isMany()) {
				((EList<EObject>) edge.getSrc().eGet(feature)).add(edge.getTrg());
			} else
				edge.getSrc().eSet(feature, edge.getTrg());
		}
   }
}
