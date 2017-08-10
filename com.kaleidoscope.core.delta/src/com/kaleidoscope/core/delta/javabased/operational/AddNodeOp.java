package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;


public class AddNodeOp extends Operation{
	private EObject node;
	
	public AddNodeOp(EObject node){
		this.node = node;
	}
	
	public AddNodeOp(KaleidoscopeDelta.AddNodeOP addNodeOP){
		this.node = addNodeOP.getNode();
	}
	
	public EObject getNode(){
		return node;
	}
	
	public KaleidoscopeDelta.Operation toOperationalEMF()
   {	      
	  AddNodeOP addNodeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAddNodeOP(); 
	  addNodeOp.setNode(node);
      return addNodeOp;
   }
	@Override
	public void executeOperation() {
		
	}
}