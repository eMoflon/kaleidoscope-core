/**
 */
package SimpleJava.util;

import SimpleJava.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see SimpleJava.SimpleJavaPackage
 * @generated
 */
public class SimpleJavaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SimpleJavaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaSwitch() {
		if (modelPackage == null) {
			modelPackage = SimpleJavaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SimpleJavaPackage.JAVA_PACKAGE: {
				JavaPackage javaPackage = (JavaPackage)theEObject;
				T result = caseJavaPackage(javaPackage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_COMPILATION_UNIT: {
				JavaCompilationUnit javaCompilationUnit = (JavaCompilationUnit)theEObject;
				T result = caseJavaCompilationUnit(javaCompilationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_IMPORT: {
				JavaImport javaImport = (JavaImport)theEObject;
				T result = caseJavaImport(javaImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_METHOD: {
				JavaMethod javaMethod = (JavaMethod)theEObject;
				T result = caseJavaMethod(javaMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_VARIABLE_DECLARATION: {
				JavaVariableDeclaration javaVariableDeclaration = (JavaVariableDeclaration)theEObject;
				T result = caseJavaVariableDeclaration(javaVariableDeclaration);
				if (result == null) result = caseJavaExpression(javaVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_OPAQUE_METHOD: {
				JavaOpaqueMethod javaOpaqueMethod = (JavaOpaqueMethod)theEObject;
				T result = caseJavaOpaqueMethod(javaOpaqueMethod);
				if (result == null) result = caseJavaMethod(javaOpaqueMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_WORKFLOW_METHOD: {
				JavaWorkflowMethod javaWorkflowMethod = (JavaWorkflowMethod)theEObject;
				T result = caseJavaWorkflowMethod(javaWorkflowMethod);
				if (result == null) result = caseJavaMethod(javaWorkflowMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_STATEMENT: {
				JavaStatement javaStatement = (JavaStatement)theEObject;
				T result = caseJavaStatement(javaStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_UNKNOWN_STATEMENT: {
				JavaUnknownStatement javaUnknownStatement = (JavaUnknownStatement)theEObject;
				T result = caseJavaUnknownStatement(javaUnknownStatement);
				if (result == null) result = caseJavaStatement(javaUnknownStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_EXPRESSION: {
				JavaExpression javaExpression = (JavaExpression)theEObject;
				T result = caseJavaExpression(javaExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION: {
				JavaMethodInvocation javaMethodInvocation = (JavaMethodInvocation)theEObject;
				T result = caseJavaMethodInvocation(javaMethodInvocation);
				if (result == null) result = caseJavaExpression(javaMethodInvocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_ASSIGNMENT: {
				JavaAssignment javaAssignment = (JavaAssignment)theEObject;
				T result = caseJavaAssignment(javaAssignment);
				if (result == null) result = caseJavaExpression(javaAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_LITERAL: {
				JavaLiteral javaLiteral = (JavaLiteral)theEObject;
				T result = caseJavaLiteral(javaLiteral);
				if (result == null) result = caseJavaExpression(javaLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_NAME: {
				JavaName javaName = (JavaName)theEObject;
				T result = caseJavaName(javaName);
				if (result == null) result = caseJavaExpression(javaName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SimpleJavaPackage.JAVA_ARRAY_INIT: {
				JavaArrayInit javaArrayInit = (JavaArrayInit)theEObject;
				T result = caseJavaArrayInit(javaArrayInit);
				if (result == null) result = caseJavaExpression(javaArrayInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaPackage(JavaPackage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Compilation Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaCompilationUnit(JavaCompilationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaImport(JavaImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaMethod(JavaMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaVariableDeclaration(JavaVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Opaque Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Opaque Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaOpaqueMethod(JavaOpaqueMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Workflow Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Workflow Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaWorkflowMethod(JavaWorkflowMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaStatement(JavaStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Unknown Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Unknown Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaUnknownStatement(JavaUnknownStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaExpression(JavaExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Method Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Method Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaMethodInvocation(JavaMethodInvocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaAssignment(JavaAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaLiteral(JavaLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaName(JavaName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Array Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Array Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaArrayInit(JavaArrayInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SimpleJavaSwitch
