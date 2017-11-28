package com.kaleidoscope.core.delta.javabased.structural

import com.kaleidoscope.core.delta.javabased.operational.AttributeChangeOp
import java.util.Collection

class StructuralDeltaPrinter {
	def static String print(Collection<AttributeChangeOp> changedAttributes){
		'''
		// Changed Attributes
		«FOR AttributeChangeOp op : changedAttributes»
			«op.affectedNode»
				«op.affectedNode.eGet(op.affectedAttribute)» ==> «op.newValue»
		«ENDFOR»
		
		// Moved Nodes
		
		// Nodes Added
		
		// Edges Added
		
		// Nodes Deleted
		
		// Edges Deleted
		
		'''
	}
}
