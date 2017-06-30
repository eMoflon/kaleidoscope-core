/**
 */
package SimpleJava.impl;

import SimpleJava.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleJavaFactoryImpl extends EFactoryImpl implements SimpleJavaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimpleJavaFactory init() {
		try {
			SimpleJavaFactory theSimpleJavaFactory = (SimpleJavaFactory)EPackage.Registry.INSTANCE.getEFactory(SimpleJavaPackage.eNS_URI);
			if (theSimpleJavaFactory != null) {
				return theSimpleJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimpleJavaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimpleJavaPackage.JAVA_PACKAGE: return createJavaPackage();
			case SimpleJavaPackage.JAVA_COMPILATION_UNIT: return createJavaCompilationUnit();
			case SimpleJavaPackage.JAVA_IMPORT: return createJavaImport();
			case SimpleJavaPackage.JAVA_METHOD: return createJavaMethod();
			case SimpleJavaPackage.JAVA_VARIABLE_DECLARATION: return createJavaVariableDeclaration();
			case SimpleJavaPackage.JAVA_OPAQUE_METHOD: return createJavaOpaqueMethod();
			case SimpleJavaPackage.JAVA_WORKFLOW_METHOD: return createJavaWorkflowMethod();
			case SimpleJavaPackage.JAVA_STATEMENT: return createJavaStatement();
			case SimpleJavaPackage.JAVA_UNKNOWN_STATEMENT: return createJavaUnknownStatement();
			case SimpleJavaPackage.JAVA_EXPRESSION: return createJavaExpression();
			case SimpleJavaPackage.JAVA_METHOD_INVOCATION: return createJavaMethodInvocation();
			case SimpleJavaPackage.JAVA_ASSIGNMENT: return createJavaAssignment();
			case SimpleJavaPackage.JAVA_LITERAL: return createJavaLiteral();
			case SimpleJavaPackage.JAVA_NAME: return createJavaName();
			case SimpleJavaPackage.JAVA_ARRAY_INIT: return createJavaArrayInit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage createJavaPackage() {
		JavaPackageImpl javaPackage = new JavaPackageImpl();
		return javaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaCompilationUnit createJavaCompilationUnit() {
		JavaCompilationUnitImpl javaCompilationUnit = new JavaCompilationUnitImpl();
		return javaCompilationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaImport createJavaImport() {
		JavaImportImpl javaImport = new JavaImportImpl();
		return javaImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaMethod createJavaMethod() {
		JavaMethodImpl javaMethod = new JavaMethodImpl();
		return javaMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaVariableDeclaration createJavaVariableDeclaration() {
		JavaVariableDeclarationImpl javaVariableDeclaration = new JavaVariableDeclarationImpl();
		return javaVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaOpaqueMethod createJavaOpaqueMethod() {
		JavaOpaqueMethodImpl javaOpaqueMethod = new JavaOpaqueMethodImpl();
		return javaOpaqueMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaWorkflowMethod createJavaWorkflowMethod() {
		JavaWorkflowMethodImpl javaWorkflowMethod = new JavaWorkflowMethodImpl();
		return javaWorkflowMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaStatement createJavaStatement() {
		JavaStatementImpl javaStatement = new JavaStatementImpl();
		return javaStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaUnknownStatement createJavaUnknownStatement() {
		JavaUnknownStatementImpl javaUnknownStatement = new JavaUnknownStatementImpl();
		return javaUnknownStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaExpression createJavaExpression() {
		JavaExpressionImpl javaExpression = new JavaExpressionImpl();
		return javaExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaMethodInvocation createJavaMethodInvocation() {
		JavaMethodInvocationImpl javaMethodInvocation = new JavaMethodInvocationImpl();
		return javaMethodInvocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaAssignment createJavaAssignment() {
		JavaAssignmentImpl javaAssignment = new JavaAssignmentImpl();
		return javaAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaLiteral createJavaLiteral() {
		JavaLiteralImpl javaLiteral = new JavaLiteralImpl();
		return javaLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaName createJavaName() {
		JavaNameImpl javaName = new JavaNameImpl();
		return javaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaArrayInit createJavaArrayInit() {
		JavaArrayInitImpl javaArrayInit = new JavaArrayInitImpl();
		return javaArrayInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaPackage getSimpleJavaPackage() {
		return (SimpleJavaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimpleJavaPackage getPackage() {
		return SimpleJavaPackage.eINSTANCE;
	}

} //SimpleJavaFactoryImpl
