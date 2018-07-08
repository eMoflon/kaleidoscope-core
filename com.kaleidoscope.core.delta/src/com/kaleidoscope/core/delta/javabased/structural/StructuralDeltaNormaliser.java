package com.kaleidoscope.core.delta.javabased.structural;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge;
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp;
import com.kaleidoscope.core.delta.javabased.operational.MoveNodeOp;

public class StructuralDeltaNormaliser {

	static List<EObject> deletedEdgeList1 = null;
	static List<EObject> deletedEdgeList2 = null;
	public static Collection<AttributeChangeOp> normaliseAttributeChanges(Collection<AttributeChangeOp> changedAttributes, Set<Entry<EObject, EObject>> beforeModel) {
		Collection<AttributeChangeOp> sorted = changedAttributes.stream()
				.sorted((ac1, ac2) -> {
					EObject before = StructuralDelta.getValueForKeyForAttributeChanges(beforeModel, ac1);
					EObject after = StructuralDelta.getValueForKeyForAttributeChanges(beforeModel, ac2);
					if ((null != before && null != after) && (before.hashCode() != after.hashCode())) {
							return before.hashCode() >= after.hashCode() ? 1 : -1;
					}
					else {
						if(ac1.getAffectedNode().hashCode() != ac2.getAffectedNode().hashCode())
							return ac1.getAffectedNode().hashCode() > ac2.getAffectedNode().hashCode() ? 1 : -1;
						else {
							return ac1.getAffectedAttribute().hashCode() >= ac2.getAffectedAttribute().hashCode() ? 1 : -1;
						}
					}
				})
				.collect(Collectors.toList());
				
		return sorted;
	}
	
	public static Collection<EObject> normaliseAddedNodes(Collection<EObject> addedNodes) {
		Collection<EObject> sorted = addedNodes.stream()
				.sorted((an1, an2) -> {
					if(an1.hashCode() != an2.hashCode()){
						return an1.hashCode() >= an2.hashCode() ? 1 : -1;						
					}else {
						return an1.hashCode() >= an2.hashCode() ? 1 : -1;
					}
				})
				.collect(Collectors.toList());
		return sorted;
		}
	
	public static Collection<EObject> normaliseDeletedNodes(Collection<EObject> deletedNodes, Set<Entry<EObject, EObject>> beforeModel) {
		Collection<EObject> sorted = deletedNodes.stream()
				.sorted((dn1, dn2) -> {
					EObject before = StructuralDelta.getValueForKeyDeleteNodes(beforeModel, dn1);
					EObject after = StructuralDelta.getValueForKeyDeleteNodes(beforeModel, dn2);
					if ((null != before && null != after) && (before.hashCode() != after.hashCode())) {
						return before.hashCode() >= after.hashCode() ? 1 : -1;						
					}else {
						return dn1.hashCode() >= dn2.hashCode() ? 1 : -1;
					}
				})
				.collect(Collectors.toList());
		return sorted;
		}
	
	public static Collection<MoveNodeOp> normaliseMovedNodes(Collection<MoveNodeOp> movedNodes) {
		Collection<MoveNodeOp> sorted = movedNodes.stream()
				.sorted((mn1, mn2) -> {
					if(mn1.hashCode() != mn2.hashCode()){
						return mn1.hashCode() >= mn2.hashCode() ? 1 : -1;						
					}else {
						return mn1.hashCode() >= mn2.hashCode() ? 1 : -1;
					}
				})
				.collect(Collectors.toList());
		return sorted;	
		}
	
	public static Collection<JavaBasedEdge> normaliseAddedEdges(Collection<JavaBasedEdge> addedEdges, Set<Entry<EObject, EObject>> beforeModel){
		Collection<JavaBasedEdge> sorted = addedEdges.stream()
				.sorted((ae1, ae2) -> {
					EObject beforeSrc = StructuralDelta.getValueForKey(beforeModel, ae1.getSrc());
					EObject afterSrc = StructuralDelta.getValueForKey(beforeModel, ae2.getSrc());
					EObject afterTrg = StructuralDelta.getValueForKey(beforeModel, ae2.getTrg());
					if (null != beforeSrc && null != afterSrc) {
						if(beforeSrc.hashCode() != afterSrc.hashCode()){
							return beforeSrc.hashCode() > afterSrc.hashCode() ? 1 : -1;
						}
						else {
							beforeSrc = StructuralDelta.getValueForKey(beforeModel, ae1.getTrg());
							afterSrc = StructuralDelta.getValueForKey(beforeModel, ae2.getTrg());
							if (null != beforeSrc && null != afterSrc) {
								return beforeSrc.hashCode() >= afterSrc.hashCode() ? 1 : -1;
							}
							else {
								return ae1.getTrg().hashCode() >= ae2.getTrg().hashCode()? 1 : -1;
							}
						}
					} else if (null == beforeSrc && null != afterSrc){						
						if (ae1.getSrc().hashCode() != afterSrc.hashCode()){				
							return ae1.getSrc().hashCode() > afterSrc.hashCode() ? 1 : -1;
						} 
						else if (ae1.getTrg().hashCode() != afterTrg.hashCode()) {
							return ae1.getTrg().hashCode() >= afterTrg.hashCode()? 1 : -1;
						}
						else {
							return ae1.getType().hashCode() > ae2.getType().hashCode() ? 1 : -1;
						}
					} else {
						if (ae1.getSrc().hashCode() != ae2.getSrc().hashCode()){				
							return ae1.getSrc().hashCode() > ae2.getSrc().hashCode() ? 1 : -1;
						} 
						else if (ae1.getType().hashCode() != ae2.getType().hashCode()) {
							return ae1.getType().hashCode() > ae2.getType().hashCode() ? 1 : -1;
						}
						else {
							return ae1.getTrg().hashCode() >= ae2.getTrg().hashCode()? 1 : -1;
						}
					}
				})
				.collect(Collectors.toList());
			return sorted;
		}
	
	public static Collection<JavaBasedEdge> normaliseDeletedEdges(Collection<JavaBasedEdge> deletedEdges, Set<Entry<EObject, EObject>> beforeModel){
		Collection<JavaBasedEdge> sorted = deletedEdges.stream()
				.sorted((de1, de2) -> {
					deletedEdgeList1 = StructuralDelta.getValueForKeyDeleteEdges(beforeModel, de1);
					deletedEdgeList2 = StructuralDelta.getValueForKeyDeleteEdges(beforeModel, de2);
					if (deletedEdgeList1 != null && deletedEdgeList2 != null) {
						if(deletedEdgeList1.get(0).hashCode() != deletedEdgeList2.get(0).hashCode()){
							return deletedEdgeList1.get(0).hashCode() > deletedEdgeList2.get(0).hashCode() ? 1 : -1;						
						} else if (deletedEdgeList1.get(1).hashCode() != deletedEdgeList2.get(1).hashCode()){
							return deletedEdgeList1.get(1).hashCode() > deletedEdgeList2.get(1).hashCode()? 1 : -1;
						} else 
							return de1.getType().hashCode() >= de2.getType().hashCode() ? 1 : -1;
					} else {
						if(de1.getSrc().hashCode() != de2.getSrc().hashCode()){
							return de1.getSrc().hashCode() > de2.getSrc().hashCode() ? 1 : -1;						
						} else if (de1.getType().hashCode() != de2.getType().hashCode()){
							return de1.getType().hashCode() > de2.getType().hashCode() ? 1 : -1;
						} else 
							return de1.getTrg().hashCode() >= de2.getTrg().hashCode()? 1 : -1;
					}
						
				})
				.collect(Collectors.toList());
			return sorted;
		}

	}

