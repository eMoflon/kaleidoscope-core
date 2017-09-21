/**
 */
package SimpleJava;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SimpleJava.SimpleJavaFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleJavaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SimpleJava";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/plugin/com.kaleidoscope.core.aux.simplejava/model/SimpleJava.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SimpleJava";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimpleJavaPackage eINSTANCE = SimpleJava.impl.SimpleJavaPackageImpl.init();

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaPackageImpl <em>Java Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaPackageImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaPackage()
	 * @generated
	 */
	int JAVA_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Cunits</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE__CUNITS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Java Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Java Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_PACKAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaCompilationUnitImpl <em>Java Compilation Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaCompilationUnitImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaCompilationUnit()
	 * @generated
	 */
	int JAVA_COMPILATION_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT__IMPORTS = 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT__METHODS = 2;

	/**
	 * The feature id for the '<em><b>Field Declarations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS = 3;

	/**
	 * The number of structural features of the '<em>Java Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Java Compilation Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_COMPILATION_UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaImportImpl <em>Java Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaImportImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaImport()
	 * @generated
	 */
	int JAVA_IMPORT = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPORT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPORT__INDEX = 1;

	/**
	 * The number of structural features of the '<em>Java Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Java Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_IMPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaMethodImpl <em>Java Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaMethodImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaMethod()
	 * @generated
	 */
	int JAVA_METHOD = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__MODIFIER = 2;

	/**
	 * The feature id for the '<em><b>Throws</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__THROWS = 3;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__PARAMS = 4;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD__INDEX = 5;

	/**
	 * The number of structural features of the '<em>Java Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Java Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaExpressionImpl <em>Java Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaExpressionImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaExpression()
	 * @generated
	 */
	int JAVA_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXPRESSION__INDEX = 0;

	/**
	 * The number of structural features of the '<em>Java Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXPRESSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Java Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaVariableDeclarationImpl <em>Java Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaVariableDeclarationImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaVariableDeclaration()
	 * @generated
	 */
	int JAVA_VARIABLE_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_DECLARATION__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_DECLARATION__TYPE = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_DECLARATION__NAME = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_DECLARATION_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Java Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_DECLARATION_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaOpaqueMethodImpl <em>Java Opaque Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaOpaqueMethodImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaOpaqueMethod()
	 * @generated
	 */
	int JAVA_OPAQUE_METHOD = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__NAME = JAVA_METHOD__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__TYPE = JAVA_METHOD__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__MODIFIER = JAVA_METHOD__MODIFIER;

	/**
	 * The feature id for the '<em><b>Throws</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__THROWS = JAVA_METHOD__THROWS;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__PARAMS = JAVA_METHOD__PARAMS;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__INDEX = JAVA_METHOD__INDEX;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__BODY = JAVA_METHOD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD__PARAMETERS = JAVA_METHOD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Opaque Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD_FEATURE_COUNT = JAVA_METHOD_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Java Opaque Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_OPAQUE_METHOD_OPERATION_COUNT = JAVA_METHOD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaWorkflowMethodImpl <em>Java Workflow Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaWorkflowMethodImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaWorkflowMethod()
	 * @generated
	 */
	int JAVA_WORKFLOW_METHOD = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__NAME = JAVA_METHOD__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__TYPE = JAVA_METHOD__TYPE;

	/**
	 * The feature id for the '<em><b>Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__MODIFIER = JAVA_METHOD__MODIFIER;

	/**
	 * The feature id for the '<em><b>Throws</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__THROWS = JAVA_METHOD__THROWS;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__PARAMS = JAVA_METHOD__PARAMS;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__INDEX = JAVA_METHOD__INDEX;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD__STATEMENTS = JAVA_METHOD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Workflow Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD_FEATURE_COUNT = JAVA_METHOD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Workflow Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_WORKFLOW_METHOD_OPERATION_COUNT = JAVA_METHOD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaStatementImpl <em>Java Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaStatementImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaStatement()
	 * @generated
	 */
	int JAVA_STATEMENT = 7;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT__NEXT = 0;

	/**
	 * The feature id for the '<em><b>Prev</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT__PREV = 1;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT__EXPR = 2;

	/**
	 * The feature id for the '<em><b>Return</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT__RETURN = 3;

	/**
	 * The number of structural features of the '<em>Java Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Java Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaUnknownStatementImpl <em>Java Unknown Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaUnknownStatementImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaUnknownStatement()
	 * @generated
	 */
	int JAVA_UNKNOWN_STATEMENT = 8;

	/**
	 * The feature id for the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT__NEXT = JAVA_STATEMENT__NEXT;

	/**
	 * The feature id for the '<em><b>Prev</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT__PREV = JAVA_STATEMENT__PREV;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT__EXPR = JAVA_STATEMENT__EXPR;

	/**
	 * The feature id for the '<em><b>Return</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT__RETURN = JAVA_STATEMENT__RETURN;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT__BODY = JAVA_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Unknown Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT_FEATURE_COUNT = JAVA_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Unknown Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_UNKNOWN_STATEMENT_OPERATION_COUNT = JAVA_STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaMethodInvocationImpl <em>Java Method Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaMethodInvocationImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaMethodInvocation()
	 * @generated
	 */
	int JAVA_METHOD_INVOCATION = 10;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION__ARGUMENTS = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION__NAME = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION__INITIALIZATION = JAVA_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Optional Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION = JAVA_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Java Method Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Java Method Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_METHOD_INVOCATION_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaAssignmentImpl <em>Java Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaAssignmentImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaAssignment()
	 * @generated
	 */
	int JAVA_ASSIGNMENT = 11;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ASSIGNMENT__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ASSIGNMENT__RHS = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ASSIGNMENT__LHS = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ASSIGNMENT_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Java Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ASSIGNMENT_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaLiteralImpl <em>Java Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaLiteralImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaLiteral()
	 * @generated
	 */
	int JAVA_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LITERAL__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LITERAL__VALUE = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LITERAL_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LITERAL_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaNameImpl <em>Java Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaNameImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaName()
	 * @generated
	 */
	int JAVA_NAME = 13;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAME__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAME__IDENTIFIER = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAME_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Java Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NAME_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link SimpleJava.impl.JavaArrayInitImpl <em>Java Array Init</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SimpleJava.impl.JavaArrayInitImpl
	 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaArrayInit()
	 * @generated
	 */
	int JAVA_ARRAY_INIT = 14;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ARRAY_INIT__INDEX = JAVA_EXPRESSION__INDEX;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ARRAY_INIT__DIMENSION = JAVA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ARRAY_INIT__TYPE = JAVA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Array Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ARRAY_INIT_FEATURE_COUNT = JAVA_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Java Array Init</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ARRAY_INIT_OPERATION_COUNT = JAVA_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaPackage <em>Java Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Package</em>'.
	 * @see SimpleJava.JavaPackage
	 * @generated
	 */
	EClass getJavaPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaPackage#getCunits <em>Cunits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cunits</em>'.
	 * @see SimpleJava.JavaPackage#getCunits()
	 * @see #getJavaPackage()
	 * @generated
	 */
	EReference getJavaPackage_Cunits();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaPackage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimpleJava.JavaPackage#getName()
	 * @see #getJavaPackage()
	 * @generated
	 */
	EAttribute getJavaPackage_Name();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaCompilationUnit <em>Java Compilation Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Compilation Unit</em>'.
	 * @see SimpleJava.JavaCompilationUnit
	 * @generated
	 */
	EClass getJavaCompilationUnit();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaCompilationUnit#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimpleJava.JavaCompilationUnit#getName()
	 * @see #getJavaCompilationUnit()
	 * @generated
	 */
	EAttribute getJavaCompilationUnit_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaCompilationUnit#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see SimpleJava.JavaCompilationUnit#getImports()
	 * @see #getJavaCompilationUnit()
	 * @generated
	 */
	EReference getJavaCompilationUnit_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaCompilationUnit#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see SimpleJava.JavaCompilationUnit#getMethods()
	 * @see #getJavaCompilationUnit()
	 * @generated
	 */
	EReference getJavaCompilationUnit_Methods();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaCompilationUnit#getFieldDeclarations <em>Field Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Declarations</em>'.
	 * @see SimpleJava.JavaCompilationUnit#getFieldDeclarations()
	 * @see #getJavaCompilationUnit()
	 * @generated
	 */
	EAttribute getJavaCompilationUnit_FieldDeclarations();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaImport <em>Java Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Import</em>'.
	 * @see SimpleJava.JavaImport
	 * @generated
	 */
	EClass getJavaImport();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaImport#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see SimpleJava.JavaImport#getValue()
	 * @see #getJavaImport()
	 * @generated
	 */
	EAttribute getJavaImport_Value();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaImport#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see SimpleJava.JavaImport#getIndex()
	 * @see #getJavaImport()
	 * @generated
	 */
	EAttribute getJavaImport_Index();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaMethod <em>Java Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Method</em>'.
	 * @see SimpleJava.JavaMethod
	 * @generated
	 */
	EClass getJavaMethod();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethod#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimpleJava.JavaMethod#getName()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_Name();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethod#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see SimpleJava.JavaMethod#getType()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_Type();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethod#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modifier</em>'.
	 * @see SimpleJava.JavaMethod#getModifier()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_Modifier();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethod#getThrows <em>Throws</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Throws</em>'.
	 * @see SimpleJava.JavaMethod#getThrows()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_Throws();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaMethod#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see SimpleJava.JavaMethod#getParams()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EReference getJavaMethod_Params();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethod#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see SimpleJava.JavaMethod#getIndex()
	 * @see #getJavaMethod()
	 * @generated
	 */
	EAttribute getJavaMethod_Index();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaVariableDeclaration <em>Java Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Variable Declaration</em>'.
	 * @see SimpleJava.JavaVariableDeclaration
	 * @generated
	 */
	EClass getJavaVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaVariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see SimpleJava.JavaVariableDeclaration#getType()
	 * @see #getJavaVariableDeclaration()
	 * @generated
	 */
	EAttribute getJavaVariableDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimpleJava.JavaVariableDeclaration#getName()
	 * @see #getJavaVariableDeclaration()
	 * @generated
	 */
	EAttribute getJavaVariableDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaOpaqueMethod <em>Java Opaque Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Opaque Method</em>'.
	 * @see SimpleJava.JavaOpaqueMethod
	 * @generated
	 */
	EClass getJavaOpaqueMethod();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaOpaqueMethod#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see SimpleJava.JavaOpaqueMethod#getBody()
	 * @see #getJavaOpaqueMethod()
	 * @generated
	 */
	EAttribute getJavaOpaqueMethod_Body();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaOpaqueMethod#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameters</em>'.
	 * @see SimpleJava.JavaOpaqueMethod#getParameters()
	 * @see #getJavaOpaqueMethod()
	 * @generated
	 */
	EAttribute getJavaOpaqueMethod_Parameters();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaWorkflowMethod <em>Java Workflow Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Workflow Method</em>'.
	 * @see SimpleJava.JavaWorkflowMethod
	 * @generated
	 */
	EClass getJavaWorkflowMethod();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaWorkflowMethod#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see SimpleJava.JavaWorkflowMethod#getStatements()
	 * @see #getJavaWorkflowMethod()
	 * @generated
	 */
	EReference getJavaWorkflowMethod_Statements();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaStatement <em>Java Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Statement</em>'.
	 * @see SimpleJava.JavaStatement
	 * @generated
	 */
	EClass getJavaStatement();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaStatement#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next</em>'.
	 * @see SimpleJava.JavaStatement#getNext()
	 * @see #getJavaStatement()
	 * @generated
	 */
	EReference getJavaStatement_Next();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaStatement#getPrev <em>Prev</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prev</em>'.
	 * @see SimpleJava.JavaStatement#getPrev()
	 * @see #getJavaStatement()
	 * @generated
	 */
	EReference getJavaStatement_Prev();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaStatement#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see SimpleJava.JavaStatement#getExpr()
	 * @see #getJavaStatement()
	 * @generated
	 */
	EReference getJavaStatement_Expr();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaStatement#isReturn <em>Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return</em>'.
	 * @see SimpleJava.JavaStatement#isReturn()
	 * @see #getJavaStatement()
	 * @generated
	 */
	EAttribute getJavaStatement_Return();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaUnknownStatement <em>Java Unknown Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Unknown Statement</em>'.
	 * @see SimpleJava.JavaUnknownStatement
	 * @generated
	 */
	EClass getJavaUnknownStatement();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaUnknownStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see SimpleJava.JavaUnknownStatement#getBody()
	 * @see #getJavaUnknownStatement()
	 * @generated
	 */
	EAttribute getJavaUnknownStatement_Body();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaExpression <em>Java Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Expression</em>'.
	 * @see SimpleJava.JavaExpression
	 * @generated
	 */
	EClass getJavaExpression();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaExpression#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see SimpleJava.JavaExpression#getIndex()
	 * @see #getJavaExpression()
	 * @generated
	 */
	EAttribute getJavaExpression_Index();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaMethodInvocation <em>Java Method Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Method Invocation</em>'.
	 * @see SimpleJava.JavaMethodInvocation
	 * @generated
	 */
	EClass getJavaMethodInvocation();

	/**
	 * Returns the meta object for the containment reference list '{@link SimpleJava.JavaMethodInvocation#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see SimpleJava.JavaMethodInvocation#getArguments()
	 * @see #getJavaMethodInvocation()
	 * @generated
	 */
	EReference getJavaMethodInvocation_Arguments();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethodInvocation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SimpleJava.JavaMethodInvocation#getName()
	 * @see #getJavaMethodInvocation()
	 * @generated
	 */
	EAttribute getJavaMethodInvocation_Name();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaMethodInvocation#isInitialization <em>Initialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initialization</em>'.
	 * @see SimpleJava.JavaMethodInvocation#isInitialization()
	 * @see #getJavaMethodInvocation()
	 * @generated
	 */
	EAttribute getJavaMethodInvocation_Initialization();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaMethodInvocation#getOptionalExpression <em>Optional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Optional Expression</em>'.
	 * @see SimpleJava.JavaMethodInvocation#getOptionalExpression()
	 * @see #getJavaMethodInvocation()
	 * @generated
	 */
	EReference getJavaMethodInvocation_OptionalExpression();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaAssignment <em>Java Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Assignment</em>'.
	 * @see SimpleJava.JavaAssignment
	 * @generated
	 */
	EClass getJavaAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaAssignment#getRhs <em>Rhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rhs</em>'.
	 * @see SimpleJava.JavaAssignment#getRhs()
	 * @see #getJavaAssignment()
	 * @generated
	 */
	EReference getJavaAssignment_Rhs();

	/**
	 * Returns the meta object for the containment reference '{@link SimpleJava.JavaAssignment#getLhs <em>Lhs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lhs</em>'.
	 * @see SimpleJava.JavaAssignment#getLhs()
	 * @see #getJavaAssignment()
	 * @generated
	 */
	EReference getJavaAssignment_Lhs();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaLiteral <em>Java Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Literal</em>'.
	 * @see SimpleJava.JavaLiteral
	 * @generated
	 */
	EClass getJavaLiteral();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see SimpleJava.JavaLiteral#getValue()
	 * @see #getJavaLiteral()
	 * @generated
	 */
	EAttribute getJavaLiteral_Value();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaName <em>Java Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Name</em>'.
	 * @see SimpleJava.JavaName
	 * @generated
	 */
	EClass getJavaName();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaName#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see SimpleJava.JavaName#getIdentifier()
	 * @see #getJavaName()
	 * @generated
	 */
	EAttribute getJavaName_Identifier();

	/**
	 * Returns the meta object for class '{@link SimpleJava.JavaArrayInit <em>Java Array Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Array Init</em>'.
	 * @see SimpleJava.JavaArrayInit
	 * @generated
	 */
	EClass getJavaArrayInit();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaArrayInit#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see SimpleJava.JavaArrayInit#getDimension()
	 * @see #getJavaArrayInit()
	 * @generated
	 */
	EAttribute getJavaArrayInit_Dimension();

	/**
	 * Returns the meta object for the attribute '{@link SimpleJava.JavaArrayInit#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see SimpleJava.JavaArrayInit#getType()
	 * @see #getJavaArrayInit()
	 * @generated
	 */
	EAttribute getJavaArrayInit_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimpleJavaFactory getSimpleJavaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaPackageImpl <em>Java Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaPackageImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaPackage()
		 * @generated
		 */
		EClass JAVA_PACKAGE = eINSTANCE.getJavaPackage();

		/**
		 * The meta object literal for the '<em><b>Cunits</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_PACKAGE__CUNITS = eINSTANCE.getJavaPackage_Cunits();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_PACKAGE__NAME = eINSTANCE.getJavaPackage_Name();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaCompilationUnitImpl <em>Java Compilation Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaCompilationUnitImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaCompilationUnit()
		 * @generated
		 */
		EClass JAVA_COMPILATION_UNIT = eINSTANCE.getJavaCompilationUnit();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_COMPILATION_UNIT__NAME = eINSTANCE.getJavaCompilationUnit_Name();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_COMPILATION_UNIT__IMPORTS = eINSTANCE.getJavaCompilationUnit_Imports();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_COMPILATION_UNIT__METHODS = eINSTANCE.getJavaCompilationUnit_Methods();

		/**
		 * The meta object literal for the '<em><b>Field Declarations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_COMPILATION_UNIT__FIELD_DECLARATIONS = eINSTANCE.getJavaCompilationUnit_FieldDeclarations();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaImportImpl <em>Java Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaImportImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaImport()
		 * @generated
		 */
		EClass JAVA_IMPORT = eINSTANCE.getJavaImport();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_IMPORT__VALUE = eINSTANCE.getJavaImport_Value();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_IMPORT__INDEX = eINSTANCE.getJavaImport_Index();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaMethodImpl <em>Java Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaMethodImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaMethod()
		 * @generated
		 */
		EClass JAVA_METHOD = eINSTANCE.getJavaMethod();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__NAME = eINSTANCE.getJavaMethod_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__TYPE = eINSTANCE.getJavaMethod_Type();

		/**
		 * The meta object literal for the '<em><b>Modifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__MODIFIER = eINSTANCE.getJavaMethod_Modifier();

		/**
		 * The meta object literal for the '<em><b>Throws</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__THROWS = eINSTANCE.getJavaMethod_Throws();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_METHOD__PARAMS = eINSTANCE.getJavaMethod_Params();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD__INDEX = eINSTANCE.getJavaMethod_Index();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaVariableDeclarationImpl <em>Java Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaVariableDeclarationImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaVariableDeclaration()
		 * @generated
		 */
		EClass JAVA_VARIABLE_DECLARATION = eINSTANCE.getJavaVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_VARIABLE_DECLARATION__TYPE = eINSTANCE.getJavaVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_VARIABLE_DECLARATION__NAME = eINSTANCE.getJavaVariableDeclaration_Name();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaOpaqueMethodImpl <em>Java Opaque Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaOpaqueMethodImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaOpaqueMethod()
		 * @generated
		 */
		EClass JAVA_OPAQUE_METHOD = eINSTANCE.getJavaOpaqueMethod();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_OPAQUE_METHOD__BODY = eINSTANCE.getJavaOpaqueMethod_Body();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_OPAQUE_METHOD__PARAMETERS = eINSTANCE.getJavaOpaqueMethod_Parameters();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaWorkflowMethodImpl <em>Java Workflow Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaWorkflowMethodImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaWorkflowMethod()
		 * @generated
		 */
		EClass JAVA_WORKFLOW_METHOD = eINSTANCE.getJavaWorkflowMethod();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_WORKFLOW_METHOD__STATEMENTS = eINSTANCE.getJavaWorkflowMethod_Statements();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaStatementImpl <em>Java Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaStatementImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaStatement()
		 * @generated
		 */
		EClass JAVA_STATEMENT = eINSTANCE.getJavaStatement();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_STATEMENT__NEXT = eINSTANCE.getJavaStatement_Next();

		/**
		 * The meta object literal for the '<em><b>Prev</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_STATEMENT__PREV = eINSTANCE.getJavaStatement_Prev();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_STATEMENT__EXPR = eINSTANCE.getJavaStatement_Expr();

		/**
		 * The meta object literal for the '<em><b>Return</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_STATEMENT__RETURN = eINSTANCE.getJavaStatement_Return();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaUnknownStatementImpl <em>Java Unknown Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaUnknownStatementImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaUnknownStatement()
		 * @generated
		 */
		EClass JAVA_UNKNOWN_STATEMENT = eINSTANCE.getJavaUnknownStatement();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_UNKNOWN_STATEMENT__BODY = eINSTANCE.getJavaUnknownStatement_Body();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaExpressionImpl <em>Java Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaExpressionImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaExpression()
		 * @generated
		 */
		EClass JAVA_EXPRESSION = eINSTANCE.getJavaExpression();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_EXPRESSION__INDEX = eINSTANCE.getJavaExpression_Index();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaMethodInvocationImpl <em>Java Method Invocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaMethodInvocationImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaMethodInvocation()
		 * @generated
		 */
		EClass JAVA_METHOD_INVOCATION = eINSTANCE.getJavaMethodInvocation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_METHOD_INVOCATION__ARGUMENTS = eINSTANCE.getJavaMethodInvocation_Arguments();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD_INVOCATION__NAME = eINSTANCE.getJavaMethodInvocation_Name();

		/**
		 * The meta object literal for the '<em><b>Initialization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_METHOD_INVOCATION__INITIALIZATION = eINSTANCE.getJavaMethodInvocation_Initialization();

		/**
		 * The meta object literal for the '<em><b>Optional Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_METHOD_INVOCATION__OPTIONAL_EXPRESSION = eINSTANCE.getJavaMethodInvocation_OptionalExpression();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaAssignmentImpl <em>Java Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaAssignmentImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaAssignment()
		 * @generated
		 */
		EClass JAVA_ASSIGNMENT = eINSTANCE.getJavaAssignment();

		/**
		 * The meta object literal for the '<em><b>Rhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_ASSIGNMENT__RHS = eINSTANCE.getJavaAssignment_Rhs();

		/**
		 * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_ASSIGNMENT__LHS = eINSTANCE.getJavaAssignment_Lhs();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaLiteralImpl <em>Java Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaLiteralImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaLiteral()
		 * @generated
		 */
		EClass JAVA_LITERAL = eINSTANCE.getJavaLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_LITERAL__VALUE = eINSTANCE.getJavaLiteral_Value();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaNameImpl <em>Java Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaNameImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaName()
		 * @generated
		 */
		EClass JAVA_NAME = eINSTANCE.getJavaName();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NAME__IDENTIFIER = eINSTANCE.getJavaName_Identifier();

		/**
		 * The meta object literal for the '{@link SimpleJava.impl.JavaArrayInitImpl <em>Java Array Init</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SimpleJava.impl.JavaArrayInitImpl
		 * @see SimpleJava.impl.SimpleJavaPackageImpl#getJavaArrayInit()
		 * @generated
		 */
		EClass JAVA_ARRAY_INIT = eINSTANCE.getJavaArrayInit();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_ARRAY_INIT__DIMENSION = eINSTANCE.getJavaArrayInit_Dimension();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_ARRAY_INIT__TYPE = eINSTANCE.getJavaArrayInit_Type();

	}

} //SimpleJavaPackage
