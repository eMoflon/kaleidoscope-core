/**
 */
package SimpleJava;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaStatement#getNext <em>Next</em>}</li>
 *   <li>{@link SimpleJava.JavaStatement#getPrev <em>Prev</em>}</li>
 *   <li>{@link SimpleJava.JavaStatement#getExpr <em>Expr</em>}</li>
 *   <li>{@link SimpleJava.JavaStatement#isReturn <em>Return</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaStatement()
 * @model
 * @generated
 */
public interface JavaStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' containment reference.
	 * @see #setNext(JavaStatement)
	 * @see SimpleJava.SimpleJavaPackage#getJavaStatement_Next()
	 * @model containment="true"
	 * @generated
	 */
	JavaStatement getNext();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaStatement#getNext <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' containment reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(JavaStatement value);

	/**
	 * Returns the value of the '<em><b>Prev</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev</em>' containment reference.
	 * @see #setPrev(JavaStatement)
	 * @see SimpleJava.SimpleJavaPackage#getJavaStatement_Prev()
	 * @model containment="true"
	 * @generated
	 */
	JavaStatement getPrev();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaStatement#getPrev <em>Prev</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev</em>' containment reference.
	 * @see #getPrev()
	 * @generated
	 */
	void setPrev(JavaStatement value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(JavaExpression)
	 * @see SimpleJava.SimpleJavaPackage#getJavaStatement_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JavaExpression getExpr();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaStatement#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(JavaExpression value);

	/**
	 * Returns the value of the '<em><b>Return</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return</em>' attribute.
	 * @see #setReturn(boolean)
	 * @see SimpleJava.SimpleJavaPackage#getJavaStatement_Return()
	 * @model
	 * @generated
	 */
	boolean isReturn();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaStatement#isReturn <em>Return</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return</em>' attribute.
	 * @see #isReturn()
	 * @generated
	 */
	void setReturn(boolean value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaStatement
