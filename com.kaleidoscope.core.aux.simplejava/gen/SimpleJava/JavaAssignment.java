/**
 */
package SimpleJava;

// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SimpleJava.JavaAssignment#getRhs <em>Rhs</em>}</li>
 *   <li>{@link SimpleJava.JavaAssignment#getLhs <em>Lhs</em>}</li>
 * </ul>
 * </p>
 *
 * @see SimpleJava.SimpleJavaPackage#getJavaAssignment()
 * @model
 * @generated
 */
public interface JavaAssignment extends JavaExpression {
	/**
	 * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rhs</em>' containment reference.
	 * @see #setRhs(JavaExpression)
	 * @see SimpleJava.SimpleJavaPackage#getJavaAssignment_Rhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JavaExpression getRhs();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaAssignment#getRhs <em>Rhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rhs</em>' containment reference.
	 * @see #getRhs()
	 * @generated
	 */
	void setRhs(JavaExpression value);

	/**
	 * Returns the value of the '<em><b>Lhs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lhs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lhs</em>' containment reference.
	 * @see #setLhs(JavaExpression)
	 * @see SimpleJava.SimpleJavaPackage#getJavaAssignment_Lhs()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JavaExpression getLhs();

	/**
	 * Sets the value of the '{@link SimpleJava.JavaAssignment#getLhs <em>Lhs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lhs</em>' containment reference.
	 * @see #getLhs()
	 * @generated
	 */
	void setLhs(JavaExpression value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // JavaAssignment
