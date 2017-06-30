package com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser

import SimpleJava.JavaArrayInit
import SimpleJava.JavaAssignment
import SimpleJava.JavaCompilationUnit
import SimpleJava.JavaExpression
import SimpleJava.JavaImport
import SimpleJava.JavaLiteral
import SimpleJava.JavaMethod
import SimpleJava.JavaMethodInvocation
import SimpleJava.JavaName
import SimpleJava.JavaOpaqueMethod
import SimpleJava.JavaPackage
import SimpleJava.JavaStatement
import SimpleJava.JavaUnknownStatement
import SimpleJava.JavaVariableDeclaration
import SimpleJava.JavaWorkflowMethod
import com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser.JavaCompilationUnitNormaliser
import com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser.JavaExpressionNormaliser
import com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser.JavaImportNormaliser
import com.kaleidoscope.implementation.artefactadapter.normaliser.java_normaliser.JavaMethodNormaliser
import java.util.ArrayList
import java.util.List

class JavaPackageToString {
	private boolean sortMethods;
	private boolean sortImports;
	private JavaImportNormaliser javaImportNormaliser = new JavaImportNormaliser();
	private JavaMethodNormaliser javaMethodNormaliser = new JavaMethodNormaliser();
	private JavaCompilationUnitNormaliser javaCompilationUnitNormaliser = new JavaCompilationUnitNormaliser();
	private JavaExpressionNormaliser<JavaVariableDeclaration> javaVariableDeclarationNormaliser = new JavaExpressionNormaliser<JavaVariableDeclaration>();
	private JavaExpressionNormaliser<JavaExpression> javaExpressionNormaliser = new JavaExpressionNormaliser<JavaExpression>();
	
	new(){
		this.sortMethods = true;
		this.sortImports = true;
		this.javaImportNormaliser = new JavaImportNormaliser();
		this.javaMethodNormaliser = new JavaMethodNormaliser();
		this.javaVariableDeclarationNormaliser = new JavaExpressionNormaliser();
	}
	
	def unparse(JavaPackage jPackage){
		return '''
		package {
		«val List<JavaCompilationUnit> sortedCompilationUnits = new ArrayList<JavaCompilationUnit>(jPackage.cunits)»
		«javaCompilationUnitNormaliser.normalize(sortedCompilationUnits)»
		«FOR cu : sortedCompilationUnits SEPARATOR "\n"»
			«unparseCompilationUnit(jPackage.name, cu)»
		«ENDFOR»
		}
		'''
	}
	def unparseCompilationUnit(String javaPackage, JavaCompilationUnit jCompilationUnit)
		'''
		package «javaPackage»;
		«val List<JavaImport> sortedImports = new ArrayList<JavaImport>(jCompilationUnit.imports)»
		«IF sortImports»«javaImportNormaliser.normalize(sortedImports)»«ENDIF»
		
		«FOR i : sortedImports»
		import «i.value»;
		«ENDFOR»
		
		public class «jCompilationUnit.name»{		
			«IF jCompilationUnit.fieldDeclarations != null»«jCompilationUnit.fieldDeclarations»«ENDIF»	
			
			«val List<JavaMethod> sortedMethods = new ArrayList<JavaMethod>(jCompilationUnit.methods)»
			«IF sortMethods»«javaMethodNormaliser.normalize(sortedMethods)»«ENDIF»
			«FOR m : sortedMethods SEPARATOR "\n"»
				«unparseMethod(m)»
			«ENDFOR»
		}
		'''
	
	def unparseMethod(JavaMethod jMethod)
	'''«IF jMethod instanceof JavaWorkflowMethod»
	«unparseWorkflowMethod(jMethod)»
		«ENDIF»
		«IF jMethod instanceof JavaOpaqueMethod»
	«unparseOpaqueMethod(jMethod)»
		«ENDIF»
	'''
	
	def unparseWorkflowMethod(JavaWorkflowMethod jMethod)
	'''
@Generated(value={"Crypto"})
«val List<JavaVariableDeclaration> sortedParameters = new ArrayList<JavaVariableDeclaration>(jMethod.params)»«javaVariableDeclarationNormaliser.normalize(sortedParameters)»«jMethod.modifier» «jMethod.type» «jMethod.name»(«sortedParameters.map[p|p.type + " " + p.name].join(',')») «IF jMethod.throws.length > 1»throws«ENDIF» «jMethod.throws»
{
  «FOR s : jMethod.statements»
  «unparseStatement(s)»		
  «ENDFOR»		
}
	'''
	
	def unparseOpaqueMethod(JavaOpaqueMethod jMethod)
	'''«jMethod.modifier» «jMethod.type» «jMethod.name»(«jMethod.parameters») «IF jMethod.throws != null»«IF jMethod.throws.length > 1»throws«ENDIF» «jMethod.throws»«ENDIF»
«jMethod.body»
	'''
	def unparseStatement(JavaStatement jStat)'''
	«IF jStat instanceof JavaUnknownStatement»
		«jStat.body»
	«ELSEIF jStat.^return»
		return «unparseExpression(jStat.expr)»;
		«ELSE»
		«unparseExpression(jStat.expr) + ';'»
	«ENDIF»
	'''
	
	def CharSequence unparseExpression(JavaExpression jExpr){
		if(jExpr instanceof JavaName){
			return unparseName(jExpr);
		} 
		else if(jExpr instanceof JavaLiteral){
			unparseLiteral(jExpr);
		}
		else if(jExpr instanceof JavaAssignment){
			unparseAssignment(jExpr);
		}
		else if(jExpr instanceof JavaMethodInvocation){
			unparseMethodInvocation(jExpr);
		}
		else if(jExpr instanceof JavaVariableDeclaration){
			unparseVariableDeclaration(jExpr);
		}
		else if(jExpr instanceof JavaArrayInit){
			unparseArrayInit(jExpr);
		}
		
	}
	def unparseName(JavaName jName)
	'''«jName.identifier»'''

	def unparseLiteral(JavaLiteral jLiteral)
	'''«jLiteral.value»'''
	
	def unparseAssignment(JavaAssignment jAssign)
	'''«unparseExpression(jAssign.lhs)» = «unparseExpression(jAssign.rhs)»'''
	
	// the method takes jArrayInit.type which is a type of array e.g. byte[]
	// then it located substring [] and add at that position jArrayInit.dimension which is dimension of the array
	def unparseArrayInit(JavaArrayInit jArrayInit)
	'''new «new StringBuilder(jArrayInit.type).insert(jArrayInit.type.indexOf("[]") + 1, jArrayInit.dimension).toString()»'''
	
	def unparseMethodInvocation(JavaMethodInvocation jMethodInvocation)
	'''
	«val List<JavaExpression> sortedArguments = new ArrayList<JavaExpression>(jMethodInvocation.arguments)»
		«javaExpressionNormaliser.normalize(sortedArguments)»
	«IF jMethodInvocation.initialization»new «ENDIF»«IF jMethodInvocation.optionalExpression != null»
«unparseExpression(jMethodInvocation.optionalExpression)».«ENDIF»«jMethodInvocation.name»(«sortedArguments.map[a|unparseExpression(a)].join(",")»)'''
	
	def unparseVariableDeclaration(JavaVariableDeclaration jVarDec)
	'''«jVarDec.type» «jVarDec.name»'''
	
}
