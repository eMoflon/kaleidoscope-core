package com.kaleidoscope.core.delta.javabased.structural;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.MoveNodeOP;

public class StructuralDelta implements Delta {
	private Collection<EObject> addedNodes;
	private Collection<EObject> deletedNodes;
	private Collection<Edge> addedEgdes;
	private Collection<Edge> deletedEdges;
	private Collection<MoveNodeOP> movedNodes;
	private Collection<AttributeChangeOP> changedAttribute;
	
	public StructuralDelta() {
		addedNodes = new ArrayList<EObject>();
		deletedNodes = new ArrayList<EObject>();
		addedEgdes = new ArrayList<Edge>();
		deletedEdges = new ArrayList<Edge>();
		movedNodes = new ArrayList<MoveNodeOP>();
		changedAttribute = new ArrayList<AttributeChangeOP>();
	}
	
	private void addNodes(EList<EObject> addedNodes) {
		this.addedNodes.addAll(addedNodes);
	}
	
	private void changeAttributes(EList<AttributeChangeOP> eList) {
		this.changedAttribute.addAll(eList);
		
	}

	private void moveNodes(EList<MoveNodeOP> eList) {
		this.movedNodes.addAll(eList);
		
	}

	private void deleteEdges(EList<Edge> deletedEdges) {
		this.deletedEdges.addAll(deletedEdges);
		
	}

	private void addEdges(EList<Edge> addedEdges) {
		this.addedEgdes.addAll(addedEdges);
		
	}

	private void deleteNodes(EList<EObject> deletedNodes) {
		this.deletedNodes.addAll(deletedNodes);
		
	}
	
	/* Transformations to other delta types */
	
	public OperationalDelta transformToOperationalDelta(KaleidoscopeDelta.StructuralDelta sDelta) {
		OperationalDelta odelta = new OperationalDelta();
		for(EObject addnode: sDelta.getAddedNodes()) {
			odelta.addNodeOp(addnode);
		}
		for(EObject deletenode: sDelta.getDeletedNodes()){
			odelta.deleteNodeOp(deletenode);
		}
		for(AttributeChangeOP changeAttribute: sDelta.getChangedAttributes()){
			odelta.changeAttributeOp(changeAttribute.getAttr(), changeAttribute.getNewValue(), changeAttribute.getNode());
		}
		for(MoveNodeOP movednode: sDelta.getMovedNodes()) {
			odelta.moveNodeOp(movednode, movednode.getNewIndex());
		}
		return odelta;
	}
	
	
	
	/* EMF-based Support for Persistence */
	
	public KaleidoscopeDelta.StructuralDelta toEMF(){
		KaleidoscopeDelta.StructuralDelta structuralDelta = KaleidoscopeDeltaFactory.eINSTANCE.createStructuralDelta();
		addedNodes.forEach(s -> structuralDelta.getAddedEdges());
		deletedNodes.forEach(s -> structuralDelta.getDeletedNodes());
		addedEgdes.forEach(s -> structuralDelta.getAddedEdges());
		deletedEdges.forEach(s -> structuralDelta.getDeletedEdges());
		movedNodes.forEach(s -> structuralDelta.getMovedNodes());
		changedAttribute.forEach(s -> structuralDelta.getChangedAttributes());
		return structuralDelta;
	}
	
	public static StructuralDelta fromEMF(KaleidoscopeDelta.StructuralDelta structuralDelta) {
		StructuralDelta sdelta = new StructuralDelta();
		
		sdelta.addNodes(structuralDelta.getAddedNodes());
		sdelta.deleteNodes(structuralDelta.getDeletedNodes());
		sdelta.addEdges(structuralDelta.getAddedEdges());
		sdelta.deleteEdges(structuralDelta.getDeletedEdges());
		sdelta.moveNodes(structuralDelta.getMovedNodes());
		sdelta.changeAttributes(structuralDelta.getChangedAttributes());
		
		return sdelta;
	}
}
