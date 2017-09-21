/**
 */
package SimpleJava;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see SimpleJava.SimpleJavaPackage
 * @generated
 */
public interface SimpleJavaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimpleJavaFactory eINSTANCE = SimpleJava.impl.SimpleJavaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Package</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Package</em>'.
	 * @generated
	 */
	JavaPackage createJavaPackage();

	/**
	 * Returns a new object of class '<em>Java Compilation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Compilation Unit</em>'.
	 * @generated
	 */
	JavaCompilationUnit createJavaCompilationUnit();

	/**
	 * Returns a new object of class '<em>Java Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Import</em>'.
	 * @generated
	 */
	JavaImport createJavaImport();

	/**
	 * Returns a new object of class '<em>Java Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Method</em>'.
	 * @generated
	 */
	JavaMethod createJavaMethod();

	/**
	 * Returns a new object of class '<em>Java Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Variable Declaration</em>'.
	 * @generated
	 */
	JavaVariableDeclaration createJavaVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Java Opaque Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Opaque Method</em>'.
	 * @generated
	 */
	JavaOpaqueMethod createJavaOpaqueMethod();

	/**
	 * Returns a new object of class '<em>Java Workflow Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Workflow Method</em>'.
	 * @generated
	 */
	JavaWorkflowMethod createJavaWorkflowMethod();

	/**
	 * Returns a new object of class '<em>Java Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Statement</em>'.
	 * @generated
	 */
	JavaStatement createJavaStatement();

	/**
	 * Returns a new object of class '<em>Java Unknown Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Unknown Statement</em>'.
	 * @generated
	 */
	JavaUnknownStatement createJavaUnknownStatement();

	/**
	 * Returns a new object of class '<em>Java Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Expression</em>'.
	 * @generated
	 */
	JavaExpression createJavaExpression();

	/**
	 * Returns a new object of class '<em>Java Method Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Method Invocation</em>'.
	 * @generated
	 */
	JavaMethodInvocation createJavaMethodInvocation();

	/**
	 * Returns a new object of class '<em>Java Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Assignment</em>'.
	 * @generated
	 */
	JavaAssignment createJavaAssignment();

	/**
	 * Returns a new object of class '<em>Java Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Literal</em>'.
	 * @generated
	 */
	JavaLiteral createJavaLiteral();

	/**
	 * Returns a new object of class '<em>Java Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Name</em>'.
	 * @generated
	 */
	JavaName createJavaName();

	/**
	 * Returns a new object of class '<em>Java Array Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Array Init</em>'.
	 * @generated
	 */
	JavaArrayInit createJavaArrayInit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimpleJavaPackage getSimpleJavaPackage();

} //SimpleJavaFactory
