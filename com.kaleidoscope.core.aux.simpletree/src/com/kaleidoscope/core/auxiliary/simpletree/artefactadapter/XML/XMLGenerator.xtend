package com.kaleidoscope.core.auxiliary.simpletree.artefactadapter.XML;

import Simpletree.Node

class XMLGenerator {

	def String generate(Node root, String header) {
		return header + generate(root)	
	}

	def String generate(Node node) '''
		<«node.name»«generateAttributes(node)»«IF (node.children.size==0)» "/>"
		«ELSE»
			«FOR child : node.children»
				«generate(child as Node)»
			«ENDFOR»
		</«node.getName()»>
		«ENDIF»
	'''

	def String generateAttributes(Node node) '''«FOR attr : node.attribute» «attr.name»="«attr.value»"«ENDFOR»'''

}
