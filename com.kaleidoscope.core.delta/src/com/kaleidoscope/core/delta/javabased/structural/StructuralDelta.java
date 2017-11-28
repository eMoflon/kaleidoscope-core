package com.kaleidoscope.core.delta.javabased.structural;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

import KaleidoscopeDelta.AttributeDelta;
import KaleidoscopeDelta.Edge;
import KaleidoscopeDelta.MovedNodeDelta;

public class StructuralDelta implements Delta {
	private Collection<EObject> addedNodes;
	
	public StructuralDelta() {
		addedNodes = new ArrayList<EObject>();
	}
	
	private void addNodes(EList<EObject> addedNodes) {
		this.addedNodes.addAll(addedNodes);
	}
	
	private void changeAttributes(EList<AttributeDelta> changedAttributes) {
		// TODO Auto-generated method stub
		
	}

	private void moveNodes(EList<MovedNodeDelta> movedNodes) {
		// TODO Auto-generated method stub
		
	}

	private void deleteEdges(EList<Edge> deletedEdges) {
		// TODO Auto-generated method stub
		
	}

	private void addEdges(EList<Edge> addedEdges) {
		// TODO Auto-generated method stub
		
	}

	private void deleteNodes(EList<EObject> deletedNodes) {
		// TODO Auto-generated method stub
		
	}
	
	/* Transformations to other delta types */
	
	public OperationalDelta transformToOperationalDelta() {
		// TODO
	}
	
	
	
	/* EMF-based Support for Persistence */
	
	public KaleidoscopeDelta.StructuralDelta toEMF(){
		// TODO
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
