/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Node OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.AddNodeOP#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAddNodeOP()
 * @model
 * @generated
 */
public interface AddNodeOP extends Operation {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(EObject)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getAddNodeOP_Node()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getNode();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.AddNodeOP#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(EObject value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // AddNodeOP
