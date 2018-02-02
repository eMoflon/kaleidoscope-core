package com.kaleidoscope.core.delta.javabased.operational;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.opaque.OpaqueDelta;
import com.kaleidoscope.core.delta.javabased.structural.StructuralDelta;

import KaleidoscopeDelta.AddEdgeOP;
import KaleidoscopeDelta.AddNodeOP;
import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.CompositeOP;
import KaleidoscopeDelta.DeleteEdgeOP;
import KaleidoscopeDelta.DeleteNodeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.MoveNodeOP;

/**
 * An {@link OperationalDelta} or just odelta represents a "change to be
 * applied" as an ordered series of {@link Operation}s to be executed in
 * sequence. 
 * 
 * <br/>
 * <br/>
 * 
 * An operational delta can be transformed to an {@link OpaqueDelta}
 * and then executed to perform the actual change to the input/output model.
 * 
 * <br/>
 * <br/>
 * 
 * Operational deltas can be loaded and persisted by transforming them to
 * corresponding EMF data structures via
 * {@link OperationalDelta#fromEMF(KaleidoscopeDelta.OperationalDelta)} and
 * {@link OperationalDelta#toEMF()}, respectively.
 * 
 * @author aanjorin, dgataric
 */
public class OperationalDelta implements Delta {
	private List<Operation> operations;

	public OperationalDelta() {
		operations = new ArrayList<>();
	}

	/* Methods to manipulate the sequence of operations in the odelta */
	
	public  List<Operation> getOperations() {
		return operations;
	}

	public void addOperation(Operation op) {
		operations.add(op);
	}

	public void addNodeOp(EObject node) {
		operations.add(new AddNodeOp(node));
	}

	public void addEdgeOp(JavaBasedEdge edge) {
		operations.add(new AddEdgeOp(edge));
	}

	public void changeAttributeOp(EAttribute affectedAttribute, Object newValue, EObject obj) {
		operations.add(new AttributeChangeOp(affectedAttribute, newValue, obj));
	}
	
	public void changeAttributeOp(EAttribute affectedAttribute, Object newValue, EObject obj, Object oldValue) {
		operations.add(new AttributeChangeOp(affectedAttribute, newValue, obj, oldValue));
	}

	public void deleteNodeOp(EObject node) {
		operations.add(new DeleteNodeOp(node));
	}

	public void deleteEdgeOp(JavaBasedEdge edge) {
		operations.add(new DeleteEdgeOp(edge));
	}

	public void moveNodeOp(EObject node, int newIndex) {
		operations.add(new MoveNodeOp(node, newIndex));
	}

	public boolean isIdle() {
		return operations.isEmpty();
	}
	
	/* Transformations to other delta types */
	
	public <Model> OpaqueDelta<Model> transformToOpaqueDelta() {
		
		
		return (input) -> {
			for(int i = 0; i < operations.size(); i++)
				operations.get(i).executeOperation();
		};
	}
	
	public void rollback() {
	
		for(int i = operations.size() - 1; i >= 0; i--)
			operations.get(i).rollbackOperation();
	}
	
	public StructuralDelta transformToStructuralDelta() {
		StructuralDelta sdelta = new StructuralDelta();
		
		// Added nodes
		sdelta.addNodes(convertToStructural(AddNodeOp.class, (op) -> op.getNode()));
		
		// Deleted nodes
		sdelta.deleteNodes(convertToStructural(DeleteNodeOp.class, (op) -> op.getNode()));
		
		// Moved nodes
		sdelta.moveNodes(convertToStructural(MoveNodeOp.class, (op) -> op));
		
		// Changed attributes
		sdelta.changeAttributes(convertToStructural(AttributeChangeOp.class, (op) -> op));
		
		// Added edges
		sdelta.addEdges(convertToStructural(AddEdgeOp.class, (op) -> op.getEdge()));
		
		// Deleted edges
		sdelta.deleteEdges(convertToStructural(DeleteEdgeOp.class, (op) -> op.getEdge()));
		
		return sdelta;
	}
	
	private <From, To> Collection<To> convertToStructural(Class<From> c, Function<From, To> conversion) {
		return operations.stream()
		  		  .filter(c::isInstance)
		  		  .map(c::cast)
		  		  .map(conversion)
		  		  .collect(Collectors.toList());
	}
	
	/* EMF-based Support for Persistence */

	public static OperationalDelta fromEMF(KaleidoscopeDelta.OperationalDelta operationalDelta) {
		OperationalDelta odelta = new OperationalDelta();
		
		for (KaleidoscopeDelta.Operation operation : operationalDelta.getOperations()) {
			if (operation instanceof KaleidoscopeDelta.AddEdgeOP) 
				odelta.addOperation(new AddEdgeOp((AddEdgeOP) operation));
			if (operation instanceof DeleteEdgeOP)
				odelta.addOperation(new DeleteEdgeOp((DeleteEdgeOP) operation));
			if (operation instanceof AddNodeOP)
				odelta.addOperation(new AddNodeOp((AddNodeOP) operation));
			if (operation instanceof AttributeChangeOP)
				odelta.addOperation(new AttributeChangeOp((AttributeChangeOP) operation));
			if (operation instanceof DeleteNodeOP)
				odelta.addOperation(new DeleteNodeOp((DeleteNodeOP) operation));
			if (operation instanceof MoveNodeOP)
				odelta.addOperation(new MoveNodeOp((MoveNodeOP) operation));
			if (operation instanceof CompositeOP)
				odelta.addOperation(new CompositeOp((CompositeOP) operation));
		}
		
		return odelta;
	}
	
	public KaleidoscopeDelta.OperationalDelta toEMF() {
		KaleidoscopeDelta.OperationalDelta operationalDelta = KaleidoscopeDeltaFactory.eINSTANCE.createOperationalDelta();
		operations.forEach(o -> operationalDelta.getOperations().add(o.toOperationalEMF()));
		return operationalDelta;
	}
}
