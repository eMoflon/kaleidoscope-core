package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

import Delta.AttributeChangeOP;
import Delta.DeltaFactory;

public class AttributeChangeOp extends Operation{
	private Object newValue;
	private Object oldValue;
	   private EAttribute affectedAttribute;
	   private EObject affectedNode;
	   
	   
	   public AttributeChangeOp(EAttribute affectedAttribute, Object newValue, EObject affectedNode, Object oldValue){
		   this.newValue = newValue;
		   this.affectedAttribute = affectedAttribute;
		   this.affectedNode = affectedNode;
		   this.oldValue = oldValue;
	   }
	   
	   public AttributeChangeOp(EAttribute affectedAttribute, Object newValue, EObject affectedNode){  
	      this.newValue = newValue;
	      this.affectedAttribute = affectedAttribute;
	      this.affectedNode = affectedNode;
	   }
	   
	   public AttributeChangeOp(AttributeChangeOP attributeChangeOP){
		   this.newValue = attributeChangeOP.getNewValue();
		   this.affectedAttribute = attributeChangeOP.getAttr();
		   this.affectedNode = attributeChangeOP.getNode();
	   }

	   public Object getNewValue()
	   {
	      return newValue;
	   }
	   public void setAffecteNode(EObject node){
		   affectedNode  = node;
	   }
	   public EAttribute getAffectedAttribute(){
	      return affectedAttribute;
	   }
	   
	   public EObject getAffectedNode(){
		   return affectedNode;
	   }

	   public Delta.Operation toOperationalEMF()
	   {	      
	      AttributeChangeOP attributeChangeOp = DeltaFactory.eINSTANCE.createAttributeChangeOP();
	      attributeChangeOp.setAttr(affectedAttribute);
	      attributeChangeOp.setNewValue(newValue);
	      attributeChangeOp.setNode(affectedNode);
	      
	      return attributeChangeOp;
	   }

	   @Override
		public void rollbackOperation() {
			affectedNode.eSet(affectedAttribute, oldValue);
			
		}
	@Override
	public void executeOperation() {
		affectedNode.eSet(affectedAttribute, newValue);
	}
}
