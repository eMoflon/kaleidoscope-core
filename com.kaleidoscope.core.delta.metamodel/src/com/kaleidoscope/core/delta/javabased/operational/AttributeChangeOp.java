package com.kaleidoscope.core.delta.javabased.operational;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.operational.Operation;

import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class AttributeChangeOp extends Operation{
	private Object newValue;
	   private EAttribute affectedAttribute;
	   private EObject affectedNode;
	   
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

	   public KaleidoscopeDelta.Operation toOperationalEMF()
	   {	      
	      AttributeChangeOP attributeChangeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAttributeChangeOP();
	      attributeChangeOp.setAttr(affectedAttribute);
	      attributeChangeOp.setNewValue(newValue);
	      attributeChangeOp.setNode(affectedNode);
	      
	      return attributeChangeOp;
	   }


	@Override
	public void executeOperation(EObject model) {
		affectedNode.eSet(affectedAttribute, newValue);
		
	}
}
