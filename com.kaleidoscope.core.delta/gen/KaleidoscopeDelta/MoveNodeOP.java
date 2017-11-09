/**
 */
package KaleidoscopeDelta;

import org.eclipse.emf.ecore.EObject;
// <-- [user defined imports]
// [user defined imports] -->

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move Node OP</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link KaleidoscopeDelta.MoveNodeOP#getNewIndex <em>New Index</em>}</li>
 *   <li>{@link KaleidoscopeDelta.MoveNodeOP#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMoveNodeOP()
 * @model
 * @generated
 */
public interface MoveNodeOP extends Operation {
	/**
	 * Returns the value of the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Index</em>' attribute.
	 * @see #setNewIndex(int)
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMoveNodeOP_NewIndex()
	 * @model
	 * @generated
	 */
	int getNewIndex();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.MoveNodeOP#getNewIndex <em>New Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Index</em>' attribute.
	 * @see #getNewIndex()
	 * @generated
	 */
	void setNewIndex(int value);

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
	 * @see KaleidoscopeDelta.KaleidoscopeDeltaPackage#getMoveNodeOP_Node()
	 * @model required="true"
	 * @generated
	 */
	EObject getNode();

	/**
	 * Sets the value of the '{@link KaleidoscopeDelta.MoveNodeOP#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(EObject value);
	// <-- [user code injected with eMoflon]

	// [user code injected with eMoflon] -->
} // MoveNodeOP
