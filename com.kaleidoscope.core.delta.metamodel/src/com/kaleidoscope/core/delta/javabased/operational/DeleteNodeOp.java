package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class DeleteNodeOp extends Operation{
	private EObject node;
	
	public DeleteNodeOp(EObject node){
		this.node = node;
	}
	public DeleteNodeOp(KaleidoscopeDelta.DeleteNodeOP deleteNodeOP){
		this.node = deleteNodeOP.getNode();
	}
	
	
	public EObject getNode(){
		return node;
	}
	public void setNode(EObject node){
		this.node = node;
	}
	
	public KaleidoscopeDelta.Operation toOperationalEMF()
   {	      
	  DeleteNodeOP deleteNodeOp = KaleidoscopeDeltaFactory.eINSTANCE.createDeleteNodeOP();      
	  deleteNodeOp.setNode(node);
      
      return deleteNodeOp;
   }
	@Override
	public void executeOperation(EObject model) {
		EcoreUtil.delete(node);
		
	}
}