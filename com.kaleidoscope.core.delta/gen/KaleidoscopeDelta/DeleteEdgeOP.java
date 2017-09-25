/**
 */
package KaleidoscopeDelta;

// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Edge OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.DeleteEdgeOP#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getDeleteEdgeOP()
 * @model
 * @generated
 */
public interface DeleteEdgeOP extends Operation {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' containment reference.
	 * @see #setEdge(Edge)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getDeleteEdgeOP_Edge()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.DeleteEdgeOP#getEdge <em>Edge</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' containment reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // DeleteEdgeOP
