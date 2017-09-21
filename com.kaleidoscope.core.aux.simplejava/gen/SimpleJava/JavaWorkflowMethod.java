/**
 */
package SimpleJava;

import org.eclipse.emf.common.util.EList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Workflow Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaWorkflowMethod#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaWorkflowMethod()
 * @model
 * @generated
 */
public interface JavaWorkflowMethod extends JavaMethod {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link SimpleJava.JavaStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see SimpleJava.SimpleJavaPackage#getJavaWorkflowMethod_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JavaStatement> getStatements();
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaWorkflowMethod
