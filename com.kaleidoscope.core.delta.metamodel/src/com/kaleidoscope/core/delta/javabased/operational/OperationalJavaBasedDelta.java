package com.kaleidoscope.core.delta.javabased.operational;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.JavaBasedDelta;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.AddEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.AddNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;
import com.kaleidoscope.core.delta.javabased.operational.CompositeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteEdgeOp;
import com.kaleidoscope.core.delta.javabased.operational.DeleteNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.MoveNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.Operation;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.CompositeOP;
import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.MoveNodeOP;
import KaleidoscopeDelta.OperationalDelta;



public class OperationalJavaBasedDelta extends JavaBasedDelta {
	
	   private List<Operation> operations = new ArrayList<>();

	
	   public OperationalJavaBasedDelta(){
		   
	   }
	   
	   public void createFromEMFOperationalDelta(OperationalDelta operationalDelta){
		   
		   operations = new ArrayList<>();
		   for (KaleidoscopeDelta.Operation operation : operationalDelta.getOperations()) {
			   if(operation instanceof AddEdgeOP){
				   operations.add(new AddEdgeOp((AddEdgeOP)operation));
			   }
			   if(operation instanceof DeleteEdgeOP){
				   operations.add(new DeleteEdgeOp((DeleteEdgeOP)operation));
			   }
			   if(operation instanceof AddNodeOP){
				   operations.add(new AddNodeOp((AddNodeOP)operation));
			   }
			   if(operation instanceof AttributeChangeOP){
				   operations.add(new AttributeChangeOp((AttributeChangeOP)operation));
			   }
			   if(operation instanceof DeleteNodeOP){
				   operations.add(new DeleteNodeOp((DeleteNodeOP)operation));
			   }
			   if(operation instanceof MoveNodeOP){
				   operations.add(new MoveNodeOp((MoveNodeOP)operation));
			   }
			   if(operation instanceof CompositeOP){
				   operations.add(new CompositeOp((CompositeOP)operation));
			   }
		   }
		   
	   }

	   public OperationalJavaBasedDelta(OperationalDelta operationalDelta){
		   
		   for (KaleidoscopeDelta.Operation operation : operationalDelta.getOperations()) {
			   if(operation instanceof AddEdgeOP){
				   operations.add(new AddEdgeOp((AddEdgeOP)operation));
			   }
			   if(operation instanceof DeleteEdgeOP){
				   operations.add(new DeleteEdgeOp((DeleteEdgeOP)operation));
			   }
			   if(operation instanceof AddNodeOP){
				   operations.add(new AddNodeOp((AddNodeOP)operation));
			   }
			   if(operation instanceof AttributeChangeOP){
				   operations.add(new AttributeChangeOp((AttributeChangeOP)operation));
			   }
			   if(operation instanceof DeleteNodeOP){
				   operations.add(new DeleteNodeOp((DeleteNodeOP)operation));
			   }
			   if(operation instanceof MoveNodeOP){
				   operations.add(new MoveNodeOp((MoveNodeOP)operation));
			   }
			   if(operation instanceof CompositeOP){
				   operations.add(new CompositeOp((CompositeOP)operation));
			   }
		   }
		   
	   }
	   
	   public List<Operation> getOperations(){
		   return operations;
	   }
	   public void setOperations(List<Operation>ops){
		   operations = ops;
	   }
	   
	   public void addOperation(Operation op){
		   operations.add(op);
	   }
	   public void addNodeOp(EObject node){
		   operations.add(new AddNodeOp(node));
	   }
	   public void addEdgeOp(JavaBasedEdge edge){
		   operations.add(new AddEdgeOp(edge));
	   }
	   public void changeAttributeOp(EAttribute affectedAttribute, Object newValue, EObject obj){
			  operations.add(new AttributeChangeOp(affectedAttribute, newValue, obj)); 
	   }
	   public void deleteNodeOp(EObject node){
		   operations.add(new DeleteNodeOp(node));
	   }
	   public void deleteEdgeOp(JavaBasedEdge edge){
		   operations.add(new DeleteEdgeOp(edge));
	   }
	   public void moveNodeOp(EObject node, int newIndex){
		   operations.add(new MoveNodeOp(node, newIndex));
	   }
	   
	   public Consumer<EObject> executeOperationalDelta(){
		   Consumer<EObject> edit = (input) -> {
			   
			   operations.forEach((o) -> o.executeOperation());
			};
			return edit;
	   }
	   public OperationalDelta transformIntoOperationalDelta(){
		   OperationalDelta operationalDelta = KaleidoscopeDeltaFactory.eINSTANCE.createOperationalDelta();
		   operations.stream().forEach(o -> operationalDelta.getOperations().add(o.toOperationalEMF()));
		   return operationalDelta;
	   }
}
