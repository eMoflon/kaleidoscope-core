package com.kaleidoscope.core.delta.javabased.structural

import com.kaleidoscope.core.delta.javabased.JavaBasedEdge
import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp
import com.kaleidoscope.core.delta.javabased.operational.MoveNodeOp
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import java.util.Set
import java.util.Map.Entry
import java.util.List
import java.util.ArrayList

class StructuralDeltaPrinter {
	
	static EObject beforeModelObject = null;
	static List<EObject> beforeModelObjects = new ArrayList<EObject>();
	def static String print( Set<Entry<EObject, EObject>> before, 
		Collection<AttributeChangeOp> changedAttributes, 
		Collection<EObject> addedNodes, Collection<EObject> deletedNodes, 
		Collection<MoveNodeOp> movedNodes,
		Collection<JavaBasedEdge> addedEdges, 
		Collection<JavaBasedEdge> deletedEdges)
	{
		'''
		// Changed Attributes
		«FOR AttributeChangeOp op : changedAttributes»
			«{beforeModelObject=StructuralDelta.getValueForKeyForAttributeChanges(before, op); null}»
			«op.affectedNode.eClass.name»:«op.affectedNode.eGet(op.affectedAttribute)» ==> «op.newValue»
		«ENDFOR»
		
		// Moved Nodes
		
		«FOR MoveNodeOp op : movedNodes»
			«op.node.eClass.name»
		«ENDFOR»
		
		// Nodes Added
		
		«FOR EObject op : addedNodes»
			«op.eClass.name»
		«ENDFOR»
		
		// Edges Added
		
		«FOR JavaBasedEdge op : addedEdges»
			«{beforeModelObject = StructuralDelta.getValueForKey(before, op.src); null}»
			«IF beforeModelObject !== null»
				«printEdge(op, beforeModelObject, beforeModelObjects, "addEdge")»
			«ELSE»
				«{beforeModelObject = StructuralDelta.getValueForKey(before, op.trg); null}»
				«IF beforeModelObject !== null»
					«printEdge(op, beforeModelObject, beforeModelObjects, "addEdge")»
				«ELSE»
					«printEdge(op, op.src, beforeModelObjects, "addEdge")»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		// Nodes Deleted

		«FOR EObject op : deletedNodes»
			«{beforeModelObject = StructuralDelta.getValueForKeyDeleteNodes(before, op); null}»
			«IF beforeModelObject !== null»
				«op.eClass.name»
			«ELSE»
				«op.eClass.name»
			«ENDIF»
		«ENDFOR»
		
		// Edges Deleted
		
		«FOR JavaBasedEdge op : deletedEdges»
			«{beforeModelObjects = StructuralDelta.getValueForKeyDeleteEdges(before, op); null}»
			«IF beforeModelObjects !== null»
				«printEdge(op, op.src, beforeModelObjects, "deleteEdge")»
			«ELSE»
				«printEdge(op, op.src, beforeModelObjects, "deleteEdge")»
			«ENDIF»
		«ENDFOR»
		'''
	}
	
	protected def static String printEdge(JavaBasedEdge op,  EObject before, List<EObject> beforeObjects, String operation) {
		'''
		«IF operation.equalsIgnoreCase("addEdge")»
			Source: «op.src.eClass.name»--Type: [«op.type.name»]-->Target: «op.trg.eClass.name»
		«ELSEIF operation.equalsIgnoreCase("deleteEdge")»
			Source: «op.src.eClass.name»--Type: [«op.type.name»]-->Target: «op.trg.eClass.name»
		«ENDIF»
		'''
	}
}

