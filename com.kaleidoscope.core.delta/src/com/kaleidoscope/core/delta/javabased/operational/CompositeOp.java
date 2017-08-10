package com.kaleidoscope.core.delta.javabased.operational;

import java.util.ArrayList;
import java.util.List;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.CompositeOP;
import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.MoveNodeOP;

public class CompositeOp extends Operation{

	List<Operation>operations = new ArrayList<Operation>();
	
	public CompositeOp(){
		
	}
	public CompositeOp(CompositeOP compositeOP) {
		
		for (KaleidoscopeDelta.Operation operation : compositeOP.getOperations()) {
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

	@Override
	public KaleidoscopeDelta.Operation toOperationalEMF() {
		 KaleidoscopeDelta.CompositeOP compositeOperation = KaleidoscopeDeltaFactory.eINSTANCE.createCompositeOP();      
		 operations.forEach(o -> compositeOperation.getOperations().add(o.toOperationalEMF()));
		       
	     return compositeOperation;
	}

	@Override
	public void executeOperation() {
		operations.forEach(o -> o.executeOperation());		
	}

	public void addOperation(Operation o){
		operations.add(o);
	}
	public List<Operation> getOperations(){
		return operations;
	}
}
