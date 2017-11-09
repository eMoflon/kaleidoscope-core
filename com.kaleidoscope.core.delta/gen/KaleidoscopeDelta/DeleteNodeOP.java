/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Node OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.DeleteNodeOP#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getDeleteNodeOP()
 * @model
 * @generated
 */
public interface DeleteNodeOP extends Operation {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(EObject)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getDeleteNodeOP_Node()
	 * @model required="true"
	 * @generated
	 */
	EObject getNode();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.DeleteNodeOP#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(EObject value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // DeleteNodeOP
