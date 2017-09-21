/**
 */
package SimpleJava;

import org.eclipse.emf.common.util.EList;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Method Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaMethodInvocation#getArguments <em>Arguments</em>}</li>
 *   <li>{@link SimpleJava.JavaMethodInvocation#getName <em>Name</em>}</li>
 *   <li>{@link SimpleJava.JavaMethodInvocation#isInitialization <em>Initialization</em>}</li>
 *   <li>{@link SimpleJava.JavaMethodInvocation#getOptionalExpression <em>Optional Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaMethodInvocation()
 * @model
 * @generated
 */
public interface JavaMethodInvocation extends JavaExpression {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link SimpleJava.JavaExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see SimpleJava.SimpleJavaPackage#getJavaMethodInvocation_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JavaExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see SimpleJava.SimpleJavaPackage#getJavaMethodInvocation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaMethodInvocation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Initialization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization</em>' attribute.
	 * @see #setInitialization(boolean)
	 * @see SimpleJava.SimpleJavaPackage#getJavaMethodInvocation_Initialization()
	 * @model
	 * @generated
	 */
	boolean isInitialization();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaMethodInvocation#isInitialization <em>Initialization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization</em>' attribute.
	 * @see #isInitialization()
	 * @generated
	 */
	void setInitialization(boolean value);

	/**
	 * Returns the value of the '<em><b>Optional Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Expression</em>' containment reference.
	 * @see #setOptionalExpression(JavaExpression)
	 * @see SimpleJava.SimpleJavaPackage#getJavaMethodInvocation_OptionalExpression()
	 * @model containment="true"
	 * @generated
	 */
	JavaExpression getOptionalExpression();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaMethodInvocation#getOptionalExpression <em>Optional Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional Expression</em>' containment reference.
	 * @see #getOptionalExpression()
	 * @generated
	 */
	void setOptionalExpression(JavaExpression value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaMethodInvocation
