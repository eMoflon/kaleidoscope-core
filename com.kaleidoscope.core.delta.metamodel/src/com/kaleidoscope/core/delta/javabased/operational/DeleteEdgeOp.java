package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;

import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class DeleteEdgeOp extends Operation{
	private JavaBasedEdge edge;
	
	public DeleteEdgeOp(JavaBasedEdge edge){
		this.edge = edge;
	}
	public DeleteEdgeOp(KaleidoscopeDelta.DeleteEdgeOP deleteEdgeOp){
		   this.edge = new JavaBasedEdge(deleteEdgeOp.getEdge());	   
	}
	
	
	
	public JavaBasedEdge getEdge(){
		return edge;
	}
	
	public KaleidoscopeDelta.Operation toOperationalEMF()
   {	      
	  DeleteEdgeOP deleteEdgeOp = KaleidoscopeDeltaFactory.eINSTANCE.createDeleteEdgeOP();      
	  deleteEdgeOp.setEdge(edge.toEMF());
      
      return deleteEdgeOp;
   }
	@Override
	public void executeOperation(EObject model) {		
		/*EStructuralFeature feature = edge.getType();
		if(!feature.isDerived()){
			if (feature.isMany()) {
				((EList) edge.getSrc().eGet(feature)).remove(edge.getTrg());
			} else
				edge.getSrc().eUnset(feature);
		}*/
		
	}
}
