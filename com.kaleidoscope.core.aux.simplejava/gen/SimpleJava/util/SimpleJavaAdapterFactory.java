/**
 */
package SimpleJava.util;

import SimpleJava.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see SimpleJava.SimpleJavaPackage
 * @generated
 */
public class SimpleJavaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SimpleJavaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SimpleJavaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleJavaSwitch<Adapter> modelSwitch = new SimpleJavaSwitch<Adapter>() {
		@Override
		public Adapter caseJavaPackage(JavaPackage object) {
			return createJavaPackageAdapter();
		}

		@Override
		public Adapter caseJavaCompilationUnit(JavaCompilationUnit object) {
			return createJavaCompilationUnitAdapter();
		}

		@Override
		public Adapter caseJavaImport(JavaImport object) {
			return createJavaImportAdapter();
		}

		@Override
		public Adapter caseJavaMethod(JavaMethod object) {
			return createJavaMethodAdapter();
		}

		@Override
		public Adapter caseJavaVariableDeclaration(JavaVariableDeclaration object) {
			return createJavaVariableDeclarationAdapter();
		}

		@Override
		public Adapter caseJavaOpaqueMethod(JavaOpaqueMethod object) {
			return createJavaOpaqueMethodAdapter();
		}

		@Override
		public Adapter caseJavaWorkflowMethod(JavaWorkflowMethod object) {
			return createJavaWorkflowMethodAdapter();
		}

		@Override
		public Adapter caseJavaStatement(JavaStatement object) {
			return createJavaStatementAdapter();
		}

		@Override
		public Adapter caseJavaUnknownStatement(JavaUnknownStatement object) {
			return createJavaUnknownStatementAdapter();
		}

		@Override
		public Adapter caseJavaExpression(JavaExpression object) {
			return createJavaExpressionAdapter();
		}

		@Override
		public Adapter caseJavaMethodInvocation(JavaMethodInvocation object) {
			return createJavaMethodInvocationAdapter();
		}

		@Override
		public Adapter caseJavaAssignment(JavaAssignment object) {
			return createJavaAssignmentAdapter();
		}

		@Override
		public Adapter caseJavaLiteral(JavaLiteral object) {
			return createJavaLiteralAdapter();
		}

		@Override
		public Adapter caseJavaName(JavaName object) {
			return createJavaNameAdapter();
		}

		@Override
		public Adapter caseJavaArrayInit(JavaArrayInit object) {
			return createJavaArrayInitAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaPackage <em>Java Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaPackage
	 * @generated
	 */
	public Adapter createJavaPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaCompilationUnit <em>Java Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaCompilationUnit
	 * @generated
	 */
	public Adapter createJavaCompilationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaImport <em>Java Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaImport
	 * @generated
	 */
	public Adapter createJavaImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaMethod <em>Java Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaMethod
	 * @generated
	 */
	public Adapter createJavaMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaVariableDeclaration <em>Java Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaVariableDeclaration
	 * @generated
	 */
	public Adapter createJavaVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaOpaqueMethod <em>Java Opaque Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaOpaqueMethod
	 * @generated
	 */
	public Adapter createJavaOpaqueMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaWorkflowMethod <em>Java Workflow Method</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaWorkflowMethod
	 * @generated
	 */
	public Adapter createJavaWorkflowMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaStatement <em>Java Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaStatement
	 * @generated
	 */
	public Adapter createJavaStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaUnknownStatement <em>Java Unknown Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaUnknownStatement
	 * @generated
	 */
	public Adapter createJavaUnknownStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaExpression <em>Java Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaExpression
	 * @generated
	 */
	public Adapter createJavaExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaMethodInvocation <em>Java Method Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaMethodInvocation
	 * @generated
	 */
	public Adapter createJavaMethodInvocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaAssignment <em>Java Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaAssignment
	 * @generated
	 */
	public Adapter createJavaAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaLiteral <em>Java Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaLiteral
	 * @generated
	 */
	public Adapter createJavaLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaName <em>Java Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaName
	 * @generated
	 */
	public Adapter createJavaNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SimpleJava.JavaArrayInit <em>Java Array Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SimpleJava.JavaArrayInit
	 * @generated
	 */
	public Adapter createJavaArrayInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SimpleJavaAdapterFactory
