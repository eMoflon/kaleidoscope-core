package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

import Delta.AddNodeOP;
import Delta.DeltaFactory;


public class AddNodeOp extends Operation{
	private EObject node;
	
	public AddNodeOp(EObject node){
		this.node = node;
	}
	
	public AddNodeOp(Delta.AddNodeOP addNodeOP){
		this.node = addNodeOP.getNode();
	}
	
	public EObject getNode(){
		return node;
	}
	
	public Delta.Operation toOperationalEMF()
   {	      
	  AddNodeOP addNodeOp = DeltaFactory.eINSTANCE.createAddNodeOP(); 
	  addNodeOp.setNode(node);
      return addNodeOp;
   }
	@Override
	public void executeOperation() {
		
	}
	@Override
	public void rollbackOperation() {
		EcoreUtil.delete(node);
	}
}