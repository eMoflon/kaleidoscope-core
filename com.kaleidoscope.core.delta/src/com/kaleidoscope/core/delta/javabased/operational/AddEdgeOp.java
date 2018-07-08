package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emoflon.ibex.tgg.operational.edge.RuntimeEdge;

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.Operation;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class AddEdgeOp extends Operation {
	private JavaBasedEdge edge;
	
	public AddEdgeOp(JavaBasedEdge edge){
		this.edge = edge;
	}
	public AddEdgeOp(KaleidoscopeDelta.AddEdgeOP addEdgeOp){
		   this.edge = new JavaBasedEdge(addEdgeOp.getEdge());	   
	}
	
	public JavaBasedEdge getEdge(){
		return edge;
	}
	
   public KaleidoscopeDelta.Operation toOperationalEMF()
   {	      
	  AddEdgeOP addEdgeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAddEdgeOP();      
	  addEdgeOp.setEdge(edge.toEMF());      
      return addEdgeOp;
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
