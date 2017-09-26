package com.kaleidoscope.core.delta.javabased.structural;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;

/**
 * A {@link StructuralDelta} or just "sdelta" represents an "applied change" as
 * a set of collections from which the change can be reconstructed in terms of
 * changed, added, and deleted elements. It is, however, impossible to
 * reconstruct the exact order in which atomic changes were applied.
 * 
 * @author aanjorin, dgataric
 */
public class StructuralDelta implements Delta {
	private Collection<EObject> addedNodes = new HashSet<>();
	private Collection<EObject> deletedNodes = new HashSet<>();
	private Collection<JavaBasedEdge> addedEdges = new HashSet<>();
	private Collection<JavaBasedEdge> deletedEdges = new HashSet<>();
	private Collection<AttributeJavaBasedDelta> attributeChanges = new HashSet<>();

	/* Methods to manipulate the sequence of operations in the odelta */

	public void addNode(EObject node) {
		addedNodes.add(node);
	}

	public void addEdge(JavaBasedEdge edge) {
		addedEdges.add(edge);
	}

	public void changeAttribute(EAttribute affectedAttribute, Object newValue, EObject obj) {
		attributeChanges.add(new AttributeJavaBasedDelta(affectedAttribute, newValue, obj));
	}

	public void deleteNode(EObject node) {
		deletedNodes.add(node);
	}

	public void deleteEdge(JavaBasedEdge edge) {
		deletedEdges.add(edge);
	}

	public boolean isIdle() {
		return addedNodes.isEmpty() && 
			   addedEdges.isEmpty() && 
			   deletedNodes.isEmpty() && 
			   deletedEdges.isEmpty() && 
			   attributeChanges.isEmpty();
	}
}
