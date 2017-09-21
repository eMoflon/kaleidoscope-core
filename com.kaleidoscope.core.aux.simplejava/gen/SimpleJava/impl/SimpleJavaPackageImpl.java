/**
 */
package SimpleJava.impl;

import SimpleJava.JavaArrayInit;
import SimpleJava.JavaAssignment;
import SimpleJava.JavaCompilationUnit;
import SimpleJava.JavaExpression;
import SimpleJava.JavaImport;
import SimpleJava.JavaLiteral;
import SimpleJava.JavaMethod;
import SimpleJava.JavaMethodInvocation;
import SimpleJava.JavaName;
import SimpleJava.JavaOpaqueMethod;
import SimpleJava.JavaPackage;
import SimpleJava.JavaStatement;
import SimpleJava.JavaUnknownStatement;
import SimpleJava.JavaVariableDeclaration;
import SimpleJava.JavaWorkflowMethod;
import SimpleJava.SimpleJavaFactory;
import SimpleJava.SimpleJavaPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleJavaPackageImpl extends EPackageImpl implements SimpleJavaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaCompilationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaOpaqueMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaWorkflowMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaUnknownStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaMethodInvocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaArrayInitEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see SimpleJava.SimpleJavaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimpleJavaPackageImpl() {
		super(eNS_URI, SimpleJavaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SimpleJavaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SimpleJavaPackage init() {
		if (isInited)
			return (SimpleJavaPackage) EPackage.Registry.INSTANCE.getEPackage(SimpleJavaPackage.eNS_URI);

		// Obtain or create and register package
		SimpleJavaPackageImpl theSimpleJavaPackage = (SimpleJavaPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof SimpleJavaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new SimpleJavaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSimpleJavaPackage.createPackageContents();

		// Initialize created meta-data
		theSimpleJavaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimpleJavaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SimpleJavaPackage.eNS_URI, theSimpleJavaPackage);
		return theSimpleJavaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaPackage() {
		return javaPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaPackage_Cunits() {
		return (EReference) javaPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaPackage_Name() {
		return (EAttribute) javaPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaCompilationUnit() {
		return javaCompilationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaCompilationUnit_Name() {
		return (EAttribute) javaCompilationUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaCompilationUnit_Imports() {
		return (EReference) javaCompilationUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaCompilationUnit_Methods() {
		return (EReference) javaCompilationUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaCompilationUnit_FieldDeclarations() {
		return (EAttribute) javaCompilationUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaImport() {
		return javaImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaImport_Value() {
		return (EAttribute) javaImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaImport_Index() {
		return (EAttribute) javaImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaMethod() {
		return javaMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_Name() {
		return (EAttribute) javaMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_Type() {
		return (EAttribute) javaMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_Modifier() {
		return (EAttribute) javaMethodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_Throws() {
		return (EAttribute) javaMethodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaMethod_Params() {
		return (EReference) javaMethodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethod_Index() {
		return (EAttribute) javaMethodEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaVariableDeclaration() {
		return javaVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaVariableDeclaration_Type() {
		return (EAttribute) javaVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaVariableDeclaration_Name() {
		return (EAttribute) javaVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaOpaqueMethod() {
		return javaOpaqueMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaOpaqueMethod_Body() {
		return (EAttribute) javaOpaqueMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaOpaqueMethod_Parameters() {
		return (EAttribute) javaOpaqueMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaWorkflowMethod() {
		return javaWorkflowMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaWorkflowMethod_Statements() {
		return (EReference) javaWorkflowMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaStatement() {
		return javaStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaStatement_Next() {
		return (EReference) javaStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaStatement_Prev() {
		return (EReference) javaStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaStatement_Expr() {
		return (EReference) javaStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaStatement_Return() {
		return (EAttribute) javaStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaUnknownStatement() {
		return javaUnknownStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaUnknownStatement_Body() {
		return (EAttribute) javaUnknownStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaExpression() {
		return javaExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaExpression_Index() {
		return (EAttribute) javaExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaMethodInvocation() {
		return javaMethodInvocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaMethodInvocation_Arguments() {
		return (EReference) javaMethodInvocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethodInvocation_Name() {
		return (EAttribute) javaMethodInvocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaMethodInvocation_Initialization() {
		return (EAttribute) javaMethodInvocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaMethodInvocation_OptionalExpression() {
		return (EReference) javaMethodInvocationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaAssignment() {
		return javaAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaAssignment_Rhs() {
		return (EReference) javaAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJavaAssignment_Lhs() {
		return (EReference) javaAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaLiteral() {
		return javaLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaLiteral_Value() {
		return (EAttribute) javaLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaName() {
		return javaNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaName_Identifier() {
		return (EAttribute) javaNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJavaArrayInit() {
		return javaArrayInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaArrayInit_Dimension() {
		return (EAttribute) javaArrayInitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJavaArrayInit_Type() {
		return (EAttribute) javaArrayInitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleJavaFactory getSimpleJavaFactory() {
		return (SimpleJavaFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		javaPackageEClass = createEClass(JAVA_PACKAGE);
		createEReference(javaPackageEClass, JAVA_PACKAGE__CUNITS);
		createEAttribute(javaPackageEClass, JAVA_PACKAGE__NAME);

		javaCompilationUnitEClass = createEClass(JAVA_COMPILATION_UNIT);
		createEAttribute(javaCompilationUnitEClass, JAVA_COMPILATION_UNIT__NAME);
		createEReference(javaCompilationUnitEClass, JAVA_COMPILATION_UNIT__IMPORTS);
		createEReference(javaCompilationUnitEClass, JAVA_COMPILATION_UNIT__METHODS);
		createEAttribute(javaCompilationUnitEClass, JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS);

		javaImportEClass = createEClass(JAVA_IMPORT);
		createEAttribute(javaImportEClass, JAVA_IMPORT__VALUE);
		createEAttribute(javaImportEClass, JAVA_IMPORT__INDEX);

		javaMethodEClass = createEClass(JAVA_METHOD);
		createEAttribute(javaMethodEClass, JAVA_METHOD__NAME);
		createEAttribute(javaMethodEClass, JAVA_METHOD__TYPE);
		createEAttribute(javaMethodEClass, JAVA_METHOD__MODIFIER);
		createEAttribute(javaMethodEClass, JAVA_METHOD__THROWS);
		createEReference(javaMethodEClass, JAVA_METHOD__PARAMS);
		createEAttribute(javaMethodEClass, JAVA_METHOD__INDEX);

		javaVariableDeclarationEClass = createEClass(JAVA_VARIABLE_DECLARATION);
		createEAttribute(javaVariableDeclarationEClass, JAVA_VARIABLE_DECLARATION__TYPE);
		createEAttribute(javaVariableDeclarationEClass, JAVA_VARIABLE_DECLARATION__NAME);

		javaOpaqueMethodEClass = createEClass(JAVA_OPAQUE_METHOD);
		createEAttribute(javaOpaqueMethodEClass, JAVA_OPAQUE_METHOD__BODY);
		createEAttribute(javaOpaqueMethodEClass, JAVA_OPAQUE_METHOD__PARAMETERS);

		javaWorkflowMethodEClass = createEClass(JAVA_WORKFLOW_METHOD);
		createEReference(javaWorkflowMethodEClass, JAVA_WORKFLOW_METHOD__STATEMENTS);

		javaStatementEClass = createEClass(JAVA_STATEMENT);
		createEReference(javaStatementEClass, JAVA_STATEMENT__NEXT);
		createEReference(javaStatementEClass, JAVA_STATEMENT__PREV);
		createEReference(javaStatementEClass, JAVA_STATEMENT__EXPR);
		createEAttribute(javaStatementEClass, JAVA_STATEMENT__RETURN);

		javaUnknownStatementEClass = createEClass(JAVA_UNKNOWN_STATEMENT);
		createEAttribute(javaUnknownStatementEClass, JAVA_UNKNOWN_STATEMENT__BODY);

		javaExpressionEClass = createEClass(JAVA_EXPRESSION);
		createEAttribute(javaExpressionEClass, JAVA_EXPRESSION__INDEX);

		javaMethodInvocationEClass = createEClass(JAVA_METHOD_INVOCATION);
		createEReference(javaMethodInvocationEClass, JAVA_METHOD_INVOCATION__ARGUMENTS);
		createEAttribute(javaMethodInvocationEClass, JAVA_METHOD_INVOCATION__NAME);
		createEAttribute(javaMethodInvocationEClass, JAVA_METHOD_INVOCATION__INITIALIZATION);
		createEReference(javaMethodInvocationEClass, JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION);

		javaAssignmentEClass = createEClass(JAVA_ASSIGNMENT);
		createEReference(javaAssignmentEClass, JAVA_ASSIGNMENT__RHS);
		createEReference(javaAssignmentEClass, JAVA_ASSIGNMENT__LHS);

		javaLiteralEClass = createEClass(JAVA_LITERAL);
		createEAttribute(javaLiteralEClass, JAVA_LITERAL__VALUE);

		javaNameEClass = createEClass(JAVA_NAME);
		createEAttribute(javaNameEClass, JAVA_NAME__IDENTIFIER);

		javaArrayInitEClass = createEClass(JAVA_ARRAY_INIT);
		createEAttribute(javaArrayInitEClass, JAVA_ARRAY_INIT__DIMENSION);
		createEAttribute(javaArrayInitEClass, JAVA_ARRAY_INIT__TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		javaVariableDeclarationEClass.getESuperTypes().add(this.getJavaExpression());
		javaOpaqueMethodEClass.getESuperTypes().add(this.getJavaMethod());
		javaWorkflowMethodEClass.getESuperTypes().add(this.getJavaMethod());
		javaUnknownStatementEClass.getESuperTypes().add(this.getJavaStatement());
		javaMethodInvocationEClass.getESuperTypes().add(this.getJavaExpression());
		javaAssignmentEClass.getESuperTypes().add(this.getJavaExpression());
		javaLiteralEClass.getESuperTypes().add(this.getJavaExpression());
		javaNameEClass.getESuperTypes().add(this.getJavaExpression());
		javaArrayInitEClass.getESuperTypes().add(this.getJavaExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(javaPackageEClass, JavaPackage.class, "JavaPackage", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaPackage_Cunits(), this.getJavaCompilationUnit(), null, "cunits", null, 0, -1,
				JavaPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getJavaPackage_Name(), ecorePackage.getEString(), "name", null, 0, 1, JavaPackage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaCompilationUnitEClass, JavaCompilationUnit.class, "JavaCompilationUnit", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaCompilationUnit_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				JavaCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaCompilationUnit_Imports(), this.getJavaImport(), null, "imports", null, 0, -1,
				JavaCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaCompilationUnit_Methods(), this.getJavaMethod(), null, "methods", null, 0, -1,
				JavaCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaCompilationUnit_FieldDeclarations(), ecorePackage.getEString(), "fieldDeclarations", "",
				0, 1, JavaCompilationUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaImportEClass, JavaImport.class, "JavaImport", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaImport_Value(), ecorePackage.getEString(), "value", null, 0, 1, JavaImport.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaImport_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1, JavaImport.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaMethodEClass, JavaMethod.class, "JavaMethod", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaMethod_Name(), ecorePackage.getEString(), "name", null, 0, 1, JavaMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethod_Type(), ecorePackage.getEString(), "type", null, 0, 1, JavaMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethod_Modifier(), ecorePackage.getEString(), "modifier", null, 0, 1, JavaMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethod_Throws(), ecorePackage.getEString(), "throws", null, 0, 1, JavaMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaMethod_Params(), this.getJavaVariableDeclaration(), null, "params", null, 0, -1,
				JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethod_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1, JavaMethod.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaVariableDeclarationEClass, JavaVariableDeclaration.class, "JavaVariableDeclaration",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaVariableDeclaration_Type(), ecorePackage.getEString(), "type", null, 0, 1,
				JavaVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				JavaVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaOpaqueMethodEClass, JavaOpaqueMethod.class, "JavaOpaqueMethod", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaOpaqueMethod_Body(), ecorePackage.getEString(), "body", null, 0, 1,
				JavaOpaqueMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaOpaqueMethod_Parameters(), ecorePackage.getEString(), "parameters", null, 0, 1,
				JavaOpaqueMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(javaWorkflowMethodEClass, JavaWorkflowMethod.class, "JavaWorkflowMethod", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaWorkflowMethod_Statements(), this.getJavaStatement(), null, "statements", null, 0, -1,
				JavaWorkflowMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaStatementEClass, JavaStatement.class, "JavaStatement", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaStatement_Next(), this.getJavaStatement(), null, "next", null, 0, 1, JavaStatement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaStatement_Prev(), this.getJavaStatement(), null, "prev", null, 0, 1, JavaStatement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaStatement_Expr(), this.getJavaExpression(), null, "expr", null, 1, 1, JavaStatement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaStatement_Return(), ecorePackage.getEBoolean(), "return", null, 0, 1, JavaStatement.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaUnknownStatementEClass, JavaUnknownStatement.class, "JavaUnknownStatement", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaUnknownStatement_Body(), ecorePackage.getEString(), "body", null, 0, 1,
				JavaUnknownStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaExpressionEClass, JavaExpression.class, "JavaExpression", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaExpression_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1, JavaExpression.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaMethodInvocationEClass, JavaMethodInvocation.class, "JavaMethodInvocation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaMethodInvocation_Arguments(), this.getJavaExpression(), null, "arguments", null, 0, -1,
				JavaMethodInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethodInvocation_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				JavaMethodInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaMethodInvocation_Initialization(), ecorePackage.getEBoolean(), "initialization", null, 0,
				1, JavaMethodInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaMethodInvocation_OptionalExpression(), this.getJavaExpression(), null,
				"optionalExpression", null, 0, 1, JavaMethodInvocation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaAssignmentEClass, JavaAssignment.class, "JavaAssignment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaAssignment_Rhs(), this.getJavaExpression(), null, "rhs", null, 1, 1, JavaAssignment.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaAssignment_Lhs(), this.getJavaExpression(), null, "lhs", null, 1, 1, JavaAssignment.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaLiteralEClass, JavaLiteral.class, "JavaLiteral", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, JavaLiteral.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaNameEClass, JavaName.class, "JavaName", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaName_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, JavaName.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(javaArrayInitEClass, JavaArrayInit.class, "JavaArrayInit", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJavaArrayInit_Dimension(), ecorePackage.getEString(), "dimension", null, 0, 1,
				JavaArrayInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getJavaArrayInit_Type(), ecorePackage.getEString(), "type", null, 0, 1, JavaArrayInit.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SimpleJavaPackageImpl
