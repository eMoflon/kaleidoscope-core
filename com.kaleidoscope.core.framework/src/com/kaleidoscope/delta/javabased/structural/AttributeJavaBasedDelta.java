package com.kaleidoscope.delta.javabased.structural;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.delta.javabased.structural.AttributeJavaBasedDelta;

import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;

public class AttributeJavaBasedDelta {
	   private Object newValue;
	   private Object oldValue;
	   private EAttribute affectedAttribute;
	   private EObject affectedNode;
	   
	   public AttributeJavaBasedDelta(EAttribute affectedAttribute, Object newValue, EObject affectedNode){
	      
	      this.newValue = newValue;
	      this.affectedAttribute = affectedAttribute;
	      this.affectedNode = affectedNode;
	   }
	   	   

	   public Object getNewValue()
	   {
	      return newValue;
	   }
	   
	   public EAttribute getAffectedAttribute(){
	      return affectedAttribute;
	   }
	   
	   public EObject getAffectedNode(){
		   return affectedNode;
	   }

	   public AttributeChangeOP toOperationalEMF()
	   {	      
	      AttributeChangeOP attributeChangeOp = KaleidoscopeDeltaFactory.eINSTANCE.createAttributeChangeOP();
	      attributeChangeOp.setAttr(affectedAttribute);
	      attributeChangeOp.setNewValue(newValue);
	      attributeChangeOp.setNode(affectedNode);
	      
	      return attributeChangeOp;
	   }
	   
	  /* private String getStringValue(Object value)
	   {
	      return EcoreUtil.convertToString(affectedAttribute.getEAttributeType(), value);
	   }*/

	   public static AttributeJavaBasedDelta fromOperationalEMF(AttributeChangeOP attDeltaEMF){
	      return new AttributeJavaBasedDelta(attDeltaEMF.getAttr(), attDeltaEMF.getNewValue(), attDeltaEMF.getNode());
	   }

	   /*private static Object extractTypeFromString(String value, EAttribute attribute)
	   {
	      return EcoreUtil.createFromString(attribute.getEAttributeType(), value);
	   }*/
}
