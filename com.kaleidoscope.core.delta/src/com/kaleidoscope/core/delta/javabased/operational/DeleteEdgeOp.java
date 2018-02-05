package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;

import Delta.DeleteEdgeOP;
import Delta.DeltaFactory;

public class DeleteEdgeOp extends Operation{
	private JavaBasedEdge edge;
	
	public DeleteEdgeOp(JavaBasedEdge edge){
		this.edge = edge;
	}
	public DeleteEdgeOp(Delta.DeleteEdgeOP deleteEdgeOp){
		   this.edge = new JavaBasedEdge(deleteEdgeOp.getEdge());	   
	}
	
	
	
	public JavaBasedEdge getEdge(){
		return edge;
	}
	
	public Delta.Operation toOperationalEMF()
   {	      
	  DeleteEdgeOP deleteEdgeOp = DeltaFactory.eINSTANCE.createDeleteEdgeOP();      
	  deleteEdgeOp.setEdge(edge.toEMF());
      
      return deleteEdgeOp;
   }
	
	@SuppressWarnings("unchecked")
	public void rollbackOperation() {
		
		
		  EStructuralFeature feature = edge.getType();
			if(!feature.isDerived()){
				if (feature.isMany()) {
					((EList<EObject>) edge.getSrc().eGet(feature)).add(edge.getTrg());
				} else
					edge.getSrc().eSet(feature, edge.getTrg());
			}
	}
	@SuppressWarnings("rawtypes")
	@Override
	public void executeOperation() {		
		EStructuralFeature feature = edge.getType();
		if(!feature.isDerived()){
			if (feature.isMany()) {
				((EList) edge.getSrc().eGet(feature)).remove(edge.getTrg());
			} else
				edge.getSrc().eUnset(feature);
		}
		
	}
}
