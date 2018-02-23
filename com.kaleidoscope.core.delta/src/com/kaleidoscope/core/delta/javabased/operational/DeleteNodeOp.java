package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import Delta.DeleteNodeOP;
import Delta.DeltaFactory;

public class DeleteNodeOp extends Operation{
	private EObject node;
	
	public DeleteNodeOp(EObject node){
		this.node = node;
	}
	public DeleteNodeOp(Delta.DeleteNodeOP deleteNodeOP){
		this.node = deleteNodeOP.getNode();
	}
	
	
	public EObject getNode(){
		return node;
	}
	public void setNode(EObject node){
		this.node = node;
	}
	
	public Delta.Operation toOperationalEMF()
   {	      
	  DeleteNodeOP deleteNodeOp = DeltaFactory.eINSTANCE.createDeleteNodeOP();      
	  deleteNodeOp.setNode(node);
      
      return deleteNodeOp;
   }
	@Override
	public void rollbackOperation() {
		
	}

	@Override
	public void executeOperation() {
	
		EcoreUtil.delete(node);
		
	}
}