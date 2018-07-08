package com.kaleidoscope.core.delta.javabased.structural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.Delta;
import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;
import com.kaleidoscope.core.delta.javabased.operational.MoveNodeOp;
import com.kaleidoscope.core.delta.javabased.operational.OperationalDelta;

import KaleidoscopeDelta.AttributeChangeOP;
import KaleidoscopeDelta.KaleidoscopeDeltaFactory;
import KaleidoscopeDelta.MoveNodeOP;

public class StructuralDelta implements Delta {
	private Collection<EObject> addedNodes;
	private Collection<EObject> deletedNodes;
	private Collection<JavaBasedEdge> addedEdges;
	private Collection<JavaBasedEdge> deletedEdges;
	private Collection<MoveNodeOp> movedNodes;
	private Collection<AttributeChangeOp> changedAttributes;
	
	public StructuralDelta() {
		addedNodes = new ArrayList<EObject>();
		deletedNodes = new ArrayList<EObject>();
		addedEdges = new ArrayList<JavaBasedEdge>();
		deletedEdges = new ArrayList<JavaBasedEdge>();
		movedNodes = new ArrayList<MoveNodeOp>();
		changedAttributes = new ArrayList<AttributeChangeOp>();
	}
	
	public void addNodes(Collection<EObject> addedNodes) {
		this.addedNodes.addAll(addedNodes);
	}
	
	public void addNode(EObject node) {
		addedNodes.add(node);
	}
	
	public void changeAttributes(Collection<AttributeChangeOp> eList) {
		this.changedAttributes.addAll(eList);
		
	}

	public void moveNodes(Collection<MoveNodeOp> eList) {
		this.movedNodes.addAll(eList);
	}

	public void deleteEdges(Collection<JavaBasedEdge> deletedEdges) {
		this.deletedEdges.addAll(deletedEdges);
	}

	public void addEdges(Collection<JavaBasedEdge> addedEdges) {
		this.addedEdges.addAll(addedEdges);
	}
	
	public void deleteNodes(Collection<EObject> deletedNodes) {
		this.deletedNodes.addAll(deletedNodes);
	}
	
	public void deleteNode(EObject node) {
		deletedNodes.add(node);
	}
	
	/* Transformations to other delta types */
	
	public OperationalDelta transformToOperationalDelta() {
		OperationalDelta odelta = new OperationalDelta();
		
		// First change attributes and move before doing anything else
		
		odelta.getOperations().addAll(changedAttributes);
		odelta.getOperations().addAll(movedNodes);	
		
		// Then perform all deletions
		
		for(EObject node : deletedNodes)
			odelta.deleteNodeOp(node);
		
		for(JavaBasedEdge edge : deletedEdges)
			odelta.deleteEdgeOp(edge);
		
		// And finally additions (nodes before edges obviously)
		
		for(EObject addnode: addedNodes)
			odelta.addNodeOp(addnode);
		
		for(JavaBasedEdge edge : addedEdges)
			odelta.addEdgeOp(edge);
		
		return odelta;
	}
	
	/* EMF-based Support for Persistence */
	
	public KaleidoscopeDelta.StructuralDelta toEMF(){
		KaleidoscopeDelta.StructuralDelta structuralDelta = KaleidoscopeDeltaFactory.eINSTANCE.createStructuralDelta();
		
		structuralDelta.getAddedNodes().addAll(addedNodes);
		structuralDelta.getAddedEdges().addAll(addedEdges.stream()
				.map(JavaBasedEdge::toEMF)
				.collect(Collectors.toList()));
		structuralDelta.getDeletedNodes().addAll(deletedNodes);
		structuralDelta.getDeletedEdges().addAll(deletedEdges.stream()
				.map(JavaBasedEdge::toEMF)
				.collect(Collectors.toList()));
		structuralDelta.getMovedNodes().addAll(movedNodes.stream()
				.map(MoveNodeOp::toOperationalEMF)
				.map(MoveNodeOP.class::cast)
				.collect(Collectors.toList()));
		structuralDelta.getChangedAttributes().addAll(changedAttributes.stream()
				.map(AttributeChangeOp::toOperationalEMF)
				.map(AttributeChangeOP.class::cast)
				.collect(Collectors.toList()));
		
		return structuralDelta;
	}
	
	public static StructuralDelta fromEMF(KaleidoscopeDelta.StructuralDelta structuralDelta) {
		StructuralDelta sdelta = new StructuralDelta();
		
		sdelta.addNodes(structuralDelta.getAddedNodes());
		sdelta.deleteNodes(structuralDelta.getDeletedNodes());
		sdelta.addEdges(structuralDelta.getAddedEdges().stream()
				.map(e -> new JavaBasedEdge(e))
				.collect(Collectors.toList()));
		sdelta.deleteEdges(structuralDelta.getDeletedEdges().stream()
				.map(e -> new JavaBasedEdge(e))
				.collect(Collectors.toList()));
		sdelta.moveNodes(structuralDelta.getMovedNodes().stream()
				.map(mn -> new MoveNodeOp(mn))
				.collect(Collectors.toList()));
		sdelta.changeAttributes(structuralDelta.getChangedAttributes().stream()
				.map(ca -> new AttributeChangeOp(ca))
				.collect(Collectors.toList()));
		
		return sdelta;
	}
	
	/* Normalise and pretty print for comparision or testing purposes */
	
	public String print(Set<Entry<EObject, EObject>> before) {
		return StructuralDeltaPrinter.print(before,
				StructuralDeltaNormaliser.normaliseAttributeChanges(changedAttributes, before), 
				StructuralDeltaNormaliser.normaliseAddedNodes(addedNodes),
				StructuralDeltaNormaliser.normaliseDeletedNodes(deletedNodes, before), 
				StructuralDeltaNormaliser.normaliseMovedNodes(movedNodes), 
				StructuralDeltaNormaliser.normaliseAddedEdges(addedEdges, before),
				StructuralDeltaNormaliser.normaliseDeletedEdges(deletedEdges, before));
	}
	
	//To get before model giving the after model
	
	public static EObject getValueForKey(Set<Entry<EObject, EObject>> beforeModel, EObject op) {
		EObject beforeModelObject = null;
		for(Map.Entry<EObject, EObject> keyValue : beforeModel) { 
			if (keyValue.getValue().equals(op) || keyValue.getKey().equals(op)) {
				beforeModelObject = keyValue.getKey();
			}
		}
		return beforeModelObject;
	}
	
	public static EObject getValueForKeyDeleteNodes(Set<Entry<EObject, EObject>> beforeModel, EObject op) {
		EObject beforeModelObject = null;
		for(Map.Entry<EObject, EObject> keyValue : beforeModel) { 
			if (keyValue.getValue().equals(op) || keyValue.getKey().equals(op)) {
				beforeModelObject = keyValue.getKey();
			}
		}
		return beforeModelObject;
	}
	
	public static EObject getValueForKeyForAttributeChanges(Set<Entry<EObject, EObject>> beforeModel, AttributeChangeOp op) {
		EObject beforeModelObject = null;
		for(Map.Entry<EObject, EObject> keyValue : beforeModel) { 
			if (keyValue.getValue().equals(op.getAffectedNode())) {
				beforeModelObject = keyValue.getKey();
			}
		}
		return beforeModelObject;
	}
	
	public static List<EObject> getValueForKeyDeleteEdges(Set<Entry<EObject, EObject>> beforeModel, JavaBasedEdge op) {
		EObject beforeObjectSrc = null;
		EObject beforeObjectTrg = null;
		List<EObject> beforeModelObjects = new ArrayList<EObject>();
		for(Map.Entry<EObject, EObject> keyValue : beforeModel) { 
			if (keyValue.getKey().equals(op.getSrc()) || keyValue.getValue().equals(op.getSrc())) {
				beforeObjectSrc = keyValue.getKey();
				beforeModelObjects.add(beforeObjectSrc);
			}
			if (keyValue.getKey().equals(op.getTrg()) || keyValue.getValue().equals(op.getTrg())){
				beforeObjectTrg = keyValue.getKey();
				beforeModelObjects.add(beforeObjectTrg);
			}
		}
		return beforeModelObjects;
	}
}
