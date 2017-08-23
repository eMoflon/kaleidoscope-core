package com.kaleidoscope.core.delta.javabased.structural;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.AddEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.AddNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;



public class StructuralJavaBasedDelta implements Delta {
	
	   private Collection<EObject> addedNodes = new HashSet<>();

	   private Collection<EObject> deletedNodes = new HashSet<>();

	   private Collection<JavaBasedEdge> addedEdges = new HashSet<>();

	   private Collection<JavaBasedEdge> deletedEdges = new HashSet<>();
	   
	   private Collection<AttributeJavaBasedDelta> attributeChanges = new HashSet<>();
	   	   	 
	   
	   public OperationalDelta transformIntoOpDelta() {
		   
		   OperationalDelta operationalDelta = new OperationalDelta();
		   
		   addedNodes.forEach(n -> {
			   AddNodeOp operation = new AddNodeOp(n);
			   operationalDelta.addOperation(operation);
			   
		   });
		   
		   addedEdges.forEach(n -> {
			   AddEdgeOp operation = new AddEdgeOp(n);
			   operationalDelta.addOperation(operation);
		   });
		   
		   deletedEdges.forEach(n -> {
			   DeleteEdgeOp operation = new DeleteEdgeOp(n);
			   operationalDelta.addOperation(operation);
		   });
		   
		   deletedNodes.forEach(n -> {
			   DeleteNodeOp operation = new DeleteNodeOp(n);
			   operationalDelta.addOperation(operation);
			   
		   });
		   return operationalDelta;
	   }
	   
	   
	   public void addNode(EObject node)
	   {
	      addedNodes.add(node);
	   }  

	   public void addEdge(JavaBasedEdge edge)
	   {
	      addedEdges.add(edge);
	   }

	   public void changeAttribute(EAttribute affectedAttribute, Object newValue, EObject obj){
		  attributeChanges.add(new AttributeJavaBasedDelta(affectedAttribute, newValue, obj)); 
	   }
	   
	   public void deleteNode(EObject node)
	   {
	      deletedNodes.add(node);
	   }

	   public void deleteEdge(JavaBasedEdge edge)
	   {
	      deletedEdges.add(edge);
	   }

	   public Collection<EObject> getAddedNodes()
	   {
	      return addedNodes;
	   }

	   public Collection<EObject> getDeletedNodes()
	   {
	      return deletedNodes;
	   }

	   public Collection<JavaBasedEdge> getAddedEdges()
	   {
	      return addedEdges;
	   }
	   

	   public Collection<JavaBasedEdge> getDeletedEdges()
	   {
	      return deletedEdges;
	   }
	   
	   public Collection<AttributeJavaBasedDelta> getAttributeChanges(){
		   return attributeChanges;
	   }

	   public boolean isChangeDetected() {
		   return !(addedNodes.isEmpty() && addedEdges.isEmpty() && deletedNodes.isEmpty() && deletedEdges.isEmpty() && attributeChanges.isEmpty());
	   }

}
